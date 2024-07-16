package com.vantisspace.sdk.shouqianba.litepos.bean;

import com.vantisspace.sdk.shouqianba.litepos.common.bean.RequestData;
import lombok.Data;

import java.util.List;

@Data
public class CardRefundRequestData implements RequestData<CardRefundResponseData> {
    /**
     * 1, 数字，最大 32 位 品牌编号，系统对接前由“收钱吧”提供
     */
    private String brand_code;
    /**
     * 0-1, 64 订单支付时传入的商户订单号,不能和 trade_no 同时为空。
     */
    private String out_trade_no;
    /**
     * 0-1, 64 核销订单号，和商户订单号不能同时为空
     */
    private String trade_no;
    /**
     * 0-1, 32 卡列表
     */
    private List<CardRedeem> refund_list;
    /**
     * 0-1, 256 退款的原因说明
     */
    private String refund_reason;
    /**
     * 1, 128 退款订单描述
     */
    private String body;
    /**
     * 0-1, 64 标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传。
     */
    private String out_request_no;
    /**
     * 1, 36 1, wechat; 2,alipay
     */
    private String user_channel;
    /**
     * 1, 255 微信用户为 UnionID，支付宝为用户 ID
     */
    private String user_id;
    /**
     * 0-1, 36 商户端的用户 id
     */
    private String client_member_id;
    /**
     * 1, 32 商户门店编号，对应收钱吧门店门店编号
     */
    private String store_id;
    /**
     * 1, 32 商户机具终端编号，对应收钱吧终端号
     */
    private String terminal_id;
    /**
     * 0-1, 30 商户的操作员编号
     */
    private String operator_id;
    /**
     * 0-1, 不限 订单包含的商品列表信息，json 格式，其它说明详见商品明细说明
     */
    private List<GoodsDetail> goods_detail;

    @Override
    public String url() {
        return "/api/lite-member/v1/members/card/refund";
    }
}
