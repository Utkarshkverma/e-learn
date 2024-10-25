package com.vermau2k01053.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r->r.path("/category/**").filters(
                        f->f.rewritePath("/category/?(?<segment>.*)","/${segment}")
                ).uri("lb://category-service"))
                .route(r->r.path("/course/**").filters(
                        f->f.rewritePath("/course/?(?<segment>.*)","/${segment}")
                ).uri("lb://course-service"))
                .route(r->r.path("/video/**").filters(
                        f->f.rewritePath("/video/?(?<segment>.*)","/${segment}")
                ).uri("lb://video-service"))
                .build();
    }
}
