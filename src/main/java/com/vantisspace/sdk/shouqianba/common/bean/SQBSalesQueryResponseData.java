package com.vantisspace.sdk.shouqianba.common.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SQBSalesQueryResponseData implements Serializable {
    /**
     * 1 数字，最大32位
     * 品牌编号，系统对接前由"收钱吧"分配并提供，返回调用方传入的值
     **/
    private String brand_code;
    /**
     * 1 字符串，最大36位
     * 商户内部使用的门店编号，返回调用方传入的值
     **/
    private String store_sn;
    /**
     * 1 字符串，最大36位
     * 门店收银机编号，返回调用方传入的值
     **/
    private String workstation_sn;
    /**
     * 1 字符串，最大32位
     * 商户订单号，返回调用方传入的值
     **/
    private String check_sn;
    /**
     * 1 字符串，最大32位
     * 订单序列号
     **/
    private String order_sn;
    /**
     * 1 数字，1 位
     * 订单来源：1=商户系统，3=智能终端，4=门店码牌，5=商户后台
     **/
    private String order_source;
    /**
     * 1 数字，1位
     * 场景值：1-智能终端，2-H5，4-PC，5-微信小程序/插件，7-刷脸终端，10-APP支付
     **/
    private String scene;
    /**
     * 1 数字，1位
     * 订单状态0：已取消，1：待操作，2：操作中，3：等待结果中，4：操作完成，5：部分完成，6：操作失败，7：已终止
     **/
    private String order_status;
    /**
     * 1 字符串，20- 25位
     * 订单创建时间, 格式详见 1.5时间数据元素定义
     **/
    private String sales_time;
    /**
     * 1 数字，最大12位
     * 订单总金额，精确到分。如果同时传入【订单总金额】，【商品总金额】，【运费】，必须满足【订单总金额】=【商品总金额】+【运费】）
     **/
    private String amount;
    /**
     * 1 字符串，3位
     * 币种，ISO numeric currency code 如："156"for CNY
     **/
    private String currency;
    /**
     * 1 字符串，最大64位
     * 订单简短描述
     **/
    private String subject;
    /**
     * 0-1 字符串，最大255位
     * 订单描述
     **/
    private String description;
    /**
     * 1 字符串，最大32位
     * 操作员，可以传入收款的收银员或导购员。例如"张三"
     **/
    private String operator;
    /**
     * 1 字符串，最大32位
     * 可以传入需要备注顾客的信息
     **/
    private String customer;
    /**
     * 0-1 字符串，最大32位
     * 拓展字段1，可以用于做自定义标识，如座号，房间号；
     * 智能终端手动录单功能需要添加此字段请联系收钱吧技术支持
     **/
    private String extension_1;
    /**
     * 0-1 字符串，最大32位
     * 拓展字段2，可以用于做自定义标识，如座号，房间号；
     * 智能终端手动录单功能需要添加此字段请联系收钱吧技术支持
     **/
    private String extension_2;
    /**
     * 1 数字，1位
     * 行业代码, 0=零售;1:酒店; 2:餐饮; 3:文娱; 4:教育;
     **/
    private String industry_code;
    /**
     * 1 字符串，最大64位
     * 传入商户系统的产品名称、系统编号等信息，便于帮助商户调查问题
     **/
    private String pos_info;
    /**
     * 0-1 字符创，最大255位
     * 通知接收地址。总共回调7次，回调时间间隔：4m,10m,10m,1h,2h,6h,15h
     **/
    private String notify_url;
    /**
     * 0-1
     * 扩展对象，用于传入本接口所定义字段之外的参数，JSON格式
     **/
    private String extended;
    /**
     * 0-n item数组
     * 订单货物清单，定义如下表
     **/
    private List<Item> items;
    /**
     * 0-n tender数组
     * 指定订单的各退款方式，定义如下表
     **/
    private List<ResponseTender> tenders;
}
