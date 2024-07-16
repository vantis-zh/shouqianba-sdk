package com.vantisspace.sdk.shouqianba.pos.bean;

import com.vantisspace.sdk.shouqianba.pos.common.bean.SQBPosRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class UPayRequestData extends SQBPosRequest<UPayResponseData> {
    /**
     * 商户系统订单号
     * Y 必须在商户系统内唯一；且长度不超过32字节
     */
    private String client_sn;
    /**
     * 交易总金额
     * Y 以分为单位,不超过10位纯数字字符串,超过1亿元的收款请使用银行转账
     */
    private BigDecimal total_amount;
    /**
     * 支付方式
     * N 非必传。内容为数字的字符串。一旦设置，则根据支付码判断支付通道的逻辑失效
     */
    private String payway;
    /**
     * 条码内容
     * Y 不超过32字节
     */
    private String dynamic_id;
    /**
     * 交易简介
     * Y 本次交易的简要介绍
     */
    private String subject;
    /**
     * 门店操作员
     * Y 发起本次交易的操作员
     */
    private String operator;
    /**
     * 商品详情	String(255)	N	对商品或本次交易的描述
     */
    private String description;
    /**
     * 经度
     * N 经纬度必须同时出现
     */
    private String longitude;
    /**
     * 维度
     * N 经纬度必须同时出现
     */
    private String latitude;
    /**
     * N 设备指纹
     */
    private String device_id;
    /**
     * 扩展参数集合
     * N 收钱吧与特定第三方单独约定的参数集合,json格式，最多支持24个字段，每个字段key长度不超过64字节，value长度不超过256字节
     */
    private Extend extended;
    /**
     * 商品详情
     * N goods_details的值为数组，每一个元素为json，包含五个字段：goods_id商品的编号；goods_name商品名称；quantity商品数量；price商品单价，单位为分；promotion_type优惠类型，0:没有优惠，收钱吧不处理单品信息 1: 支付机构优惠，收钱吧处理单品信息并上送到支付机构
     */
    private List<Goods> goods_details;

    /**
     * 反射参数
     * N 任何调用者希望原样返回的信息，可以用于关联商户ERP系统的订单或记录附加订单内容
     */
    private String reflect;

    /**
     * 回调
     * N 支付回调的地址
     */
    private String notify_url;

    @Override
    public String url() {
        return "/upay/v2/pay";
    }
}
