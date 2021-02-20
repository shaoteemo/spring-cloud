package com.shaoteemo.service.impl;

import com.shaoteemo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 所属项目：SpringCloud
 * 所属包：com.shaoteemo.service.impl
 *
 * @author Smart-T
 * @since 2020/12/23
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Override
    public String getStr() {
        //负载均衡服务实例
        ServiceInstance si = this.loadBalancerClient.choose("cloud application ribbon");
        //创建RestTemplate发请求
        RestTemplate restTemplate = new RestTemplate();
        StringBuilder sb = new StringBuilder();
        sb
                .append("http://")
                .append(si.getHost())
                .append(":")
                .append(si.getPort())
                .append("/");
        ResponseEntity<String> result = restTemplate.exchange(sb.toString(), HttpMethod.GET, null, String.class);
        return result.getBody();
    }
}
