package com.shaoteemo.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * 所属项目：SpringCloud
 * 所属包：com.shaoteemo.filter
 *
 * 局部路由过滤器
 *
 * 自定义token验证器
 * 命名规范：（自定义名称）GatewayFilterFactory
 *
 *
 * @author Smart-T
 * @since 2021/1/27
 */

/* *
 * 泛型定义文档
 *
 */
@Component
public class AuthenticationGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthenticationGatewayFilterFactory.Config> {

    /**
     * 用于转换类型 apply方法参数中的类型
     */
    public AuthenticationGatewayFilterFactory() {
        super(AuthenticationGatewayFilterFactory.Config.class);
    }

    /**
     * 读取yml文件中过滤器token<key>值赋予程序当中
     *
     * @return -
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("tokenName");
    }

    /**
     * 完成核心过滤业务逻辑
     *
     * @param config -
     * @return -
     */
    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {
            @Override
            //ServerWebExchange:中包含服务网络交换器，存放着重要的请求-响应属性。请求实例和响应实例。
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                String token = exchange.getRequest().getQueryParams().getFirst(config.getTokenName());
                //认证失败
                if (token == null || token.isEmpty()) {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    //结束相应
                    return exchange.getResponse().setComplete();
                }
                //放行
                return chain.filter(exchange);
            }
        };
    }

    public static class Config {
        private String tokenName;

        public String getTokenName() {
            return tokenName;
        }

        public void setTokenName(String tokenName) {
            this.tokenName = tokenName;
        }
    }

}
