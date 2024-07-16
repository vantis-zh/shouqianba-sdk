package com.vantisspace.sdk.shouqianba.litepos.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CardRefundResponse implements Serializable {
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 售后单号
     */
    private String afterSaleNo;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 外部退款单号
     */
    private String outerTradeNo;
    /**
     * 退款成功与否
     */
    private Boolean success;
    /**
     * 退款失败原因
     */
    private String message;

    public static CardRefundResponse success(CardRefundRequest request, BigDecimal actualAmount, String outerTradeNo) {
        CardRefundResponse response = new CardRefundResponse();
        response.setSuccess(Boolean.TRUE);
        response.setMessage("成功");
        response.setAmount(actualAmount);
        response.setOuterTradeNo(outerTradeNo);
        if (request != null) {
            response.setAfterSaleNo(request.getAfterSaleNo());
            response.setOrderNo(request.getOrderNo());
        }
        return response;
    }

    public static CardRefundResponse fail(CardRefundRequest request, String message) {
        CardRefundResponse response = new CardRefundResponse();
        response.setSuccess(Boolean.FALSE);
        response.setMessage(message);
        if (request != null) {
            response.setAfterSaleNo(request.getAfterSaleNo());
            response.setOrderNo(request.getOrderNo());
        }
        return response;
    }
}
