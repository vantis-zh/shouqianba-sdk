package com.vantisspace.sdk.shouqianba.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class WalletActivateResponseData implements Serializable {
    /**
     * 需要充值对应账户的编号
     */
    private String card_number;
    /**
     * 储值账户状态
     * 1：未激活（未领取）
     * 2：已激活（已领取）
     * 4：冻结中（退卡中/已过期）
     * 6：已失效（已退卡）
     */
    private Integer status;
    /**
     * 充值之后当前的余额，精确到分
     */
    private String balance;
    /**
     * 充值之后当前的净额，精确到分
     */
    private String net_balance;
}
