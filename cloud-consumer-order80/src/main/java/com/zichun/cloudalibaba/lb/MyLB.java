package com.zichun.cloudalibaba.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/1/29 15:56
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);


    /**
     * 访问数量 +1
     * 使用 CAS + 自旋锁
     *
     * @return int
     */
    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("***** next = "+ next);
        return next;
    }

    /**
     * 获取服务的机器总数
     * 负载均衡策略 : 轮询
     * rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标  ，每次服务重启动后rest接口计数从1开始。
     *
     * @param serviceInstances 服务实例
     * @return {@link ServiceInstance}
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
