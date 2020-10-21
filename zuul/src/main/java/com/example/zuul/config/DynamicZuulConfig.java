package com.example.zuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-10-21 16:19
 **/
@Configuration
public class DynamicZuulConfig {

    @Autowired
    private ZuulProperties zuulProperties;

    @Autowired
    private ServerProperties serverProperties;

    @Bean
    public DynamicZuulRouteLocator routeLocator(){
        DynamicZuulRouteLocator routeLocator = new DynamicZuulRouteLocator(serverProperties.getServlet().getContextPath(), zuulProperties);
        return routeLocator;
    }
}
