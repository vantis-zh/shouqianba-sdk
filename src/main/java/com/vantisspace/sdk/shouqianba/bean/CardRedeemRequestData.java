package com.vantisspace.sdk.shouqianba.bean;

import com.vantisspace.sdk.shouqianba.common.bean.RequestData;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
public class CardRedeemRequestData implements RequestData<CardRedeemResponseData> {
    /**
     * 1, 32 品牌编号，系统对接前由“收钱吧”提供
     */
    private String brand_code;
    /**
     * 1, 64 商户订单号,64 个字符以内、可包含字母、数字、下划线；
     */
    private String out_trade_no;
    /**
     * 0-1, 32 卡列表
     */
    private List<CardRedeem> redeem_list;
    /**
     * 1, 64 订单标题
     */
    private String subject;
    /**
     * 1, 20 1, wechat; 2,alipay
     */
    private String user_channel;
    /**
     * 1, 128 微信用户为 UnionID，支付宝为用户 ID
     */
    private String user_id;
    /**
     * 0-1, 36 商户端的用户 id
     */
    private String client_member_id;
    /**
     * 1, 11 订单总金额，单位为分
     */
    private BigDecimal total_amount;
    /**
     * 1, 128 支付订单描述
     */
    private String body;
    /**
     * 0-1, - 订单包含的商品列表信息，json 格式，其它说明详见商品明细说明
     */
    private GoodsDetail[] goods_detail;
    /**
     * 0-1, 28 商户操作员编号
     */
    private String operator_id;
    /**
     * 0-1, 32 商户门店编号
     */
    private String store_id;
    /**
     * 0-1, 32 商户机具终端编号
     */
    private String terminal_id;
    /**
     * 0-1, 不限 业务扩展参数
     */
    private Map<String, String> extend_params;

    @Override
    public String url() {
        return "/api/lite-member/v1/members/card/redeem";
    }
}
