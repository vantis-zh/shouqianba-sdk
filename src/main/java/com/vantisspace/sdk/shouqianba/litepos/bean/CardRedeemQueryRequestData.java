package com.vantisspace.sdk.shouqianba.litepos.bean;

import com.vantisspace.sdk.shouqianba.litepos.common.bean.RequestData;
import lombok.Data;

@Data
public class CardRedeemQueryRequestData implements RequestData<CardRedeemResponseData> {
    /**
     * 1, 32 品牌编号，系统对接前由“收钱吧”提供
     */
    private String brand_code;
    /**
     * 0-1, 64 核销时传入的商户订单号,和核销订单号不能同时为空。 trade_no,out_trade_no 如果同时存在优先取trade_no
     */
    private String out_trade_no;
    /**
     * 0-1, 64 核销订单号，和商户订单号不能同时为空
     */
    private String trade_no;

    @Override
    public String url() {
        return "/api/lite-member/v1/members/card/redeem/query";
    }
}
