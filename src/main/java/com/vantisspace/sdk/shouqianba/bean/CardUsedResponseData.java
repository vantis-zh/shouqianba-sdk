package com.vantisspace.sdk.shouqianba.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CardUsedResponseData implements Serializable {
    /**
     * 数字，最大 32 位	品牌编号，系统对接前由“收钱吧”提供
     */
    private String brand_code;
    /**
     * String	字符串，最大 36 位	需要查询的卡的卡号
     */
    private String card_number;
    /**
     * String	字符串，最大 255 位	微信用户为 UnionID，支付宝为用户 ID
     */
    private String user_id;
    /**
     * String	字符串，最大 36 位	商户端的用户 id
     */
    private String client_member_id;

    private List<Record> records;


    @Data
    public static class Record implements Serializable {
        private String date; //订单日期
        private String time; //订单时间
        private String merchant_name;//商户名称
        private String merchant_sn; //商户编号
        private String store_name; //门店名称
        private String store_sn; //门店编号
        private String card_number; //消费卡号
        private String card_name; //消费的卡的卡名称
        private String card_surface_name; //卡名名称
        private String card_surface_url; //url
        private String client_sn; //商户订单号
        private String trade_no; //交易流水号
        private Integer order_status; //订单状态 1：核销成功 2：退款成功 3：核销失败 4：退款失败 5：订单状态未知
        private Integer order_type; //订单类型 1：收款 2：退款
        private String order_amount; //订单金额，以分为单位
        private String redeem_amount; //核销金额，以分为单位
        private String redeem_net_amount; //核销净额，以分为单位
        private String discount_rate; //折扣率
        private String card_before_amount; //核销之前卡的余额，以分为单位
        private String card_after_amount; //核销之后卡的余额，以分为单位
        private String card_before_net_amount; //核销之前卡的净额，以分为单位
        private String card_after_net_amount; //核销之后卡的净额，以分为单位
    }
}
