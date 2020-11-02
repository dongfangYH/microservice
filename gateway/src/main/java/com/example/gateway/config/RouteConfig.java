package com.example.gateway.config;

import com.example.gateway.filter.TokenGlobalFilter;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class RouteConfig {

    @Bean
    WeightRule weightRule(){
        return new WeightRule();
    }


    /*@Bean
    public TokenGlobalFilter tokenFilter(){
        return new TokenGlobalFilter();
    }*/

    /*@Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/get/**")
                .filters(f -> f.filter(new MyFilter()))
                        .uri("http://www.baidu.com")
                        .order(0)
                        .id("customer_filter_router"))
                        .build();
    }*/
}

