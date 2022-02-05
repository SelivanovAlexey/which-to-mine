package me.onedigit.whichtomine.handlers;

import me.onedigit.whichtomine.adapters.NiceHashAdapter;
import me.onedigit.whichtomine.model.NiceHashDeviceItem;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class RestHandler {

    private final NiceHashAdapter nhAdapter;

    public RestHandler(NiceHashAdapter nhAdapter) {
        this.nhAdapter = nhAdapter;
    }

    public Mono<ServerResponse> getGpuHashrateInfo(ServerRequest request) {
        Mono<List<NiceHashDeviceItem>> devices = nhAdapter.getDevices();
        return ServerResponse.ok().body(devices, List.class);
    }
}
