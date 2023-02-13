package com.zichun.cloudalibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/2/13 10:31
 */
@Mapper
public interface StorageDao {

    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
