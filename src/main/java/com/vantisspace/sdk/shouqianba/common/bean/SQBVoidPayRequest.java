package com.vantisspace.sdk.shouqianba.common.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class SQBVoidPayRequest implements Serializable {
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
     * 0-1
     */
    private String original_store_sn;
    /**
     * 原始门店收银机编号，如果没有请传入"0"
     * 字符串，最大36位
     * String
     * 0-1
     */
    private String original_workstation_sn;
    /**
     * 原始商户订单号
     * 字符串，最大32位
     * String
     * 0-1
     */
    private String original_check_sn;
    /**
     * 本系统为该订单生成的订单序列号
     * 字符串，最大32位
     * String
     * 0-1
     */
    private String original_order_sn;
    /**
     * 反射参数; 任何开发者希望原样返回的信息，可以用于关联商户ERP系统的订单或记录附加订单内容。
     * 字符串，最大64位
     * String
     * 0-1
     */
    private String reflect;
}
