package com.vantisspace.sdk.shouqianba.litepos.bean.callback;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CardReturnCallback extends Callback {
    private String brand_code;//	1	String	字符串，最大 20 位	品牌编号，系统对接前由“收钱吧”提供
    private String order_no;//	1	String	字符串，最大 36 位	商户指定的退卡订单号，在礼品卡商户后台内确认退卡的时候填写
    private String card_number;//	1	String	字符串，最大 36 位	发起退卡的卡号
    private String cash_out_amount;//	1	String	字符串，最大 11 位	商户指定的实际退卡的金额，以分为单位
    private String biz_time;//	1	String	字符串，最大 20 位	退卡完成的时间
    private String remark;//	1	String	字符串，最大 128 位	商户操作退卡完成时候指定的退卡备注信息
}
