package com.vantisspace.sdk.shouqianba.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CardRedeem implements Serializable {
    /**
     * 1, 32 -
     */
    private String card_number;
    /**
     * 选填, 10 订单价格，精确到分
     */
    private BigDecimal total_amount;
}
