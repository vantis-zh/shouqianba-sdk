package com.vantisspace.sdk.shouqianba.litepos.common.bean;


import lombok.Data;

import java.io.Serializable;

@Data
public class RequestTender implements Serializable {
    /**
     * 1 数字，1位
     * 支付方式类型：0-其他，1-预授权完成，2-银行卡，3-QRCode，4-分期，99-外部
     **/
    private String tender_type;
    /**
     * 0-1 数字
     * 二级支付方式类型（开发者不需要传入具体值）：
     * <p>
     * 001-现金，如需在轻POS录入其他支付方式，在对接时与收钱吧沟通配置；
     * 101-银行卡预授权完成，
     * 102-微信预授权完成，103-支付宝预授权完成；
     * 201-银行卡；
     * 301-微信，302-支付宝；
     * 401-银行卡分期；402-花呗分期
     **/
    private String sub_tender_type;
    /**
     * 0-1 字符串
     * 当tender_type为99时，必填，且传入参数值为收银系统自定义的支付方式
     **/
    private String sub_tender_desc;
    /**
     * 0-1 字符串
     * 付款码内容
     **/
    private String dynamic_id;
    /**
     * 1 数字，最大12位
     * 支付金额，精确到分；
     **/
    private String amount;
    /**
     * 1 字符串，最大32位
     * 商户系统流水号，在商户系统中唯一
     **/
    private String transaction_sn;
    /**
     * 0-1 数字
     * 指定分期数，分期支付时必填
     * 6-分6期
     * 12-分12期
     **/
    private String installment_number;
    /**
     * 0-1 数字
     * 商家贴息比例0~100的整数，跟期数同时出现，指定期数时必传。花呗分期只能传0或者100，商家承担手续费传入100，用户承担手续费传入0。
     **/
    private String installment_fee_merchant_percent;
    /**
     * 0-1 字符串，最大32位
     * tender_type 为1时必填，内容为预授权订单操作成功后，轻POS返回给商户的预授权流水号
     **/
    private String original_tender_sn;
    /**
     * 0-1 数字，最大12位
     * 标记该tender是否已经支付完成，
     * 0：待操作，
     * 1：已完成tender_type为99时，为1：已完成，其他的tender_tpye必须为0：待操作
     **/
    private String pay_status;
    /**
     * 0-1 字符串，最大32位
     * tender创建时间，当pay_status为1时必填, 格式详见 1.5时间数据元素定义
     **/
    private String create_time;
}
