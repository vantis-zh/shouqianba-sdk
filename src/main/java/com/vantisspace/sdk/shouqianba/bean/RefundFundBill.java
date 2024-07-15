package com.vantisspace.sdk.shouqianba.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class RefundFundBill implements Serializable {

    /**
     * 1, 32 -
     */
    private String card_number;
    /**
     * 1, 10 订单价格，精确到分
     */
    private BigDecimal total_amount;
    /**
     * 1, 10 实际支付的返回价格，精确到分
     */
    private BigDecimal pay_amount;
    /**
     * 1, 10 实际收款的返回价格，精确到分
     */
    private BigDecimal collect_amount;
}
