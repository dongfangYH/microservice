package com.example.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-11-03 15:01
 **/
@Component
@RefreshScope
public class ConfigInfoProperties {

    @Value("${conf.app.env}")
    private String env;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }
}
