package com.apigateway.apigateway_microservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder locatorBuilder) {
        return locatorBuilder.routes()
                .route("appbank-microservice", rt ->
                        rt
                                .path("/appbank-microservice/**")
                                .filters(f -> f.stripPrefix(1))
                                .uri("lb://APPBANK-MICROSERVICE"))
                .build();
    }
}
