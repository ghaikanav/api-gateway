package com.practice.microservices.apigateway.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(p -> p.path("/get")
                        .filters(f -> f.addRequestHeader("x-my-header", "headerValue"))
                        .uri("http://httpbin.org:80"))
                .build();
    }
}