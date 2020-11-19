package com.example.service.config;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Properties;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-11-04 14:47
 **/
@Component
@EnvProfileAware(profile = "local")
public class EnvProfileAwareBean {

    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Resource
    private ApplicationContext applicationContext;

    @PostConstruct
    private void init(){
        System.out.println(
                "---------start-----------"
        );
        System.out.println(properties);
        System.out.println(applicationContext);
        System.out.println(
                "---------end--------------"
        );
    }
}
