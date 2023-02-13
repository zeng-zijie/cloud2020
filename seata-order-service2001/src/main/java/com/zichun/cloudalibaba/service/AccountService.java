package com.zichun.cloudalibaba.service;

import com.zichun.cloudalibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/2/12 20:41
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {
    /**
     * 扣减账户余额
     */
    //@RequestMapping(value = "/account/decrease", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
