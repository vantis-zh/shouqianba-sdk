package com.vantisspace.sdk.shouqianba.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class CardRedeemQueryResponseData implements Serializable {
    /**
     * 1, 64 商户订单号
     */
    private String out_trade_no;
    /**
     * 1, 32 见 3.1
     */
    private String trade_status;
    /**
     * 1, 64 核销订单号
     */
    private String trade_no;
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
     * 1, 32 交易支付时间
     */
    private Date gmt_payment;
    /**
     * 1, 不限 交易支付使用的资金渠道
     */
    private List<RedeemFundBill> redeem_fund_bill_list;
}
