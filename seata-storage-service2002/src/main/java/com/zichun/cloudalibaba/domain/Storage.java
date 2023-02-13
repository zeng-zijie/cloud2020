package com.zichun.cloudalibaba.domain;

import lombok.Data;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/2/13 10:38
 */
@Data
public class Storage {

    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}

