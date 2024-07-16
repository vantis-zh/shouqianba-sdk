package com.vantisspace.sdk.shouqianba.litepos.common.bean;


import lombok.Data;

import java.io.Serializable;

@Data
public class Item implements Serializable {
    /**
     * 1 字符串，最大32位
     * 商户系统中的商品编号
     **/
    private String item_code;
    /**
     * 1 字符串，最大64位
     * 商品描述信息，例"白色短袖"
     **/
    private String item_desc;
    /**
     * 0-1 字符串，最大32位
     * 商品所属大类，例"短袖"
     **/
    private String category;
    /**
     * 0-1 字符串，最大32位
     * 商品单位，例"件"
     **/
    private String unit;
    /**
     * 1 数字，最大8位
     * 商品数量，例"2"；当退货时数量为负数，例："-2"
     **/
    private String item_qty;
    /**
     * 1 数字，最大12位
     * 商品单价，精确到分
     **/
    private String item_price;
    /**
     * 1 数字，最大12位
     * 商品成交价格,一般为数量*单价，如有折扣再进行扣减，精确到分；当退货时成交价为负数；目前不校验"数量*单价"结果是否与此字段值相等
     **/
    private String sales_price;
    /**
     * 1 数字，1位
     * 0-销售，1-退货
     **/
    private String type;
    /**
     * 0-1 字符串，最大36位
     * 原商品销售门店号，退货时必填
     **/
    private String return_store_sn;
    /**
     * 0-1 字符串，最大36位
     * 原商品销售收音机号，退货时必填
     **/
    private String return_workstation_sn;
    /**
     * 0-1 字符串，最大32位
     * 原商品销售订单号，退货时必填
     **/
    private String return_check_sn;

    /**
     * 0-1 字符串，最大32位
     * 规格
     **/
    private String spec;
    /**
     * 0-1 字符串，最大32位
     * 备注
     **/
    private String remark;
    /**
     * 0-1 字符串，最大32位
     * 备用
     **/
    private String extra;


}
