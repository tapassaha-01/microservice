package com.microservice.Orderservice.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Configuration
public class WebConfig {

    @Bean
    public WebClient webClint(){
        return WebClient.builder().build();
    }
}
