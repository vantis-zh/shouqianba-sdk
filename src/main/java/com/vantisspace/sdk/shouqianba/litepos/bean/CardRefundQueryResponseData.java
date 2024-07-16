package com.vantisspace.sdk.shouqianba.litepos.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class CardRefundQueryResponseData implements Serializable {
    /**
     * 1, 64 核销订单号
     */
    private String trade_no;
    /**
     * 1, 64 商户订单号
     */
    private String out_trade_no;
    /**
     * 1, 64 商户订单号
     */
    private String out_request_no;
    /**
     * 0-1, 256 退款的原因说明
     */
    private String refund_reason;
    /**
     * 0-1, 11 支付金额
     */
    private String pay_amount;
    /**
     * 1, 11 交易金额
     */
    private BigDecimal total_amount;
    /**
     * 1, 11 实收金额
     */
    private String collect_amount;
    /**
     * 0-1	 不限退款使用的资金渠道
     */
    private List<TradeFundBill> refund_fund_bill_list;
}
