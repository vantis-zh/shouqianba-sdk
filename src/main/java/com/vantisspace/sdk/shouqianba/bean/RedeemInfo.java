package com.vantisspace.sdk.shouqianba.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class RedeemInfo implements Serializable {
    /**
     * 1, 兑换二维码 兑换二维码;
     */
    private String redeem_qrcode;
    /**
     * 1, 兑换码 兑换码
     */
    private String redeem_no;
    /**
     * 0-1, 兑换口令 兑换口令
     */
    private String redeem_password;
}
