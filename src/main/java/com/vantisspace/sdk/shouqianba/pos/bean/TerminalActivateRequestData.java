package com.vantisspace.sdk.shouqianba.pos.bean;

import com.vantisspace.sdk.shouqianba.pos.common.bean.SQBPosRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TerminalActivateRequestData extends SQBPosRequest<TerminalActivateResponseData> {
    /**
     * Y
     * 应用ID
     */
    private String app_id;
    /**
     * Y
     * 激活码内容
     */
    private String code;
    /**
     * Y
     * 内容自行定义，同一个app_id下唯一；为了方便识别，建议具有一定的格式；例：品牌名称+支付场景
     */
    private String device_id;
    /**
     * N
     * 第三方终端号，必须保证在app id下唯一
     */
    private String client_sn;
    /**
     * N
     * 终端名
     */
    private String name;
    /**
     * N
     * 当前系统信息，如: Android5.0
     */
    private String os_info;
    /**
     * N
     * SDK版本
     */
    private String sdk_version;

    @Override
    public String url() {
        return "/terminal/activate";
    }
}
