package com.vantisspace.sdk.shouqianba.bean;

import com.vantisspace.sdk.shouqianba.common.bean.RequestData;
import lombok.Data;

@Data
public class WalletTopUpRequestData implements RequestData<WalletTopUpResponseData> {
    /**
     * 品牌编号, 1, 分配值, 品牌编号，系统对接前由“收钱吧”提供
     */
    private String brand_code;
    /**
     * 用户渠道, 1, 枚举值, 1, wechat; 2,alipay
     */
    private String user_channel;
    /**
     * 用户 ID, 1, 最大128位, 微信用户为 UnionID，支付宝为用户 ID
     */
    private String user_id;
    /**
     * 商户系统用户 ID, 0-1, 最大36位, 商户系统的用户id，如CRM 的用户ID 或者商户小程序OpenID
     */
    private String client_member_id;
    /**
     * 账户编号, 1, 最大20位, 需要充值的账户编号
     */
    private String card_number;
    /**
     * 商户订单号, 1, 最大64位, 商户订单号,64 个字符以内、可包含字母、数字、下划线
     */
    private String out_trade_no;
    /**
     * 订单标题, 1, 最大64位, 订单标题
     */
    private String subject;
    /**
     * 充值金额, 1, 数字字符，最大10位, 充值金额，精确到分
     */
    private String amount;
    /**
     * 充值净额, 1, 数字字符，最大10位, 充值净额，精确到分
     */
    private String net_amount;
    /**
     * 充值门店 id, 0-1, 最大128位, 充值门店 id，对应商户侧的商户门店号
     */
    private String reload_store_id;
    /**
     * 充值门店名, 0-1, 最大128位, 充值门店名，对应商户侧的门店名
     */
    private String reload_store_name;
    /**
     * 商户操作员编号, 0-1, 最大28位, 商户操作员编号
     */
    private String operator_id;

    @Override
    public String url() {
        return "/api/lite-member/v1/members/card/reload";
    }
}
