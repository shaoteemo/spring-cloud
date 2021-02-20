package com.shaoteemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.HashMap;

/**
 * 所属项目：parent_dependency
 * 所属包：com.shaoteemo
 *
 * 单机版Eureka
 *
 * Eureka访问地址：http://ip:port
 *
 * @author Smart-T
 * @since 2020/12/4
 */
@SpringBootApplication
@EnableEurekaServer  //启动初始化Eureka注册中心
public class ApplicationEureka {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationEureka.class,args);
    }

}
