package com.zichun.cloudalibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zichun.cloudalibaba.entities.CommonResult;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/2/11 21:15
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException blockException) {

        return new CommonResult(4444, "按客户自定义限流处理逻辑, 全局处理逻辑 ---> 1");
    }

    public static CommonResult handlerException2(BlockException blockException) {

        return new CommonResult(4444, "按客户自定义限流处理逻辑, 全局处理逻辑 ---> 2");
    }

}
