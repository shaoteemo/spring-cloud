package com.shaoteemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 所属项目：SpringCloud
 * 所属包：com.shaoteemo.controller
 *
 * @author Smart-T
 * @since 2021/1/20
 */
@RestController
public class ServiceFirstController {

    @GetMapping("/show")
    public Object showInfo(int age, String name , @RequestHeader String shaoteemo){
        return "ServiceFirstController.showInfo!Age:"+age +"&Name:"+name+
                "\nHeader Token Is:"+shaoteemo;
    }

}
