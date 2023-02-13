package com.zichun.cloudalibaba.controller;

import com.zichun.cloudalibaba.domain.CommonResult;
import com.zichun.cloudalibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/2/13 10:48
 */

@RestController
@Slf4j
public class StorageController {

    @Resource
    private StorageService storageService;


    /**
     * 扣减库存
     */
    @PostMapping("/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功！");
    }
}
