package com.gvdroid.simple.gateway.filter;

import com.gvdroidframework.base.exception.BaseException;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义全局过滤器
 *
 * @author Colin
 */
@Component
public class CustomGlobalFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        HttpHeaders headers = exchange.getRequest().getHeaders();
        String accessToken = headers.getFirst("accessToken");
        System.out.println(accessToken);

//        this.validToken(accessToken);

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }

    private void validToken(String accessToken) {
        try {
            //TODO 使用PassportTemplate
//            TokenUtils.checkToken(accessToken);
        } catch (BaseException e) {
            throw e;
        }
    }
}
