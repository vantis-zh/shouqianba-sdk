package com.vantisspace.sdk.shouqianba.pos.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ProviderVoucherDetail implements Serializable {
    /**
     * 券ID
     * Y 券或者立减优惠id
     */
    private String promotion_id;
    private String id;
    /**
     * 券模板id
     */
    private String template_id;
    /**
     * 优惠名称
     * N 优惠名称
     */
    private String name;
    /**
     * 优惠券备注信息
     */
    private String memo;
    /**
     * 优惠范围
     * N GLOBAL- 全场代金券SINGLE- 单品优惠
     */
    private String scope;
    /**
     * 优惠类型
     * N COUPON- 代金券，需要走结算资金的充值型代金券,（境外商户券币种与支付币种一致）DISCOUNT- 优惠券，不走结算资金的免充值型优惠券，（境外商户券币种与标价币种一致)
     * ALIPAY_FIX_VOUCHER - 全场代金券
     * ALIPAY_DISCOUNT_VOUCHER - 折扣券
     * ALIPAY_ITEM_VOUCHER - 单品优惠券
     * ALIPAY_CASH_VOUCHER - 现金抵价券
     * ALIPAY_BIZ_VOUCHER - 商家全场券
     * 注：不排除将来新增其他类型的可能，商家接入时注意兼容性避免硬编码
     */
    private String type;
    /**
     * 优惠券面额
     * Y 用户享受优惠的金额
     */
    private String amount;
    /**
     * 活动ID
     * Y 在微信商户后台配置的批次ID
     */
    private String activity_id;
    /**
     * 微信出资
     * N 特指由微信支付商户平台创建的优惠，出资金额等于本项优惠总金额
     */
    private BigDecimal wxpay_contribute;
    /**
     * 商户出资
     * N 特指商户自己创建的优惠，出资金额等于本项优惠总金额
     */
    private BigDecimal merchant_contribute;
    /**
     * 其他出资
     * N 其他出资方出资金额
     */
    private BigDecimal other_contribute;
    /**
     * 如果使用的这张券是用户购买的，则该字段代表用户在购买这张券时用户实际付款的金额
     */
    private BigDecimal purchase_buyer_contribute;
    /**
     * 如果使用的这张券是用户购买的，则该字段代表用户在购买这张券时商户优惠的金额
     */
    private BigDecimal purchase_merchant_contribute;
    /**
     * 如果使用的这张券是用户购买的，则该字段代表用户在购买这张券时平台优惠的金额
     */
    private BigDecimal purchase_ant_contribute;
    /**
     * 单品列表
     * 否 单品信息，使用Json格式
     */
    private List<ProviderVoucherGoodsDetail> goods_detail;
}
