package com.vantisspace.sdk.shouqianba.litepos.bean.callback;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class CardIssueCallback extends Callback {
    /**
     * 1, 字符串，最大 20 位 品牌编号，系统对接前由“收钱吧”提供
     */
    private String brand_code;
    /**
     * 1, 字符串，最大 36 位 收钱吧侧购卡订单号，此订单号也会出现在用户"我的订单"列表内
     */
    private String order_no;
    /**
     * 1, 字符串，最大 64 位 用户在礼品卡微信小程序内的UnionId
     */
    private String user_id;
    /**
     * 0-1, 数组 购买成功生成的卡的列表，仅购卡时出现
     */
    private List<Card> cards;
    /**
     * 0-1, 数组 购买成功生成的券的列表，仅购券时出现
     */
//    private List<Coupon> coupons;
    /**
     * 1, 字符串，最大 20 位 购买成功的时间
     */
    private String biz_time;
    /**
     * 1, 字符串，最大 11 位 购买的卡的总计面额，以分为单位
     */
    private String total_amount;
    /**
     * 1, 字符串，最大 11 位 购买的卡的总计净额，以分为单位
     */
    private String total_net_amount;
    /**
     * 1, 字符串，最大 11 位 用户购买的卡付款的总金额，以分为单位
     */
    private String pay_amount;
    /**
     * 1, 字符串，最大 11 位 用户购买的卡商户的总实收金额，以分为单位
     */
    private String collect_amount;

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
        private Integer card_type;
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
         * 1, 字符串，最大 20 位 卡的净额，以分为单位
         */
        private String card_net_amount;
        /**
         * 1, 字符串，最大 20 位 卡当前剩余的余额，以分为单位
         */
        private String card_balance;
        /**
         * 1, 字符串，最大 20 位 卡当前剩余的净额，以分为单位
         */
        private String card_net_balance;
    }

//    @Data
//    public static class Coupon implements Serializable{
//        /**
//         * 1, 字符串，最大 36 位 券号
//         */
//        private String coupon_number;
//        /**
//         * 1, 字符串，最大 36 位 券名
//         */
//        private String coupon_name;
//        /**
//         * 1, 字符串，最大 4 位 1：单品券
//         */
//        private String coupon_type;
//        /**
//         * 1, 字符串 券面 id
//         */
//        private String coupon_surface_id;
//        /**
//         * 0-1, 字符串，最大 36 位 券面名称
//         */
//        private String coupon_surface_name;
//        /**
//         * 0-1, 字符串 券面图片地址
//         */
//        private String coupon_surface_url;
//        /**
//         * 1, 字符串，最大 20 位 面额，以分为单位
//         */
//        private String coupon_denomination;
//        /**
//         * 1, 字符串，最大 20 位 余额，以分为单位
//         */
//        private String coupon_value;
//        /**
//         * 1, 字符串，最大 20 位 净额，以分为单位
//         */
//        private String coupon_net_value;
//        /**
//         * 0-1, 字符串，最大128 位 券兑换码
//         */
//        private String coupon_sku_spec_id;
//        /**
//         * 0-1, 字符串，最大128 位 券兑换说明
//         */
//        private String coupon_sku_spec_names;
//    }
}
