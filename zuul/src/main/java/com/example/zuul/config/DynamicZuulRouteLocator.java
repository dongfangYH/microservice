package com.example.zuul.config;

import com.example.zuul.dao.RouterInfoDao;
import com.example.zuul.entity.RouterInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;
import org.springframework.data.domain.Example;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-10-21 16:08
 **/
public class DynamicZuulRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

    @Autowired
    private ZuulProperties zuulProperties;

    @Resource
    private RouterInfoDao routerInfoDao;

    public DynamicZuulRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
        this.zuulProperties = properties;
    }

    @Override
    public void refresh() {
        doRefresh();
    }

    @Override
    protected Map<String, ZuulRoute> locateRoutes() {
        LinkedHashMap<String, ZuulRoute> routesMap = new LinkedHashMap<>();
        routesMap.putAll(super.locateRoutes());
        routesMap.putAll(getDbRoutesMap());
        LinkedHashMap<String, ZuulRoute> values = new LinkedHashMap<>();
        routesMap.forEach((k,v) -> {
            String path = checkPath(k);
            if (StringUtils.hasText(this.zuulProperties.getPrefix())){
                path = this.zuulProperties.getPrefix() + path;
                path = checkPath(path);
            }
            values.put(path, v);
        });
        return values;
    }

    private Map<String, ZuulRoute> getDbRoutesMap() {
        List<RouterInfo> routerInfoList = routerInfoDao.findAllByEnabledTrue();
        LinkedHashMap<String, ZuulRoute> routesMap = new LinkedHashMap<>();
        for (RouterInfo routerInfo : routerInfoList){
            if (StringUtils.hasText(routerInfo.getPath())){
                ZuulRoute route = new ZuulRoute();
                route.setId(routerInfo.getId());
                route.setPath(routerInfo.getPath());
                route.setServiceId(routerInfo.getService_id());
                route.setStripPrefix(routerInfo.getStrip_prefix());
                route.setUrl(routerInfo.getUrl());
                route.setRetryable(routerInfo.getRetryable());
                routesMap.put(routerInfo.getPath(), route);
            }
        }
        return routesMap;
    }

    private String checkPath(String path){
        if (!path.startsWith("/")){
            path = "/" + path;
        }
        return path;
    }
}
