package me.onedigit.whichtomine.adapters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import me.onedigit.whichtomine.model.NicehashDeviceItem;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class NicehashAdapter {

    private final WebClient niceHashWebClient;
    private final ObjectMapper objectMapper;

    public NicehashAdapter(@Qualifier("niceHashApiClient") WebClient niceHashWebClient, ObjectMapper objectMapper) {
        this.niceHashWebClient = niceHashWebClient;
        this.objectMapper = objectMapper;
    }

    public Mono<List<NicehashDeviceItem>> getDevices() {
        Mono<JsonNode> devicesMono =  niceHashWebClient
                .get()
                .uri("/main/api/v2/public/profcalc/devices")
                .retrieve()
                .bodyToMono(JsonNode.class);

        return devicesMono.map(this::extractDevicesAsList);
    }

    @SneakyThrows
    private List<NicehashDeviceItem> extractDevicesAsList(JsonNode node){
        return objectMapper
                .readerFor(new TypeReference<List<NicehashDeviceItem>>(){})
                .readValue(node.get("devices"));
    }
}
