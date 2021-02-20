package com.shaoteemo.service;

import com.shaoteemo.service.impl.ClientServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 所属项目：SpringCloud
 * 所属包：com.shaoteemo.service
 *
 * @author Smart-T
 * @since 2020/12/30
 */
//添加Feign注解并指定服务名称
@FeignClient(
        value = "${custom.serviceName}",
        fallback = ClientServiceImpl.class
)
public interface ClientService extends ServiceApi{
}
