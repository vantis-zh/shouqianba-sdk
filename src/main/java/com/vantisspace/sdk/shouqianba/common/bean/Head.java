package com.vantisspace.sdk.shouqianba.common.bean;

import com.vantisspace.sdk.shouqianba.common.client.SQBClient;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Head {
    private String appid;
    private String signType = "SHA256";
    // 2019-09-26T19:57:29+08:00
    private String requestTime = new SimpleDateFormat(SQBClient.DATE_FORMAT).format(new Date());
    private String version = "1.0.0";
}
