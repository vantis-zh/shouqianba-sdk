package com.vantisspace.sdk.shouqianba.pos.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Goods implements Serializable {
    private String goods_id;
    private String goods_name;
    private BigDecimal quantity;
    private BigDecimal price;
    private Integer promotion_type;
}
