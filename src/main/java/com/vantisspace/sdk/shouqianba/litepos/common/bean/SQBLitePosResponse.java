package com.vantisspace.sdk.shouqianba.litepos.common.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class SQBLitePosResponse<T> implements Serializable {
    private Response<T> response;
    private String signature;

    @Data
    public static class Response<T> {
        private Head head;
        private Body<T> body;
    }

    @Data
    public static class Body<T> {
        private String result_code;
        private String error_code;
        private String error_message;
        private BodyData<T> biz_response;
    }

    @Data
    public static class BodyData<T> {
        private String result_code;
        private String error_code;
        private String error_message;
        private T data;
    }

    public String errorMessage() {
        if (null == this.getResponse().getBody()) {
            return "(返回参数无 body)";
        }
        if (null != this.getResponse().getBody().getBiz_response()) {
            return this.getResponse().getBody().getBiz_response().getError_message();
        }
        return this.getResponse().getBody().getError_message();
    }


    public boolean succeed() {
        if (null == this.getResponse().getBody()) {
            return false;
        }
        Body<T> body = this.getResponse().getBody();
        return "200".equals(body.getResult_code())
                && Objects.nonNull(body.getBiz_response())
                && "SUCCESS".equals(body.getBiz_response().getResult_code());
    }

    public boolean bizError() {
        if (null == this.getResponse().getBody()) {
            return false;
        }
        Body<T> body = this.getResponse().getBody();
        return "200".equals(body.getResult_code())
                && Objects.nonNull(body.getBiz_response())
                && !Objects.equals("SUCCESS", body.getBiz_response().getResult_code());
    }

    public boolean bizErrorAsCode(String errorCode) {
        if (null == this.getResponse().getBody()) {
            return false;
        }
        Body<T> body = this.getResponse().getBody();
        return "200".equals(body.getResult_code())
                && Objects.nonNull(body.getBiz_response())
                && !Objects.equals("SUCCESS", body.getBiz_response().getResult_code())
                && Objects.equals(body.getBiz_response().getError_code(), errorCode);
    }
}
