package com.vantisspace.sdk.shouqianba.pos.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProviderGoodsDetail implements Serializable {
    /**
     * 商品编码
     * Y 由半角的大小写字母、数字、中划线、下划线中的一种或几种组成
     */
    private String goods_id;
    /**
     * 商品名称
     */
    private String goods_name;
    /**
     * 商品备注
     * N goods_remark为备注字段，按照配置原样返回，字段内容在微信后台配置券时进行设置。
     */
    private String goods_remark;
    /**
     * 商品优惠金额
     * Y 单品的总优惠金额，微信支付 单位为：分; 支付宝支付 单位为 元
     */
    private String discount_amount;
    /**
     * 券ID
     */
    private String voucher_id;
    /**
     * 商品数量
     * Y 用户购买的数量 仅微信支付
     */
    private int quantity;
    /**
     * 商品数量
     * Y 用户购买的数量 仅支付宝支付
     */
    private int goods_num;
    /**
     * 商品价格
     * Y 商品单价，单位为：分。
     */
    private int price;
}
