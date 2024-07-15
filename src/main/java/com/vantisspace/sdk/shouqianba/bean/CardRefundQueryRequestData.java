package com.vantisspace.sdk.shouqianba.bean;

import com.vantisspace.sdk.shouqianba.common.bean.RequestData;
import lombok.Data;

@Data
public class CardRefundQueryRequestData implements RequestData<CardRefundQueryResponseData> {
    /**
     * 1, 32 品牌编号，系统对接前由“收钱吧”提供
     */
    private String brand_code;
    /**
     * 0-1, 64 订单支付时传入的商户订单号,和核销订单号不能同时为空。 trade_no,out_trade_no 如果同时存在优先取 trade_no
     */
    private String out_trade_no;
    /**
     * 0-1, 64 核销订单号，和商户订单号不能同时为空
     */
    private String trade_no;
    /**
     * 1, 64 请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号
     */
    private String out_request_no;

    @Override
    public String url() {
        return "/api/lite-member/v1/members/card/refund/query";
    }
}
