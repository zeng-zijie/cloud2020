package com.zichun.cloudalibaba.service.impl;

import com.zichun.cloudalibaba.dao.AccountDao;
import com.zichun.cloudalibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/2/13 11:06
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;


    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
        //模拟超时异常，全局事务回滚
        //暂停几秒钟线程
        //try { TimeUnit.SECONDS.sleep(30); } catch (InterruptedException e) { e.printStackTrace(); }
        accountDao.decrease(userId,money);
        log.info("修改账户余额完成 --> userId:"+ userId +" money: "+money);
        log.info("------->account-service中扣减账户余额结束");
    }

}
