package com.vantisspace.sdk.shouqianba.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class WalletAbsRequest implements Serializable {

    /**
     * 1, wechat; 2,alipay
     */
    private String userChannel = "1";
    /**
     * 用户身份号 比如 unionId
     */
    private String userNo;
    /**
     * 用户id
     */
    private String userId;
}
