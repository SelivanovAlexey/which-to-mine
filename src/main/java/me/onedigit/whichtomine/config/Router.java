package me.onedigit.whichtomine.config;

import me.onedigit.whichtomine.handlers.RestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class Router {

    private final static String GPU_INFO_ENDPOINT="/gpu";

    @Bean
    public RouterFunction<ServerResponse> route(RestHandler restHandler){
        return RouterFunctions
                .route(RequestPredicates.GET(GPU_INFO_ENDPOINT), restHandler::getGpuHashrateInfo);
    }
}
