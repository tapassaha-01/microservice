package com.microservice.Orderservice.Config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Configuration
public class WebConfig {

    @Bean
    @LoadBalanced
    public WebClient.Builder webClintBuilder(){
        return WebClient.builder();
    }
}
