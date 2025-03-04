package com.example.api_gateway_service.gatewayconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("account-service", r -> r.path("/account/**")
                        .uri("http://localhost:8084"))
                .route("loan-service", r -> r.path("/loan/**")
                        .uri("http://localhost:8083"))
                .route("transaction-service", r -> r.path("/transaction/**")
                        .uri("http://localhost:8082"))
                .route("user-service", r -> r.path("/user/**")
                        .uri("http://localhost:8081"))
                .build();
    }

}
