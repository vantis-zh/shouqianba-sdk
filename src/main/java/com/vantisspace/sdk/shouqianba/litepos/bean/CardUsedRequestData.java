package com.vantisspace.sdk.shouqianba.litepos.bean;

import com.vantisspace.sdk.shouqianba.litepos.common.bean.RequestData;
import lombok.Data;

/**
 * 礼品卡使用记录
 */
@Data
public class CardUsedRequestData implements RequestData<CardUsedResponseData> {
    /**
     * 数字，最大 32 位	品牌编号，系统对接前由“收钱吧”提供
     */
    private String brand_code;
    /**
     * String	字符串，最大 36 位	需要查询的卡的卡号
     */
    private String card_number;
    /**
     * String	字符串，最大 255 位	微信用户为 UnionID，支付宝为用户 ID
     */
    private String user_id;
    /**
     * String	字符串，最大 36 位	商户端的用户 id
     */
    private String client_member_id;

    @Override
    public String url() {
        return "/api/lite-member/v1/members/card/redeemRecords";
    }
}
