package me.onedigit.whichtomine.handlers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.SneakyThrows;
import me.onedigit.whichtomine.model.NiceHashDeviceItem;
import me.onedigit.whichtomine.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class RestHandler {

    private final WebClient niceHashWebClient;
    private final ObjectMapper objectMapper;

    public RestHandler(@Qualifier("niceHashApiClient") WebClient niceHashWebClient, ObjectMapper objectMapper) {
        this.niceHashWebClient = niceHashWebClient;
        this.objectMapper = objectMapper;
    }

    public Mono<ServerResponse> getGpuHashrateInfo(ServerRequest request) {
        Mono<List<NiceHashDeviceItem>> devices = niceHashWebClient
                .get()
                .uri("main/api/v2/public/profcalc/devices")
                .retrieve()
                .bodyToMono(JsonNode.class)
                .map(node ->
                        JsonUtils
                                .readValue(objectMapper, node.get("devices"), new TypeReference<List<NiceHashDeviceItem>>(){}));

        return ServerResponse.ok().body(devices, List.class);
    }


}
