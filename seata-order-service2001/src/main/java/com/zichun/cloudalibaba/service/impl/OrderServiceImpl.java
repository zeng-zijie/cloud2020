package com.zichun.cloudalibaba.service.impl;

import com.zichun.cloudalibaba.dao.OrderDao;
import com.zichun.cloudalibaba.domain.Order;
import com.zichun.cloudalibaba.service.AccountService;
import com.zichun.cloudalibaba.service.OrderService;
import com.zichun.cloudalibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/2/12 20:37
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;



    @Override
    public void create(Order order) {
        log.info("-----> 1. 开始新建订单");
        orderDao.create(order);

        log.info("-----> 2.1 订单微服务开始调用 库存 服务,扣减库存 Count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("-----> 2.2 订单微服务开始调用 库存 服务,扣减库存 ---end");

        log.info("-----> 3.1 订单微服务开始调用 账户 服务,扣减库存 Money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("-----> 3.2 订单微服务开始调用 账户 服务,扣减库存 ---end");

        //修改订单状态 0 --> 1
        log.info("-----> 4.1 修改订单状态 开始");
        orderDao.update(order.getUserId(), 0);
        log.info("-----> 4.2 修改订单状态 结束");
        log.info("-----> 5. 订单创建完成 ~~~ ");
    }

    @Override
    public void update(Long userId, Integer status) {
        orderDao.update(userId, status);
    }
}
