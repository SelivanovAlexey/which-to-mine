package me.onedigit.whichtomine.handlers;

import me.onedigit.whichtomine.adapters.NiceHashAdapter;
import me.onedigit.whichtomine.model.dto.DeviceDto;
import me.onedigit.whichtomine.model.NiceHashDeviceItem;
import me.onedigit.whichtomine.service.NiceHashMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestHandler {

    private final NiceHashAdapter nhAdapter;
    private final NiceHashMapper mapper;

    public RestHandler(NiceHashAdapter nhAdapter, NiceHashMapper mapper) {
        this.nhAdapter = nhAdapter;
        this.mapper = mapper;
    }

    public Mono<ServerResponse> getGpuHashrateInfo(ServerRequest request) {
        Mono<List<NiceHashDeviceItem>> devices = nhAdapter.getDevices();

        Mono<List<DeviceDto>> convertedDevices =
                devices.map(dv -> dv.stream().map(i -> mapper.map(i, new DeviceDto())).collect(Collectors.toList()));

        return ServerResponse.ok().body(
                convertedDevices,
                List.class);
    }
}
