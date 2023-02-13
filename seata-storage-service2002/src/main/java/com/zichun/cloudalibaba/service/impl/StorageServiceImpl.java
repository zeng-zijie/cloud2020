package com.zichun.cloudalibaba.service.impl;

import com.zichun.cloudalibaba.dao.StorageDao;
import com.zichun.cloudalibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/2/13 10:43
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

//todo logger
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageDao.decrease(productId,count);
        log.info("修改库存完成 --> productId:"+ productId +" count: "+count);
        log.info("------->storage-service中扣减库存结束");
    }
}
