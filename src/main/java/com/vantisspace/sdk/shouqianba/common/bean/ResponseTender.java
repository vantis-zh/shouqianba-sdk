package com.vantisspace.sdk.shouqianba.common.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class ResponseTender implements Serializable {
    private String reason;
    /**
     * 0-1 字符串，最大32位
     * 支付/退款指定中商户系统流水号，在商户系统中唯一
     **/
    private String original_transaction_sn;
    /**
     * 0-1 字符串，最大32位
     * 退款对应的原购货订单完成后本系统返回的支付流水号
     **/
    private String original_tender_sn;
    /**
     * 1 数字，最大32位
     * 支付/退款成功后，轻POS生成的唯一流水号
     **/
    private String tender_sn;
    /**
     * 1 数字，最大12位
     * 支付/退款金额，精确到分
     **/
    private String amount;
    /**
     * 1 数字，最大12位
     * 商家实收/实退金额，精确到分
     **/
    private String collected_amount;
    /**
     * 1 数字，最大12位
     * 消费者实付/实退金额，精确到分
     **/
    private String paid_amount;
    /**
     * 1 字符串，20- 25位
     * tender支付/退款时间, 格式详见 1.5时间数据元素定义
     **/
    private String pay_time;
    /**
     * 1 数字，1位
     * 支付状态, 1:待操作; 2:支付中; 3:支付成功; 4:退款中; 5:退款成功;6:退款失败;7:支付失败;8:未知状态;
     **/
    private String pay_status;
    /**
     * 1 数字，1位
     * 支付方式类型：0-其他，1-预授权完成，2-银行卡，3-QRCode，4-分期，99-外部
     **/
    private String tender_type;
    /**
     * 0-1 数字
     * 二级支付方式类型：
     * 001-现金，如需在轻POS录入其他支付方式，在对接时与收钱吧沟通配置；
     * 101-银行卡预授权完成，102-微信预授权完成，103-支付宝预授权完成；
     * 201-银行卡；
     * 301-微信，302-支付宝；
     * 401-银行卡分期，402-花呗分期
     **/
    private String sub_tender_type;
    /**
     * 0-1 字符串
     * 二级支付方式描述。如：微信支付
     **/
    private String sub_tender_desc;
    /**
     * 0-1 字符串，最大
     * 支付渠道流水号，操作成功时存在。
     * 微信支付宝：微信支付宝流水号；
     * 银行卡：银行卡流水号。
     **/
    private String channel_sn;
    /**
     * 0-1 字符串，最大
     * 移动支付：收钱吧传入支付宝/微信的out_trade_no；
     * 银行卡支付：交易返回的交易授权码
     **/
    private String internal_transaction_sn;
    /**
     * 0-1 对象
     * 支付渠道（银行卡/移动支付/礼品卡等）交易信息。定义见下表
     **/
    private Map<String, Object> channel_info;

    public static class ChannelInfo {
        /**
         * 0-1
         * 银行卡交易信息
         * 二级支付方式为“201-银行卡”返回
         * 定义见下表bank_card_info
         **/
        private BandCardInfo bank_card_info;
        /**
         * 0-1
         * 移动支付交易信息
         * 二级支付方式为“301-微信”，“302-支付宝”，“402-花呗分期”返回
         * 定义见下表mobile_payment_info
         **/
        private MobilePaymentInfo mobile_payment_info;
    }

    public static class BandCardInfo {
        /**
         * 1 字符串
         * 凭证号
         **/
        private String trace_no;
        /**
         * 1 字符串
         * 批次号
         **/
        private String batch_no;
        /**
         * 1 字符串
         * 系统参考号
         **/
        private String ref_no;
        /**
         * 1 字符串
         * 授权码
         **/
        private String auth_no;
        /**
         * 1 字符串
         * 发卡行号
         **/
        private String issuer_no;
        /**
         * 1 字符串
         * 发卡行名称
         **/
        private String issuer_name;
        /**
         * 1 字符串
         * 卡号（卡号中段为“*”号，已加密）
         **/
        private String card_no;
        /**
         * 1 字符串
         * 借贷记卡标识
         * 0：借记；1：贷记
         **/
        private String card_type_identity;
        /**
         * 1 字符串
         * 内外卡标识
         * 0：内卡；1：外卡
         **/
        private String abroad_card_type;
    }

    public static class MobilePaymentInfo {
        /**
         * 1 字符串，最大64位
         * 付款人ID，支付平台（微信，支付宝）上的付款人ID
         **/
        private String payer_uid;
    }
}
