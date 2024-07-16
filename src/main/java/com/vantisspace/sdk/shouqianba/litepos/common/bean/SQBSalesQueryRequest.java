package com.vantisspace.sdk.shouqianba.litepos.common.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class SQBSalesQueryRequest implements Serializable {
    /**
     * 1 数字，最大32位
     * 品牌编号，系统对接前由"收钱吧"分配并提供
     **/
    private String brand_code;
    /**
     * 1 字符串，最大36位
     * 商户内部使用的门店编号
     **/
    private String store_sn;
    /**
     * 1 字符串，最大36位
     * 门店收银机编号，如果没有请传入"0"
     **/
    private String workstation_sn;
    /**
     * 1 字符串，最大32位
     * 商户订单号，在商户系统中唯一
     **/
    private String check_sn;
    /**
     * 0-1 字符串，最大32位
     * 销售类订单下发时收钱吧返回的订单号（可选，优先使用order_sn作查询）
     **/
    private String order_sn;
}
