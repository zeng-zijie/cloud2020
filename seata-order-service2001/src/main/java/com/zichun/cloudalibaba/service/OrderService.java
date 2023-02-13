package com.zichun.cloudalibaba.service;

import com.zichun.cloudalibaba.domain.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/2/12 20:35
 */
public interface OrderService {
    void create(Order order);

    void update(Long userId,Integer status);
}
