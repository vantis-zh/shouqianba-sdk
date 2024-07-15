package com.vantisspace.sdk.shouqianba.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class WalletTopUpResponseData implements Serializable {
    /**
     * 商户订单号
     */
    private String out_trade_no;
    /**
     * CREATED	订单已创建/支付中
     * CLOSED	交易已结束，未在指定时间内完成付款
     * PAID	订单支付成功
     * PAY_CANCELED	支付失败并且已经成功充正，或被付款人取消
     * PAY_ERROR	支付失败，不确定是否已经成功充正
     * REFUNDED	已成功全额退款
     * PARTIAL_REFUNDED	已成功部分退款
     * REFUND_ERROR	退款失败
     * INVALID_STATUS_CODE	无效的状态码
     */
    private String status;
    /**
     * 需要充值对应账户的编号
     */
    private String card_number;
    /**
     * 充值之后当前的余额，精确到分
     */
    private String balance;
    /**
     * 充值之后当前的净额，精确到分
     */
    private String net_balance;
    /**
     * 充值金额，精确到分
     */
    private String amount;
    /**
     * 充值净额，精确到分
     */
    private String net_amount;
}
