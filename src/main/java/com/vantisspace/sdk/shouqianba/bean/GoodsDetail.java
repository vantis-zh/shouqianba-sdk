package com.vantisspace.sdk.shouqianba.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class GoodsDetail implements Serializable {
    /**
     * 1, 32 商品的编号
     */
    private String goods_id;
    /**
     * 1, 256 商品名称
     */
    private String goods_name;
    /**
     * 1, 10 商品数量
     */
    private Number quantity;
    /**
     * 1, 9 商品单价，单位为元
     */
    private BigDecimal price;
    /**
     * 0-1, 24 商品类目
     */
    private String goods_category;
    /**
     * 0-1, 128 商品类目树
     */
    private String categories_tree;
    /**
     * 0-1, 1000 商品描述信息
     */
    private String body;
}
