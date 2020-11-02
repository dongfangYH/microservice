package com.example.zuul.gray;

import com.netflix.loadbalancer.AbstractServerPredicate;
import com.netflix.loadbalancer.PredicateKey;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-11-02 17:07
 **/
public abstract class DiscoveryEnabledPredicate extends AbstractServerPredicate {

    @Override
    public boolean apply(PredicateKey key) {
        return key != null && key.getServer() instanceof DiscoveryEnabledServer &&
                apply((DiscoveryEnabledServer)key.getServer());
    }

    protected abstract boolean apply(DiscoveryEnabledServer server);
}
