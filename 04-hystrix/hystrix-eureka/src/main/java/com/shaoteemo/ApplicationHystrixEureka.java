package com.shaoteemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 所属项目：SpringCloud
 * 所属包：com.shaoteemo
 *
 * @author Smart-T
 * @since 2021/01/13
 */
@SpringBootApplication
@EnableEurekaServer
public class ApplicationHystrixEureka {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationHystrixEureka.class,args);
    }

}
