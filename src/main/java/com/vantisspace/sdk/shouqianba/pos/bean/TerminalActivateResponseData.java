package com.vantisspace.sdk.shouqianba.pos.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class TerminalActivateResponseData implements Serializable {
    /**
     * Y
     * 终端号
     */
    private String terminal_sn;
    /**
     * Y
     * 终端密钥
     */
    private String terminal_key;
}
