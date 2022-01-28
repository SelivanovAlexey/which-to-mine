package me.onedigit.whichtomine.config;

import me.onedigit.whichtomine.handlers.RestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class Router {

    @Bean
    public RouterFunction<ServerResponse> route(RestHandler restHandler){
        return RouterFunctions
                .route(RequestPredicates.GET("/gpu"), restHandler::getGpuHashrateInfo);
    }
}
