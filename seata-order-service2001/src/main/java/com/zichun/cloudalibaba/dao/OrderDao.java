package com.zichun.cloudalibaba.dao;

import com.zichun.cloudalibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/2/12 20:07
 */

@Mapper
public interface OrderDao {

    void create(Order order);

    //修改订单状态, 0 --> 1
    void update(@Param("userId") Long userId, @Param("status") Integer status);


}
