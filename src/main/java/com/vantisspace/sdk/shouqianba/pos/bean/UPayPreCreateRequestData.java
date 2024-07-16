package com.vantisspace.sdk.shouqianba.pos.bean;

import com.vantisspace.sdk.shouqianba.pos.common.bean.SQBPosRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class UPayPreCreateRequestData extends SQBPosRequest<UPayPreCreateResponseData> {
    /**
     * 商户系统订单号
     * Y 必须在商户系统内唯一；且长度不超过32字节
     */
    private String client_sn;
    /**
     * 交易总金额
     * Y 以分为单位,不超过10位纯数字字符串,超过1亿元的收款请使用银行转账
     */
    private String total_amount;
    /**
     * 支付方式
     * Y 内容为数字的字符串
     */
    private String payway;
    /**
     * 二级支付方式
     * N 内容为数字的字符串，如果要使用WAP支付，则必须传 "3"；使用小程序支付，则必须传"4"
     */
    private String sub_payway;
    /**
     * 付款人id
     * N 消费者在支付通道的唯一id，wap支付，小程序支付必传 ，微信WAP支付必须传open_id,支付宝WAP支付必传用户授权的userId
     */
    private String payer_uid;
    /**
     * 交易简介
     * Y 本次交易的概述
     */
    private String subject;
    /**
     * 门店操作员
     * Y 发起本次交易的操作员
     */
    private String operator;
    /**
     * 商品详情	String	N	对商品或本次交易的描述
     */
    private String description;
    /**
     * 经度	String	N	经纬度必须同时出现
     */
    private String longitude;
    /**
     * 纬度	String	N	经纬度必须同时出现
     */
    private String latitude;
    /**
     * 扩展参数集合
     * N 收钱吧与特定第三方单独约定的参数集合,json格式，最多支持24个字段，每个字段key长度不超过64字节，value长度不超过256字节小程序扫码点餐订单必传参数：{"attach":"OrderSource=FoodOrder"}
     */
    private Extend extended;
    /**
     * 商品详情	JSON N	goods_details的值为数组，每一个元素为json，包含五个字段：goods_id商品的编号；goods_name商品名称；quantity商品数量；price商品单价，单位为分；promotion_type优惠类型，0:没有优惠，收钱吧不处理单品信息 1: 支付机构优惠，收钱吧处理单品信息并上送到支付机构	"goods_details": [{"goods_id": "wx001","goods_name": "苹果笔记本电脑","quantity": 1,"price": 2,"promotion_type": 0},{"goods_id":"wx002","goods_name":"tesla","quantity": 1,"price": 2,"promotion_type": 1}]
     */
    private List<Goods> goods_details;
    /**
     * 反射参数
     * N 任何调用者希望原样返回的信息
     */
    private String reflect;
    /**
     * 回调
     * N 支付回调的地址
     */
    private String notify_url;

    @Override
    public String url() {
        return "/upay/v2/precreate";
    }
}
