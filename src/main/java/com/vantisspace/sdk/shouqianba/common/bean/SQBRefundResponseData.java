package com.vantisspace.sdk.shouqianba.common.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class SQBRefundResponseData implements Serializable {
    /**
     * 品牌编号，系统对接前由"收钱吧"分配并提供，返回调用方传入的值
     * 数字，最大32位
     * String
     * 1
     */
    private String brand_code;
    /**
     * 商户内部使用的门店编号，返回调用方传入的值
     * 字符串，最大36位
     * String
     * 1
     */
    private String store_sn;
    /**
     * 门店收银机编号，返回调用方传入的值
     * 字符串，最大36位
     * String
     * 1
     */
    private String workstation_sn;
    /**
     * 商户订单号，返回调用方传入的值
     * 字符串，最大32位
     * String
     * 1
     */
    private String check_sn;
    /**
     * 本系统为该订单生成的订单序列号
     * 字符串，最大32位
     * String
     * 1
     */
    private String order_sn;
    /**
     * 订单来源：1=商户系统，3=智能终端，4=门店码牌，5=商户后台
     * 数字，1 位
     * String
     * 1
     */
    private String order_source;
    /**
     * 反射参数; 任何开发者希望原样返回的信息，可以用于关联商户ERP系统的订单或记录附加订单内容。可以在订单结果通知中返回
     * String 字符串，
     * 最大64位 反射参数;
     * 任何开发者希望原样返回的信息，可以用于关联商户ERP系统的订单或记录附加订单内容。可以在订单结果通知中返回
     * 0-1
     */
    private String reflect;
}
