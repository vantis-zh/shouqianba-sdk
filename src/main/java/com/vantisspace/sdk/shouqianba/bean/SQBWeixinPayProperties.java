package com.vantisspace.sdk.shouqianba.bean;

import lombok.Data;

@Data
public class SQBWeixinPayProperties {
    private String signAlgorithm = "SHA1withRSA";
    private String appid;
    private String username;
    private String brandCode;
    private String storeSn;
    private boolean testMode;
}
