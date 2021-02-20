package com.shaoteemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 所属项目：SpringCloud
 * 所属包：com.shaoteemo.controller
 *
 * @author Smart-T
 * @since 2020/12/23
 */
@RestController
public class ServiceController {

    @GetMapping
    public Object getRibbon(){
        return "SpringCloudNetflixRibbon开发服务提供者";
    }

}
