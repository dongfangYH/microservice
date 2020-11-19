package com.example.service.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-11-04 14:22
 **/
@Component
public class EnvProfileAwareBeanPostProcessor implements BeanPostProcessor {

    @Resource
    private ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (bean.getClass().isAnnotationPresent(EnvProfileAware.class)){
            EnvProfileAware annotation = bean.getClass().getAnnotation(EnvProfileAware.class);
            String profile = annotation.profile();
            String[] activeProfiles = applicationContext.getEnvironment().getActiveProfiles();
            if (StringUtils.hasText(profile)){
                profile = profile + ((activeProfiles.length > 0 ? ("-" + activeProfiles[0]) : "") + ".properties");
                ClassPathResource resource = new ClassPathResource(profile);
                if (resource.exists()){
                    try {
                        Properties properties = PropertiesLoaderUtils.loadProperties(resource);
                        Field field = ReflectionUtils.findField(bean.getClass(), "properties");
                        if (field != null){
                            ReflectionUtils.makeAccessible(field);
                            ReflectionUtils.setField(field, bean, properties);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return bean;
    }
}
