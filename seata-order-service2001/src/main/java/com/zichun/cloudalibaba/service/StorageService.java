package com.zichun.cloudalibaba.service;

import com.zichun.cloudalibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/2/12 20:41
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    /**
     * 扣减库存
     */
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
