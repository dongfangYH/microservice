package com.example.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class MyFilter implements GatewayFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put("REQUEST_TIME", System.currentTimeMillis());
        return chain.filter(exchange).then(
                Mono.fromRunnable(()->{
                    Long startTime = exchange.getAttribute("REQUEST_TIME");
                    if (startTime != null){
                        System.out.println("cost " + (System.currentTimeMillis() - startTime)/1000);
                    }
                })
        );
    }

    @Override
    public int getOrder() {
        //值越大，优先级越低
        return 0;
    }
}
