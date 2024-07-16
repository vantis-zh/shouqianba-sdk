package com.vantisspace.sdk.shouqianba.litepos.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CardRefundRequest implements Serializable {
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 售后单号
     */
    private String afterSaleNo;
    /**
     * 金额
     */
    private BigDecimal amount;
}
