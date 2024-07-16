package com.vantisspace.sdk.shouqianba.litepos.common.bean;

public interface OrderStatus {
    // 支付状态, 1:待操作; 2:支付中; 3:支付成功; 4:退款中; 5:退款成功;6:退款失败;7:支付失败;8:未知状态;
    // 订单状态0：已取消，1：待操作，2：操作中，3：等待结果中，4：操作完成，5：部分完成，6：操作失败，7：已终止
    String PENDING = "1";
    String OPERATING = "2";
    String PAID = "3";
    String REFUNDING = "4";
    String REFUNDED = "5";
    String REFUND_FAILED = "6";
    String PAY_FAILED = "7";
    String UNKNOWN = "7";
}
