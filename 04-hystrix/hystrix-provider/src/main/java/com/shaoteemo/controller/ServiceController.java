package com.shaoteemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;

/**
 * 所属项目：SpringCloud
 * 所属包：com.shaoteemo.controller
 *
 * @author Smart-T
 * @since 2020/12/23
 */
@RestController
public class ServiceController {

    @PostMapping("/testWrite")
    public Object testWrite() {
        System.out.println("testWrite");
        return "写操作";
    }

    @GetMapping("/testRead")
    public Object testRead() {
        System.out.println("testRead");
        return "读操作";
    }

    @GetMapping
    public Object getRibbon() {
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return "SpringCloudNetflixRibbon开发服务提供者";
    }

    /**
     * Hystrix服务降级熔断测试
     *
     * @return -
     */
    @GetMapping("/test")
    public Object testOpenFeignHystrix() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Collections.singletonList("测试OpenFeignHystrix服务方返回的数据");
    }

}
