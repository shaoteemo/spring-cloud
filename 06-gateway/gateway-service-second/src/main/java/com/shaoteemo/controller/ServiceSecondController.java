package com.shaoteemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 所属项目：SpringCloud
 * 所属包：com.shaoteemo.controller
 *
 * @author Smart-T
 * @since 2021/1/20
 */
@RestController
public class ServiceSecondController {

    @GetMapping("/show")
    public Object showInfo(){
        return "ServiceSecondController.showInfo";
    }

}
