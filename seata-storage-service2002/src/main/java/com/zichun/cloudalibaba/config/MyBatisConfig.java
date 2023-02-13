package com.zichun.cloudalibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/2/12 21:02
 */
@Configuration
@MapperScan({"com.zichun.cloudalibaba.dao"})
public class MyBatisConfig {
}
