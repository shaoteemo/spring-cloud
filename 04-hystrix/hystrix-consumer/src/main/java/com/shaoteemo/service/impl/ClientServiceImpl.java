package com.shaoteemo.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.shaoteemo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
/* *
 *
 * 请求缓存实现(redis)。
 *
 * 在类上加该注解当前类型可以使用缓存
 * cacheNames:命名相当于'组'
 *
 */
@CacheConfig(cacheNames = "com.shaoteemo.hystrix.cache")
public class ClientServiceImpl implements ClientService {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Override
    /* *
     *
     * GET请求幂等操作。读缓存中数据
     * @Cacheable(key)
     *
     *
     * @Cacheable:将当前方法返回数据存储到缓存中，
     *  当方法使用该注解时都会首先访问缓存并返回数据，如果没有数据则访问远程数据。
     *  访问远程客户端的数据先进行缓存，然后再返回个客户端。
     *  请求缓存会出现缓存数据不一致的情况。缓存数据过期、失效、脏数据等情况。
     *
     *
     *  <<<<使用了请求缓存来处理幂等性请求，则在非幂等请求操作中必须管理缓存，避免缓存数据错误。>>>>
     *
     *
     */
    @Cacheable("testCache")
    public String testRead() {
        ServiceInstance si = this.loadBalancerClient.choose("hystrixProvider");
        //创建RestTemplate发请求
        RestTemplate restTemplate = new RestTemplate();
        StringBuilder sb = new StringBuilder();
        sb
                .append("http://")
                .append(si.getHost())
                .append(":")
                .append(si.getPort())
                .append("/").append("testRead");
        ResponseEntity<String> result = restTemplate.exchange(sb.toString(), HttpMethod.GET, null, String.class);
        return result.getBody();
    }

    @Override
    /* *
     *
     * 管理缓存
     *
     * POST请求非幂等操作。需要清理缓存防止出现脏数据
     * @CacheEvict(key)删除缓存中的数据
     *
     */
    @CacheEvict("testCache")
    public String testWrite() {
        ServiceInstance si = this.loadBalancerClient.choose("hystrixProvider");
        //创建RestTemplate发请求
        RestTemplate restTemplate = new RestTemplate();
        StringBuilder sb = new StringBuilder();
        sb
                .append("http://")
                .append(si.getHost())
                .append(":")
                .append(si.getPort())
                .append("/").append("testWrite");
        ResponseEntity<String> result = restTemplate.exchange(sb.toString(), HttpMethod.POST, null, String.class);
        return result.getBody();
    }

    /**
     * 服务降级的实现
     * <p>
     * 在当前调用的服务方法上加注解进行降级
     *
     * @return -
     */
    @HystrixCommand(
            fallbackMethod = "failBackStr",
            /* *
             * 服务熔断的实现
             *
            */
            commandProperties = {
                    //最大请求数默认20.表示10秒内请求数大于20开始熔断
                    @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, value = "10"),
                    //请求错误率默认50%
                    @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE, value = "50"),
                    //多少秒进行重试
                    @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value = "5")

            }
    )
    @Override
    public String getStr() {
        //负载均衡服务实例
        ServiceInstance si = this.loadBalancerClient.choose("hystrixProvider");
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

    public String failBackStr() {
        return "[回调方法]服务错误！已降级，处理";
    }
}
