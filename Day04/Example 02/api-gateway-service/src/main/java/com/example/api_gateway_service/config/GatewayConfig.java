package com.example.api_gateway_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route("student-service",predicateSpec -> predicateSpec.path("")
                        .uri(""))
                .route("faculty-service",predicateSpec -> predicateSpec.path("")
                        .uri(""))
                .route("course-service",predicateSpec -> predicateSpec.path("")
                        .uri(""))
                .build();


    }
}
