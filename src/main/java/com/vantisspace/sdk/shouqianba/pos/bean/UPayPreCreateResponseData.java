package com.vantisspace.sdk.shouqianba.pos.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class UPayPreCreateResponseData implements Serializable {
    /**
     * 收钱吧唯一订单号
     * Y 收钱吧系统内部唯一订单号
     */
    private String sn;
    /**
     * 商户订单号
     * Y 商户系统订单号
     */
    private String client_sn;
    /**
     * 支付服务商订单号
     * N 支付通道交易凭证号
     */
    private String trade_no;
    /**
     * 流水状态
     * Y 本次操作产生的流水的状态
     */
    private String status;
    /**
     * 订单状态
     * Y 当前订单状态
     */
    private String order_status;
    /**
     * 支付方式
     * Y 一级支付方式，取值见附录《支付方式列表》
     */
    private String payway;
    /**
     * 二级支付方式
     * Y 二级支付方式，取值见附录《二级支付方式列表》
     */
    private String sub_payway;
    /**
     * 二维码内容
     * N 预下单成功后生成的二维码
     */
    private String qr_code;
    /**
     * 交易总额
     * Y 本次交易总金额
     */
    private String total_amount;
    /**
     * 实收金额
     * Y 如果没有退款，这个字段等于total_amount。否则等于total_amount减去退款金额
     */
    private String net_amount;
    /**
     * 交易概述
     * Y 本次交易概述
     */
    private String subject;
    /**
     * 操作员
     * Y 门店操作员
     */
    private String operator;
    /**
     * 反射参数
     * N 透传参数
     */
    private String reflect;
    /**
     * 支付通道返回的调用WAP支付需要传递的信息
     * N WAP支付、小程序支付一定会返回；
     */
    private String wap_pay_request;
}
