package com.zichun.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zichunyoushan
 * @version 1.0.0
 * @date Created in 2023/1/18 17:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
 private Long id;
 private String serial;

}
