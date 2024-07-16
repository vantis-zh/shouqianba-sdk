package com.vantisspace.sdk.shouqianba.pos.common.bean;

import com.vantisspace.sdk.shouqianba.litepos.common.bean.Head;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class SQBPosResponse<T> implements Serializable {
    private String result_code;
    private String error_code_standard;
    private String error_message;
    private T biz_response;

    public boolean succeed() {
        return "200".equals(result_code);
    }
}
