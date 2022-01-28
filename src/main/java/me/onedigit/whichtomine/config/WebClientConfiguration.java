package me.onedigit.whichtomine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {

    @Bean
    public WebClient niceHashApiClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder.baseUrl("https://api2.nicehash.com").build();
    }

    @Bean
    public WebClient minerStatApiClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder.baseUrl("https://api.minerstat.com").build();
    }
}
