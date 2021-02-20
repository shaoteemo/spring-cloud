package com.shaoteemo.service;

import com.shaoteemo.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 所属项目：SpringCloud
 * 所属包：com.shaoteemo.service
 *
 * @author Smart-T
 * @since 2020/12/30
 */
public interface ServiceApi {


    /**
     * 请求不传递任何参数
     * @return 测试字符串
     */

    @RequestMapping(value = "/test" , method = RequestMethod.GET)
    List<String> testFeign();


    /**     * 为Feign定义服务标准时，有请求参数的方法，必须使用@RequestParam注解描述
     * 且无论方法名参数名和请求参数名是否一直，都需要定义@RequestParam注解的value/name属性。否则报错
     * @param userId 用户ID
     * @param userName 用户名
     * @return 用户
     */
    @GetMapping("/getUser")
    User getMultiParams(
            @RequestParam("id") Integer userId,
            @RequestParam("name") String userName
    );


    @PostMapping("/postUser")
    User postMultiParams(
            @RequestParam("id") Integer userId,
            @RequestParam("name") String userName
    );


    /**
     * 如果是对象则需要＋@RequestBody
     * @param user 对象
     * @return 用户
     */
    @PostMapping("/postObjectParam")
    User postObjectParam(@RequestBody User user);



}
