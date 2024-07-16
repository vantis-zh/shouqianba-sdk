package com.vantisspace.sdk.shouqianba.litepos.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Data
public class UserBalanceWithCardsVO implements Serializable {

    /**
     * 1, 字符串，最大 36 位 微信用户为 UnionID，支付宝为用户 ID
     */
    private String userId;
//    /**
//     * 1, 字符串，最大 36 位 1, wechat; 2,alipay
//     */
//    private String userChannel;

//    /**
//     * 0-1, 字符串，最大 36 位 发卡商户编号
//     */
//    private String merchantSn;
//    /**
//     * 0-1, 字符串，最大 80 位 发卡商户名称
//     */
//    private String merchantName;
    /**
     * 1, 字符串，最大 11 位 账户总可用余额，以分为单位
     */
    private String accountBalance;

    private List<Card> cards;

    @Data
    public static class Card implements Serializable {
        private String cardSurfaceName;
        /**
         * 卡面图片地址
         */
        private String cardSurfaceUrl;
        /**
         * 1, 卡号 卡号
         */
        private String cardNumber;
        /**
         * 1, 面额 面额，单位为分
         */
        private String denominationPrice;
        /**
         * 1, 卡余额 卡余额，单位为分
         */
        private String cardBalance;
        /**
         * 领取时间，毫秒级时间戳
         */
        private String receivedDate;
        /**
         * 失效时间，毫秒级时间戳
         */
        private String disabledDate;

        /**
         * 卡状态
         * 1：未激活（未领取）
         * 2：已激活（已领取）
         * 4：冻结中（退卡中/已过期）
         * 6：已失效（已退卡）
         */
        private Integer status;

        private String statusStr;
        /**
         * 净额，以分为单位(购卡实付金额,卡售价)
         */
        private String cardNetBalance;

        /**
         * 1, 字符串，折扣率
         */
        private String discountRate;
    }
}
