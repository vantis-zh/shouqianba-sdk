package com.vantisspace.sdk.shouqianba.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class SQBAliPayResponseData implements Serializable {
    /**
     * 1 数字，最大32位
     **/
    private String brand_code;
    /**
     * 1 字符串，最大36位
     **/
    private String store_sn;
    /**
     * 1 字符串，最大36位
     **/
    private String workstation_sn;
    /**
     * 1 字符串，最大32位
     **/
    private String check_sn;
    /**
     * 1 字符串，最大32位
     **/
    private String order_sn;
    /**
     * 1 字符串,最大 64 位
     **/
    private String order_token;
    /**
     * 1 数字，1 位
     **/
    private String order_source;
    /**
     * 0-1 字符串，最大255位
     * APP场景下返回跳转小程序链接
     **/
    private String cashier_url;
    /**
     * 0-1 字符串，最大 255
     **/
    private String order_image_url;
    /**
     * 0-1 位字符串，最大64位
     **/
    private String reflect;
}
