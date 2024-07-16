package com.vantisspace.sdk.shouqianba.pos.bean;

import lombok.Getter;

@Getter
public enum PaymentType {
    HONGBAO_WOSAI("HONGBAO_WOSAI", "喔噻红包"),
    HONGBAO_WOSAI_MCH("HONGBAO_WOSAI_MCH", "喔噻商户红包 免充值"),
    DISCOUNT_WOSAI("DISCOUNT_WOSAI", "喔噻立减"),
    DISCOUNT_WOSAI_MCH("DISCOUNT_WOSAI_MCH", "喔噻商户立减 免充值"),
    DISCOUNT_CHANNEL("DISCOUNT_CHANNEL", "支付通道 折扣(立减优惠)"),
    DISCOUNT_CHANNEL_MCH("DISCOUNT_CHANNEL_MCH", "折扣(立减优惠) 支付通道商户 免充值"),
    DISCOUNT_CHANNEL_MCH_TOP_UP("DISCOUNT_CHANNEL_MCH_TOP_UP", "折扣(立减优惠) 支付通道商户 充值"),
    HONGBAO_CHANNEL("HONGBAO_CHANNEL", "支付通道红包"),
    HONGBAO_CHANNEL_MCH("HONGBAO_CHANNEL_MCH", "支付通道商户红包 免充值"),
    HONGBAO_CHANNEL_MCH_TOP_UP("HONGBAO_CHANNEL_MCH_TOP_UP", "支付通道商户红包 充值"),
    CARD_PRE("CARD_PRE", "支付通道商户预付卡"),
    CARD_BALANCE("CARD_BALANCE", "支付通道商户储值卡"),
    BANKCARD_CREDIT("BANKCARD_CREDIT", "信用卡 银行卡"),
    BANKCARD_DEBIT("BANKCARD_DEBIT", "储蓄卡 银行卡"),
    WALLET_ALIPAY("WALLET_ALIPAY", "余额 支付宝钱包"),
    WALLET_ALIPAY_FINANCE("WALLET_ALIPAY_FINANCE", "余额 余额宝"),
    WALLET_WEIXIN("WALLET_WEIXIN", "余额 微信钱包"),
    ALIPAY_HUABEI("ALIPAY_HUABEI", "支付宝 花呗"),
    ALIPAY_POINT("ALIPAY_POINT", "支付宝 集分宝"),
    ;
    private String value;
    private String comment;

    PaymentType(String value, String comment) {
        this.value = value;
        this.comment = comment;
    }
}
