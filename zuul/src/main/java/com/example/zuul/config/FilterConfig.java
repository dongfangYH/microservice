package com.example.zuul.config;

import com.example.zuul.filter.AuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-10-21 10:44
 **/
@Configuration
public class FilterConfig {

    @Bean
    AuthFilter authFilter(){
        return new AuthFilter();
    }
}
