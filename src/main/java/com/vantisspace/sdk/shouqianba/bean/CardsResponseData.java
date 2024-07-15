package com.vantisspace.sdk.shouqianba.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CardsResponseData implements Serializable {
    /**
     * 1, 数字，最大 32 位 品牌编号，返回调用方传入的值
     */
    private String brand_code;
    /**
     * 1, 字符串，最大 36 位 微信用户为 UnionID，支付宝为用户 ID
     */
    private String user_id;
    /**
     * 1, 字符串，最大 36 位 1, wechat; 2,alipay
     */
    private String user_channel;
    /**
     * 0-1, 字符串，最大 36 位 商户端的用户 id
     */
    private String client_member_id;
    /**
     * 0-1, 字符串，最大 36 位 发卡商户编号
     */
    private String merchant_sn;
    /**
     * 0-1, 字符串，最大 80 位 发卡商户名称
     */
    private String merchant_name;
    /**
     * 1, 字符串，最大 11 位 账户总可用余额，以分为单位
     */
    private String account_balance;
    /**
     * 账户总可用余额，以分为单位
     */
    private String account_available_balance;
    /**
     * 1, - 用户持有的会员卡的集合
     */
    private List<Card> cards;


    @Data
    public static class Card implements Serializable {
        /**
         * 1, 字符串，最大 36 位 卡号
         */
        private String card_number;
        /**
         * 1, 字符串，最大 36 位 卡名
         */
        private String card_name;
        /**
         * 1, 字符串，最大 4 位 标志卡的类型 1:礼品卡,2:单品卡
         */
        private String card_type;
        /**
         * 1, 字符串 卡规则 id
         */
        private String card_spec_id;
        /**
         * 1, 字符串 卡面 id
         */
        private String card_surface_id;
        /**
         * 0-1, 字符串，最大 36 位 卡面名称
         */
        private String card_surface_name;
        /**
         * 0-1, 字符串 卡面图片地址
         */
        private String card_surface_url;
        /**
         * 1, 字符串，最大 20 位 卡的面额，以分为单位
         */
        private String card_denomination;

        /**
         * 1, 字符串，最大 20 位 卡当前剩余的余额，以分为单位
         */
        private String card_balance;
        /**
         * 1, 字符串，最大 20 位 卡当前剩余的净额，以分为单位
         */
        private String card_net_balance;
        /**
         * 1, 字符串，折扣率
         */
        private String discount_rate;
        /**
         * 1：未激活（未领取）
         * 2：已激活（已领取）
         * 4：冻结中（退卡中/已过期）
         * 6：已失效（已退卡）
         */
        private Integer status;
        /**
         * 领取时间
         */
        private String received_at;
        /**
         * 失效时间
         */
        private String disabled_at;
        /**
         * 发行门店 id
         */
        private String issue_store_id;
        /**
         * 发行门店名
         */
        private String issue_store_name;
        /**
         * 券兑换码
         */
        private String exchange_no;
    }
}
