package com.vantisspace.sdk.shouqianba.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 礼品卡消费记录VO类
 */
@Data
public class CardConsumedRecordVO implements Serializable {
    private String date; //订单日期
    private String time; //订单时间
    //    private String merchantName;//商户名称
//    private String merchantSn; //商户编号
    private String storeName; //门店名称
    private String storeSn; //门店编号
    private String cardNumber; //消费卡号
    private String cardName; //消费的卡的卡名称
    //    private String cardSurfaceName; //卡名名称
//    private String cardSurfaceUrl; //url
    private String clientSn; //商户订单号
    private String tradeNo; //交易流水号
    private Integer orderStatus; //订单状态 1：核销成功 2：退款成功 3：核销失败 4：退款失败 5：订单状态未知
    private String orderStatusStr;
    private Integer orderType; //订单类型 1：收款 2：退款
    private String orderTypeStr;
    private String orderAmount; //订单金额，以分为单位
    private String redeemAmount; //核销金额，以分为单位
    //    private String redeemNetAmount; //核销净额，以分为单位
//    private String discountRate; //折扣率
//    private String cardBeforeAmount; //核销之前卡的余额，以分为单位
    private String cardAfterAmount; //核销之后卡的余额，以分为单位
//        private String cardBeforeNetAmount; //核销之前卡的净额，以分为单位
//        private String cardAfterNetAmount; //核销之后卡的净额，以分为单位
}
