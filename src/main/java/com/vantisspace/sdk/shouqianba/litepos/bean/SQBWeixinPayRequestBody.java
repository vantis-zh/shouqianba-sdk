package com.vantisspace.sdk.shouqianba.litepos.bean;

import com.vantisspace.sdk.shouqianba.litepos.common.bean.Item;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SQBWeixinPayRequestBody implements Serializable {
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
     * 1 字符串，最大32位
     * 本系统为该订单生成的订单序列号，成功请求立即付接口后，接口同步返回；同一笔订单重新支付时传入该字段唤起支付
     **/
    private String order_sn;
    /**
     * 1 字符串，最大32位
     * 本系统为该订单生成的订单序列号，成功请求立即付接口后，接口同步返回；同一笔订单重新支付时传入该字段唤起支付
     **/

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
     * 1 字符串，最大 64位
     * 订单简短描述，建议传8个字内，手机账单支付凭证页“商品说明
     **/
    private String subject;
    /**
     * 0-1 字符串，最大255位
     * 订单描述
     **/
    private String description;
    /**
     * 1 字符串，最大32位
     * 操作员，例如"张三"
     **/
    private String operator;
    /**
     * 1 字符串，最大32位
     * 可以传入需要备注顾客的信息
     **/
    private String customer;
    /**
     * 0-1 字符串，最大255位
     * 通知接收地址
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
     * 0-n item数组
     * 订单货物清单，定义如下表
     **/
    private List<Item> items;
    /**
     * 1 字符串
     * 支付方式类型： 参考附录支付方式
     **/
    private String tender_type;
    /**
     * 0-1 字符串
     * 参考附录，支付方式 scene_type=1 时可不填，其它情况必填
     **/
    private String sub_tender_type;
    /**
     * 1 字符串
     * 1-付款码支付、协议支付
     * 2–wap 支付
     * 3-小程序支付
     * 5-APP支付
     * 6-H5支付
     * 不同 scene_type 决定了调起支付的方式
     **/
    private String scene_type;
    /**
     * 0-1 字符串
     * 小程序支付时必传，小程序appid
     **/
    private String appid;
    /**
     * 0-1 字符串
     * 小程序支付时必传，小程序appid
     **/
    private String dynamic_id;
    /**
     * 0-1 字符串
     * 消费者在支付通道的唯一 id，小程序支付必传，微信小程序支付必须传 open_id，支付宝小程序支付必传用户授权的 userId
     **/
    private String payer_uid;
    /**
     * 0-1 数字
     * 分期相关。指定分期数，分期支付时必填
     * 6-分6期
     * 12-分12期
     **/
    private String installment_number;
    /**
     * 0-1 数字
     * 分期相关。商家贴息比例0~100的整数。跟期数同时出现，指定期数时必传。
     * 花呗分期只能传0或者100。商家承担手续费传入100；用户承担手续费传入0。
     **/
    private String installment_fee_merchant_percent;
    /**
     * 0-1 字符串
     * 礼品卡最大折扣率，0～1之间，两位小数。
     * 高于最大折扣率的卡则不能使用。比如0.88，则购卡折扣率小于0.88的卡不能使用，礼品卡支付时该字段有效。
     **/
    private String card_discount_threshold;


}
