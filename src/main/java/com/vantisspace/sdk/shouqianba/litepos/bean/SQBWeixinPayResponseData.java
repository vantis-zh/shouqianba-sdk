package com.vantisspace.sdk.shouqianba.litepos.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class SQBWeixinPayResponseData implements Serializable {
    /**
     * 1 数字，最大32位
     * 品牌编号，返回调用方传入的值
     **/
    private String brand_code;
    /**
     * 1 字符串，最大36位
     * 商户门店编号，返回调用方传入的值
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
     * 本系统为该订单生成的订单序列号
     **/
    private String order_sn;
    /**
     * 1 数字，1位
     * 订单状态 3：支付中，4：支付完成，6：支付失败
     **/
    private String order_status;
    /**
     * 1 字符串
     * 订单状态描述
     **/
    private String order_status_desc;
    /**
     * 0-1 数字
     * 支付方式类型：参考附录二级支付方式
     **/
    private String tender_type;
    /**
     * 0-1 字符串
     * 支付方式描述。
     **/
    private String tender_desc;
    /**
     * 0-1 字符串
     * 支付方式类型：参考附录二级支付方式
     **/
    private String sub_tender_type;
    /**
     * 0-1 字符串
     * 支付方式描述。如：微信支付
     **/
    private String sub_tender_desc;
    /**
     * 1 字符串，最大32位
     * 轻 POS 生成的唯一流水号
     **/
    private String tender_sn;
    /**
     * 0-1 字符串，最大32位
     * 移动支付：收钱吧传入支付宝/微信的 out_trade_no
     **/
    private String internal_transaction_sn;
    /**
     * 0-1 字符串，最大32位
     * 商家实收金额，精确到分
     **/
    private String collected_amount;
    /**
     * 0-1 字符串，最大32位
     * 消费者实付金额，精确到分
     **/
    private String paid_amount;
    /**
     * 0-1 字符串，最大32位
     * 渠道流水号，操作成功时存在。例如微信，支付宝流水号
     **/
    private String channel_sn;
    /**
     * 0-1 字符串
     * 支付通道返回的调用 jsapi 支付需要传递的信息
     **/
    private Map<String, String> pay_request_param;

}
