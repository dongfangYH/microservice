package com.example.gateway.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-10-26 10:33
 **/
public class WeightRule extends AbstractLoadBalancerRule {

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return chooseByWeight(getLoadBalancer(), key);
    }

    private Server chooseByWeight(ILoadBalancer loadBalancer, Object key) {
        List<Server> serverList = loadBalancer.getReachableServers();
        serverList = serverList.stream()
                               .filter(p -> p.isReadyToServe())
                               .collect(Collectors.toList());


        if (CollectionUtils.isEmpty(serverList)){
            return null;
        }

        return serverList.get(0);
    }
}
