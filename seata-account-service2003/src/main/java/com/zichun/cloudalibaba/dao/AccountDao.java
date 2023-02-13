package com.zichun.cloudalibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/2/13 10:57
 */
@Mapper
public interface AccountDao {
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
