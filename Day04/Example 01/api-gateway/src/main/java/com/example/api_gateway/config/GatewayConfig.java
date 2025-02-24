package com.example.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

        @Bean
        public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
            return builder.routes()
                    .route("product-service", r -> r.path("/product/**")
                            .uri("http://localhost:8081"))
                    .route("order-service", r -> r.path("/orders/**")
                            .uri("http://localhost:8082"))
                    .build();
        }

}
