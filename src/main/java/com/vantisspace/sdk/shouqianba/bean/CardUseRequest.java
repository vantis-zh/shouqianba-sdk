package com.vantisspace.sdk.shouqianba.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CardUseRequest implements Serializable {
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 1, wechat; 2,alipay
     */
    private String userChannel = "1";
    /**
     * 用户身份
     */
    private String userNo;
    /**
     * 金额
     */
    private BigDecimal amount;
}
