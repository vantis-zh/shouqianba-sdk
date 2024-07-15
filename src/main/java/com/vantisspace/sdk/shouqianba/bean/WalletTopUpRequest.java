package com.vantisspace.sdk.shouqianba.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class WalletTopUpRequest extends WalletAbsRequest {
    /**
     * 商户订单号
     */
    private String orderNo;
    /**
     * 充值金额 单位为 元
     */
    private BigDecimal amount;
    /**
     * 充值净额 比如赠送 则为 0
     */
    private BigDecimal netAmount;
    /**
     * 卡号
     */
    private String cardNumber;

    /**
     * 主题
     */
    private String subject;
}
