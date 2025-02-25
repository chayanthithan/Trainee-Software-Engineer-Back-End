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
                .route("student-service",predicateSpec -> predicateSpec.path("/student/**")
                        .uri("http://localhost:8082"))
                .route("faculty-service",predicateSpec -> predicateSpec.path("/faculty/**")
                        .uri("http://localhost:8083"))
                .route("course-service",predicateSpec -> predicateSpec.path("/course/**")
                        .uri("http://localhost:8081"))
                .build();


    }
}





















