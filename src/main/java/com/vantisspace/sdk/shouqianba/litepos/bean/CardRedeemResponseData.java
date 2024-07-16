package com.vantisspace.sdk.shouqianba.litepos.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class CardRedeemResponseData implements Serializable {
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
    /**
     * 1, 32 交易支付时间
     */
    private String gmt_payment;
    /**
     * 1, 不限 交易支付使用的资金渠道
     */
    private List<RedeemFundBill> redeem_fund_bill_list;
}
