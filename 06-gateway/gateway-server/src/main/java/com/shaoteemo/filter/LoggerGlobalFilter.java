package com.shaoteemo.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 所属项目：SpringCloud
 * 所属包：com.shaoteemo.filter
 *
 * 全局过滤器
 *  全局过滤器不需要注册
 *
 * 日志实现
 *
 * @author Smart-T
 * @since 2021/1/27
 */
@Component
//@Slf4j
public class LoggerGlobalFilter implements GlobalFilter {

    private final Logger log = LoggerFactory.getLogger(GlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("记录日志。。。");
        log.error("日志记录...");
        return chain.filter(exchange);
    }
}
