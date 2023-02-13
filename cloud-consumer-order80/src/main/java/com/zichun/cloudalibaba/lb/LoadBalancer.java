package com.zichun.cloudalibaba.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/1/29 15:52
 */
public interface LoadBalancer {


    /**
     * 自定义负载均衡算法
     *
     * @param serviceInstances 目标服务实例
     * @return {@link ServiceInstance}
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
