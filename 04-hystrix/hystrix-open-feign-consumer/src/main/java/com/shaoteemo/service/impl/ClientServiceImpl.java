package com.shaoteemo.service.impl;

import com.shaoteemo.pojo.User;
import com.shaoteemo.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * 所属项目：SpringCloud
 * 所属包：com.shaoteemo.service
 *
 * @author Smart-T
 * @since 2021/1/15
 */

/* *
 * 回调接口实现类
 */
@Service
public class ClientServiceImpl implements ClientService {
    /**
     * 回调方法s
     *
     * @return -
     */
    @Override
    public List<String> testFeign() {
        return Collections.singletonList("testFeign返回备用数据[服务提供方故障]");
    }

    @Override
    public User getMultiParams(Integer userId, String userName) {
        return null;
    }

    @Override
    public User postMultiParams(Integer userId, String userName) {
        return null;
    }

    @Override
    public User postObjectParam(User user) {
        return null;
    }
}
