package org.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHystrix
public class GatewayConfig {

    private AuthenticationFilter filter;

    public GatewayConfig(AuthenticationFilter filter) {
        this.filter = filter;
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/api/v1/users/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://user-service"))
                .route("task-service", r -> r.path("/api/v1/tasks/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://task-service"))
                .route("authentication-server", r -> r.path("/auth/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://authentication-server"))
                .build();
    }
}