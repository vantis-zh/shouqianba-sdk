package com.vantisspace.sdk.shouqianba.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class CardConsumedRecordRequest implements Serializable {
    /**
     * 数字，最大 32 位	品牌编号，系统对接前由“收钱吧”提供
     */
    private String brandCode;
    /**
     * String	字符串，最大 36 位	需要查询的卡的卡号
     */
    private String cardNumber;
    /**
     * String	字符串，最大 255 位	微信用户为 UnionID，支付宝为用户 ID
     */
    private String userId;

    private String userChannel;

    /**
     * String	字符串，最大 36 位	商户端的用户 id
     */
    private String clientMemberId;
}
