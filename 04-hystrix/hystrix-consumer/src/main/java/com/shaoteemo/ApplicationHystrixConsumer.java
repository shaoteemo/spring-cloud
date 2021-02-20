package com.shaoteemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * 所属项目：SpringCloud
 * 所属包：com.shaoteemo
 *
 * @author Smart-T
 * @since 2021/1/13
 */
/*
    开启Hystrix的容错处理能力
    EnableCircuitBreaker可以使HystrixCommand生效
 */
@SpringBootApplication
@EnableCircuitBreaker
/* *
 *
 * <请求缓存实现>
 *
 * 开启Spring对缓存的支持
 *
 * 自动的访问缓存服务
 *
 *
 */
@EnableCaching
public class ApplicationHystrixConsumer {


    public static void main(String[] args) {
        SpringApplication.run(ApplicationHystrixConsumer.class,args);
    }

}
