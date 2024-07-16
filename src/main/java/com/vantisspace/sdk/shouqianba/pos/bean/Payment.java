package com.vantisspace.sdk.shouqianba.pos.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Payment implements Serializable {
    /**
     * 活动类型
     */
    private PaymentType type;
    /**
     * 活动金额
     */
    private BigDecimal amount_total;
}
