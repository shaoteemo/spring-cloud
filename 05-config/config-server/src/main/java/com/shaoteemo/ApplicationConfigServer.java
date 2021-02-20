package com.shaoteemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 所属项目：SpringCloud
 * 所属包：com.shaoteemo
 *
 * @author Smart-T
 * @since 2021/1/19
 */
@SpringBootApplication
/* *
 * 开启配置中心服务端
 */
@EnableConfigServer
public class ApplicationConfigServer {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfigServer.class , args);
    }
}
