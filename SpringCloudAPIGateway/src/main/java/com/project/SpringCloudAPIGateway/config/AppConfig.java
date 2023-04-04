package com.project.SpringCloudAPIGateway.config;

import com.project.SpringCloudAPIGateway.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder locatorBuilder) {
        return locatorBuilder.routes()
                .route(p -> p
                        .path("/**")
                        .uri("http://localhost:9091/"))
                .route(p -> p
                        .path("/api/v2/**")
                        .uri("http://localhost:8081/"))
                .route(p -> p
                                .path("/**")
                        .uri("http://localhost:8083/")
                         )
                .build();
    }

    @Bean
    public FilterRegistrationBean jwtFilter()
    {
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new JwtFilter());
        filterRegistrationBean.addUrlPatterns("/api/v2/*");
        return filterRegistrationBean;
    }
}

