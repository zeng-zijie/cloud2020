package com.zichun.cloudalibaba.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/2/13 11:05
 */
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
