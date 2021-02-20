package com.shaoteemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 所属项目：SpringCloud
 * 所属包：com.shaoteemo
 *
 * @author Smart-T
 * @since 2020/12/30
 */
@SpringBootApplication
@EnableEurekaServer
public class ApplicationOpenFeignEureka {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationOpenFeignEureka.class,args);
    }

}
