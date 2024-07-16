package com.vantisspace.sdk.shouqianba.pos.common.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class SQBPosRequest<T> implements Serializable {
    /**
     * 必填
     */
    private String uniqueId;
    /**
     * 无需填写 客户端自动根据 deviceId 获取
     */
    private String terminal_sn;

    public abstract String url();
}
