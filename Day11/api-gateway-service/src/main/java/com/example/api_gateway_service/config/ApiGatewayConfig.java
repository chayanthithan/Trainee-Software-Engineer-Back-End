package com.example.api_gateway_service.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-service", r -> r.path("/product/**")
                        .uri("http://localhost:8084"))
                .route("supplier-service", r -> r.path("/supplier/**")
                        .uri("http://localhost:8083"))
                .route("user-management-service", r -> r.path("/user-service/**")
                        .uri("http://localhost:8082"))
                .build();
    }
}
