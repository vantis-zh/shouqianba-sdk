package com.vantisspace.sdk.shouqianba.litepos.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Card implements Serializable {
    /**
     * 1, 卡信息 卡信息
     */
    private CardInfo card_info;
    /**
     * 1, 兑换信息 兑换信息
     */
    private RedeemInfo redeem_info;
}
