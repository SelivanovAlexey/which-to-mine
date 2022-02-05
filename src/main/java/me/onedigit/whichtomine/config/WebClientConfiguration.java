package me.onedigit.whichtomine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import static me.onedigit.whichtomine.constants.ApiConstants.MINERSTAT_API_BASE_URL;
import static me.onedigit.whichtomine.constants.ApiConstants.NICEHASH_API_BASE_URL;

@Configuration
public class WebClientConfiguration {

    @Bean
    public WebClient niceHashApiClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder.baseUrl(NICEHASH_API_BASE_URL).build();
    }

    @Bean
    public WebClient minerStatApiClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder.baseUrl(MINERSTAT_API_BASE_URL).build();
    }
}
