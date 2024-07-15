package com.vantisspace.sdk.shouqianba.bean;

import com.vantisspace.sdk.shouqianba.common.bean.Item;
import com.vantisspace.sdk.shouqianba.common.bean.RequestTender;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SQBAliPayRequestBody implements Serializable {
    /**
     * 1 字符串，最大64位
     * 请求编号，每次请求必须唯一；表示每一次请求时不同的业务，如果第一次请求业务失败了，再次请求，可以用于区分是哪次请求的业务。
     **/
    private String request_id;
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
     * 0-1 字符串，最大255位
     * 商户门店名称
     **/
    private String store_name;
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
     * 1 数字，1位
     * 场景值：1-智能终端，2-H5，4-PC，5-微信小程序/插件，7-刷脸终端，10-APP支付
     **/
    private String scene;
    /**
     * 1 字符串，20- 25位
     * 商户订单创建时间, 格式详见 1.5时间数据元素定义
     **/
    private String sales_time;
    /**
     * 0-1 数字，最大12位
     * 订单有效时间，传整数，单位为分钟，最小值为1，默认24小时
     **/
    private String expire_time;
    /**
     * 1 数字，最大12位
     * 订单总金额，精确到分。如果同时传入【订单总金额】，【商品总金额】，【运费】，必须满足【订单总金额】=【商品总金额】+【运费】）
     **/
    private String amount;
    /**
     * 0-1 数字，最大 12 位
     * 商品总金额，精确到分
     **/
    private String item_amount;
    /**
     * 0-1 数字，最大 12 位
     * 运费，精确到分
     **/
    private String freight;
    /**
     * 1 字符串，3位
     * 币种，ISO numeric currency code 如："156"for CNY
     **/
    private String currency;
    /**
     * 1 字符串，最大64位
     * 订单简短描述，建议传8个字内，手机账单支付凭证页“商品说明”会展示
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
     * 拓展字段1，可以用于做自定义标识，如座号，房间号；
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
     * 0-1 字符串，最大255位
     * 通知接收地址。总共回调7次，回调时间间隔：4m,10m,10m,1h,2h,6h,15h
     **/
    private String notify_url;
    /**
     * 0-1 字符串，最大支持255位
     * 支付结果页，H5场景支付结果页
     **/
    private String return_url;
    /**
     * 0-1
     * 扩展对象，用于传入本接口所定义字段之外的参数，JSON格式。
     **/
    private String extended;
    /**
     * 0-1 字符串，最大64位
     * 反射参数; 任何开发者希望原样返回的信息，可以用于关联商户ERP系统的订单或记录附加订单内容。
     **/
    private String reflect;
    /**
     * 0-1 字符串，最大64位
     * 可用的二级支付方式sub_tender_type，
     * 多个sub_tender_type用“｜”符号隔开。
     * 与disable_sub_tender_types互斥
     **/
    private String enable_sub_tender_types;
    /**
     * 0-1 字符串，最大64位
     * 不可用的二级支付方式sub_tender_type，
     * 多个sub_tender_type用“｜”符号隔开。
     * 与enable_sub_tender_types互斥
     **/
    private String disable_sub_tender_types;
    /**
     * 0-n item数组
     * 订单货物清单，定义如下表
     **/
    private List<Item> items;
    /**
     * 0-n tender数组
     * 指定订单的各支付方式，定义如下表，不指定支付方式时该数组为空由操作员在POS上选择支付方式，指定支付方式时下发各支付方式设置，预授权完成必须下发该项目并指定授权时的流水号
     **/
    private List<RequestTender> tenders;
}
