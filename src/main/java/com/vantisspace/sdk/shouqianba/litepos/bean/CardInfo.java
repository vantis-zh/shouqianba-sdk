package com.vantisspace.sdk.shouqianba.litepos.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CardInfo implements Serializable {
    /**
     * 1, 卡类 id 卡规则 id，规则配置在礼品卡后台
     */
    private String card_spec_id;
    /**
     * 1, 卡面 id 卡面 id，卡面在礼品卡后台管理
     */
    private String card_surface_id;
    /**
     * 1, 面额 面额，单位为分
     */
    private BigDecimal denomination_price;
    /**
     * 1, 售价 售价，单位为分
     */
    private BigDecimal sale_price;
    /**
     * 1, 卡号 卡号
     */
    private String card_number;
    /**
     * 0-1, 失效时间 没有则代表永久有效
     */
    private String disabled_date;
    /**
     * 1, 卡余额 卡余额，单位为分
     */
    private String card_balance;
    /**
     * 1, 卡净余额 卡净余额，单位为分
     */
    private String card_net_balance;
    /**
     * 0-1, 发行门店 发行门店 id
     */
    private String issue_store_id;
    /**
     * 0-1, 发行门店名 发行门店名
     */
    private String issue_store_name;
}
