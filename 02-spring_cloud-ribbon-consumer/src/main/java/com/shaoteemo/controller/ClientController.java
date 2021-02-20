package com.shaoteemo.controller;

import com.shaoteemo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/getInfo")
    public Object getRibbon(){
        return this.clientService.getStr();
    }

}
