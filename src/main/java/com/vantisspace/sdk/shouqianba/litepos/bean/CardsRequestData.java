package com.vantisspace.sdk.shouqianba.litepos.bean;

import com.vantisspace.sdk.shouqianba.litepos.common.bean.RequestData;
import lombok.Data;

@Data
public class CardsRequestData implements RequestData<CardsResponseData> {
    /**
     * 1, 数字，最大 32 位 品牌编号，系统对接前由“收钱吧”提供
     */
    private String brand_code;
    /**
     * 1, 字符串，最大 36 位 1, wechat; 2,alipay
     */
    private String user_channel;
    /**
     * 1, 字符串，最大255 位 微信用户为 UnionID，支付宝为用户 ID
     */
    private String user_id;
    /**
     * 0-1, 字符串，最大 36 位 商户端的用户 id
     */
    private String client_member_id;
    /**
     * 0-1, 数字，1 位 0-不过滤；1-仅返回余额大于0的卡 不传该参数则不进行余额过滤
     */
    private String balance_filter;
    /**
     * 0-1, 数字，1 位 0-不过滤；1-仅返回未过期的卡 不传该参数则不进行过期过滤
     */
    private String expired_filter;

    @Override
    public String url() {
        return "/api/lite-member/v1/members/cards";
    }
}
