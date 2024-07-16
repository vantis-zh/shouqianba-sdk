package com.vantisspace.sdk.shouqianba.pos.bean;

import com.vantisspace.sdk.shouqianba.litepos.common.bean.RequestData;
import com.vantisspace.sdk.shouqianba.pos.common.bean.SQBPosRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TerminalCheckInRequestData extends SQBPosRequest<TerminalCheckInResponseData> {
    /**
     * Y
     * 设备唯一身份ID
     */
    private String device_id;
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
        return "/terminal/checkin";
    }
}
