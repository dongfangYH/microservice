package com.example.zuul.gray;

import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-11-02 17:19
 **/
public class MetadataAwarePredicate extends DiscoveryEnabledPredicate{
    @Override
    protected boolean apply(DiscoveryEnabledServer server) {
        final RibbonFilterContext context = RibbonFilterContextHolder.getCurrentContext();
        final Set<Map.Entry<String, String>> attributes = Collections.unmodifiableSet(context.getAttributes().entrySet());
        final Map<String, String> metadata = server.getInstanceInfo().getMetadata();
        return metadata.entrySet().containsAll(attributes);
    }
}
