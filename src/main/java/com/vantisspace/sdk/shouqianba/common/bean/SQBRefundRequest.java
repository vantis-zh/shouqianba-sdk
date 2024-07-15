package com.vantisspace.sdk.shouqianba.common.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SQBRefundRequest implements Serializable {
    /**
     * 请求编号，每次请求必须唯一；表示每一次请求时不同的业务，如果第一次请求业务失败了，再次请求，可以用于区分是哪次请求的业务。
     * 字符串，最大64位
     * String
     * 1
     */
    private String request_id;
    /**
     * 品牌编号，系统对接前由"收钱吧"分配并提供
     * 数字，最大32位
     * String
     * 1
     */
    private String brand_code;
    /**
     * 商户内部使用的门店编号
     * 字符串，最大36位
     * String
     * 1
     */
    private String store_sn;
    /**
     * 商户门店名称
     * 字符串，最大255位
     * String
     * 0-1
     */
    private String store_name;
    /**
     * 门店收银机编号，如果没有请传入"0"
     * 字符串，最大36位
     * String
     * 1
     */
    private String workstation_sn;
    /**
     * 商户订单号
     * 字符串，最大32位
     * String
     * 1
     */
    private String check_sn;
    /**
     * 商户订单创建时间, 格式详见 1.5时间数据元素定义
     * 字符串，20- 25位
     * String
     * 1
     */
    private String sales_time;
    /**
     * 订单总金额，精确到分，金额应为负数。
     * 数字，最大12位
     * String
     * 1
     */
    private String amount;
    /**
     * 币种，ISO numeric currency code 如："156"for CNY
     * 字符串，3位
     * String
     * 1
     */
    private String currency;
    /**
     * 订单简短描述，建议传8个字内
     * 字符串，最大64位
     * String
     * 1
     */
    private String subject;
    /**
     * 订单描述
     * 字符串，最大255位
     * String
     * 0-1
     */
    private String description;
    /**
     * 操作员，可以传入收款的收银员或导购员。例如"张三"
     * 字符串，最大32位
     * String
     * 1
     */
    private String operator;
    /**
     * 可以传入需要备注顾客的信息
     * 字符串，最大32位
     * String
     * 1
     */
    private String customer;
    /**
     * 拓展字段1，可以用于做自定义标识，如座号，房间号；
     * 智能终端手动录单功能需要添加此字段请联系收钱吧技术支持
     * 字符串，最大32位
     * String
     * 0-1
     */
    private String extension_1;
    /**
     * 拓展字段1，可以用于做自定义标识，如座号，房间号；
     * 智能终端手动录单功能需要添加此字段请联系收钱吧技术支持
     * 字符串，最大32位
     * String
     * 0-1
     */
    private String extension_2;
    /**
     * 行业代码, 0=零售1:酒店; 2:餐饮; 3:文娱; 4:教育;
     * 数字，1位
     * String
     * 1
     */
    private String industry_code;
    /**
     * 传入商户系统的产品名称、系统编号等信息，便于帮助商户调查问题
     * 字符串，最大64位
     * String
     * 1
     */
    private String pos_info;
    /**
     * 通知接收地址。总共回调7次，回调时间间隔：4m,10m,10m,1h,2h,6h,15h。
     * 字符创，最大255位
     * String
     * 0-1
     */
    private String notify_url;
    /**
     * 扩展对象，用于传入本接口所定义字段之外的参数，JSON格式。
     * <p>
     * JSON
     * 0-1
     */
    private String extended;
    /**
     * 反射参数; 任何开发者希望原样返回的信息，可以用于关联商户ERP系统的订单或记录附加订单内容。
     * 字符串，最大64位
     * String
     * 0-1
     */
    private String reflect;
    /**
     * 订单货物清单，定义如下表
     * item数组
     * [Item]
     * 0-n
     */
    private List<Item> items;
    /**
     * tender数组 订单指定的各退款方式，定义如下表，
     * [tender]
     * 1-n
     */
    private List<Tender> tenders;

    @Data
    public static class Item implements Serializable {
        /**
         * 商户系统中的商品编号
         * 字符串，最大32位
         * String
         * 1
         */
        private String item_code;
        /**
         * 商品描述信息，例"白色短袖"
         * 字符串，最大64位
         * String
         * 1
         */
        private String item_desc;
        /**
         * 商品所属大类，例"短袖"
         * 字符串，最大32位
         * String
         * 0-1
         */
        private String category;
        /**
         * 商品单位，例"件"
         * 字符串，最大32位
         * String
         * 0-1
         */
        private String unit;
        /**
         * 商品数量，例"2"；当退货时数量为负数，例："-2"
         * 数字，最大8位
         * String
         * 1
         */
        private String item_qty;
        /**
         * 商品单价，精确到分
         * 数字，最大12位
         * String
         * 1
         */
        private String item_price;
        /**
         * 商品成交价格,一般为数量 * 单价，如有折扣再进行扣减，精确到分；当退货时成交价为负数；目前不校验"数量 * 单价"结果是否与此字段值相等
         * 数字，最大12位
         * String
         * 1
         */
        private String sales_price;
        /**
         * 0-销售，1-退货
         * 数字，1位
         * String
         * 1
         */
        private String type;
        /**
         * 原商品销售门店号
         * 字符串，最大36位
         * String
         * 1
         */
        private String return_store_sn;
        /**
         * 原商品销售收银机号
         * 字符串，最大36位
         * String
         * 1
         */
        private String return_workstation_sn;
        /**
         * 1	String	字符串，最大32位	原商品销售订单号
         */
        private String return_check_sn;
    }

    @Data
    public static class Tender implements Serializable {
        /**
         * 商户系统流水号，在商户系统中唯一
         * 字符串，最大32位
         * String
         * 1
         */
        private String transaction_sn;
        /**
         * 退款金额，精确到分，退款为负
         * 数字，最大12位
         * String
         * 1
         */
        private String amount;
        /**
         * 标记该tender是否已经支付完成，0：待操作，1：已完成原tender_type为99-外部时必需为1其他tender_tpye必需为0
         * 数字，1位
         * String
         * 1
         */
        private String pay_status;
        /**
         * tender创建时间，当pay_status为1时必填，格式详见 1.5时间数据元素定义
         * 字符串，最大32位
         * String
         * 0-1
         */
        private String create_time;
        /**
         * 1	String	字符串，最大32位	原购货订单完成后本系统返回的支付流水号
         */
        private String original_tender_sn;
    }
}
