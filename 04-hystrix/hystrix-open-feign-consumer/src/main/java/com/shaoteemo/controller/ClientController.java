package com.shaoteemo.controller;

import com.shaoteemo.pojo.User;
import com.shaoteemo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 所属项目：SpringCloud
 * 所属包：com.shaoteemo.controller
 *
 * @author Smart-T
 * @since 2020/12/30
 */
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    /**
     * Hystrix服务降级熔断测试接口
     * @return --
     */
    @GetMapping("/test2")
    public List<String> testFeign(){
        return this.clientService.testFeign();
    }

    @GetMapping("/getMultiParams")
    public User getMultiParams(Integer id , String name , HttpServletRequest request){
        return this.clientService.getMultiParams(id, name);
    }


    @GetMapping("/postMultiParams")
    public User postMultiParams(Integer id , String name){
        return this.clientService.postMultiParams(id, name);
    }

    @GetMapping("/postObjectParams")
    public User postObjectParams(User user){
        return this.clientService.postObjectParam(user);
    }


}
