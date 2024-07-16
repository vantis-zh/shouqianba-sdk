package com.vantisspace.sdk.shouqianba.litepos.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CardRefundResponseData {
    /**
     * 1, 64 核销订单号
     */
    private String trade_no;
    /**
     * 1, 64 商户订单号
     */
    private String out_trade_no;
    /**
     * 交易状态
     */
    private String trade_status;
    /**
     * 1, 11 退款总金额
     */
    private BigDecimal refund_fee;
    /**
     * 1, 32 退款支付时间
     */
    private String gmt_refund_pay;
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
     * 1, 不限 交易退款使用的资金渠道
     */
    private List<RefundFundBill> refund_fund_bill_list;
}
