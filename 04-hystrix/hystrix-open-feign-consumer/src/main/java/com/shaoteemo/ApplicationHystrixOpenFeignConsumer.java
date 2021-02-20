package com.shaoteemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 所属项目：SpringCloud
 * 所属包：com.shaoteemo
 *
 * @author Smart-T
 * @since 2020/12/30
 */
@SpringBootApplication
/*
 * 知名当前服务为使用OpenFeign技术开发的服务端
 * 属性：basePackages表明@FeignClient接口所在的包，可以忽略默认扫描项目所有包
 */
@EnableFeignClients(basePackages = "com.shaoteemo.service")
/* *
 * @EnableCircuitBreaker - 开启Hystrix容错处理能力。作用：1.使@HystrixCommand生效。2.Hystrix相关监控数据的收集
 * @EnableHystrixDashboard - 开启监控仪表盘
 * 本项目中表示开启HystrixActuator仪表盘
 */
@EnableCircuitBreaker
@EnableHystrixDashboard
public class ApplicationHystrixOpenFeignConsumer {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationHystrixOpenFeignConsumer.class, args);
    }

}
