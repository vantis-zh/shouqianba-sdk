package com.vantisspace.sdk.shouqianba.bean.callback;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class WalletTopUpCallback extends Callback {
    /**
     * 1, 字符串，最大 20 位, 品牌编号，系统对接前由“收钱吧”提供
     */
    private String brand_code;
    /**
     * 1, 字符串，最大 36 位, 收钱吧侧充值订单号
     */
    private String order_no;
    /**
     * 1, 字符串，最大 36 位, 用户在礼品卡微信小程序内的UnionId，非必填
     */
    private String user_id;
    /**
     * 1, 数组, 充值成功生成的卡的列表
     */
    private List<Card> cards;
    /**
     * 0-1, 字符串，最大 20 位, 充值成功的时间
     */
    private String biz_time;
    /**
     * 1, 字符串，最大 11 位, 充值的总计面额，以分为单位
     */
    private String total_amount;
    /**
     * 1, 字符串，最大 11 位, 充值的总计净额，以分为单位
     */
    private String total_net_amount;
    /**
     * 1, 字符串，最大 11 位, 用户充值付款的总金额，以分为单位
     */
    private String pay_amount;
    /**
     * 1, 字符串，最大 11 位, 用户充值商户的总实收金额，以分为单位
     */
    private String collect_amount;

    @Data
    public static class Card implements Serializable {
        /**
         * 1, 字符串，最大 36 位, 充值卡号
         */
        private String card_number;
        /**
         * 1, 字符串，最大 36 位, 充值卡名
         */
        private String card_name;
        /**
         * 1, 字符串, 充值卡面 id
         */
        private String card_surface_id;
        /**
         * 0-1, 字符串，最大 36 位, 充值卡面名称
         */
        private String card_surface_name;
        /**
         * 0-1, 字符串, 充值卡面图片地址
         */
        private String card_surface_url;
        /**
         * 1, 字符串，最大 20 位, 充值卡后剩余的余额，以分为单位
         */
        private String after_balance;
        /**
         * 1, 字符串，最大 20 位, 充值卡后剩余的净额，以分为单位
         */
        private String after_net_balance;
        /**
         * 1, 字符串，最大 20 位, 充值卡前剩余的余额，以分为单位
         */
        private String before_balance;
        /**
         * 1, 字符串，最大 20 位, 充值卡前剩余的净额，以分为单位
         */
        private String before_net_balance;
    }
}
