package com.vantisspace.sdk.shouqianba.pos.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UPayResponseData implements Serializable {
    /**
     * 结果码
     * Y 结果码表示接口调用的业务逻辑是否成功
     */
    private String result_code;
    /**
     * 错误码
     * N 参考附录：业务执行错误码列表
     */
    private String error_code;
    /**
     * 错误消息
     * N 参考附录：业务执行错误码列表
     */
    private String error_message;

    /**
     * 终端号
     * Y 收钱吧终端ID
     */
    private String terminal_sn;

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
     * N 支付通道交易凭证号，只有支付成功时才有值返回
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
     * 支付方式名称
     * Y
     */
    private String payway_name;

    /**
     * 二级支付方式
     * Y 二级支付方式，取值见附录《二级支付方式列表》
     */
    private String sub_payway;

    /**
     * 付款人ID
     * N 支付平台（微信，支付宝）上的付款人ID
     */
    private String payer_uid;

    /**
     * 付款人账号
     * N 支付平台上的付款人账号
     */
    private String payer_login;

    /**
     * 交易总额
     * Y 本次交易总金额
     */
    private String total_amount;

    /**
     * 实收金额
     * Y 如果没有退款，这个字段等于total_amount。否则等于 total_amount减去退款金额
     */
    private String net_amount;

    /**
     * 本次操作金额
     * Y 本次支付金额
     */
    private String settlement_amount;

    /**
     * 交易概述
     * Y 本次交易概述
     */
    private String subject;

    /**
     * 付款动作在收钱吧的完成时间
     * N 时间戳，只有order_status为最终状态时才会返回
     */
    private String finish_time;

    /**
     * 付款动作在支付服务商的完成时间
     * N 时间戳，只有支付成功时才有值返回
     */
    private String channel_finish_time;

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
     * 优惠详情
     * N 格式为json，内容有两部分 goods_details为数组，内容为核销单品信息，voucher_details为数组，内容为核销券信息。
     */
    private ProviderResponse provider_response;
    /**
     * 活动优惠
     * N 订单内活动优惠信息概览格式为数组，元素为json对象。
     */
    private List<Payment> payment_list;
}
