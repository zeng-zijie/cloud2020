package com.zichun.cloudalibaba.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/2/13 10:42
 */
public interface StorageService {
    void decrease(Long productId, Integer count);
}
