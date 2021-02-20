package com.shaoteemo.controller;

import com.shaoteemo.pojo.User;
import com.shaoteemo.service.ServiceApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * 所属项目：SpringCloud
 * 所属包：com.shaoteemo.controller
 *
 * @author Smart-T
 * @since 2020/12/23
 */
//继承ServiceApi中的接口
@RestController
public class ServiceController implements ServiceApi {

    @Override
    public List<String> testFeign() {
        return Arrays.asList("测试OpenFeign", "200OK返回结果");
    }

    @Override
    public User getMultiParams(Integer userId, String userName) {
        System.out.println("getMultiParams Running...");
        return new User(userId, userName);
    }

    @Override
    public User postMultiParams(Integer userId, String userName) {
        System.out.println("postMultiParams Running...");
        return new User(userId, userName);
    }

    @Override
    public User postObjectParam(User user) {
        System.out.println("postObjectParam Running...");
        return user;
    }
}
