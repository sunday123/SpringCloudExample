package com.ij34.cloud;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.RouteToRequestUrlFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Component
public class MyGatewayFilter extends RouteToRequestUrlFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token =exchange.getRequest().getHeaders().getFirst("token");
        String path =exchange.getRequest().getPath().value();
        if (path==null || !path.startsWith("/auth")){
            return chain.filter(exchange);
        }else if (token!=null && "abc".equals(token)){
            return chain.filter(exchange);
        }else {
            System.err.println("错误token："+token);
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }

    }

}