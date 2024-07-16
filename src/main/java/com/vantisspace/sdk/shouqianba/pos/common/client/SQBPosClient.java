package com.vantisspace.sdk.shouqianba.pos.common.client;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.vantisspace.sdk.shouqianba.pos.bean.TerminalActivateRequestData;
import com.vantisspace.sdk.shouqianba.pos.bean.TerminalActivateResponseData;
import com.vantisspace.sdk.shouqianba.pos.bean.TerminalCheckInRequestData;
import com.vantisspace.sdk.shouqianba.pos.bean.TerminalCheckInResponseData;
import com.vantisspace.sdk.shouqianba.pos.common.bean.SQBPosRequest;
import com.vantisspace.sdk.shouqianba.pos.common.bean.SQBPosResponse;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class SQBPosClient {
    public static final Gson GSON = new GsonBuilder()
            .disableHtmlEscaping()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();
    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss+08:00";

    private final String appId;
    private final String vendorSn;
    private final String vendorKey;
    private final String apiDomain;

    // 后续需要改为 Redis 实现 对 key 进行每日过期
    private final Map<String, String> DEVICE_SN = new HashMap<>();
    private final Map<String, String> DEVICE_KEY = new HashMap<>();

    public SQBPosClient(String appId, String vendorSn, String vendorKey, String apiDomain) {
        this.appId = appId;
        this.vendorSn = vendorSn;
        this.vendorKey = vendorKey;
        this.apiDomain = apiDomain;
    }

    public void offlineActivate(String deviceId, String deviceSn, String deviceKey) {
        DEVICE_SN.put(deviceId, deviceSn);
        DEVICE_SN.put(deviceId, deviceKey);
    }

    public SQBPosResponse<TerminalActivateResponseData> activate(TerminalActivateRequestData request) {
        if (null == request.getUniqueId()) {
            throw new RuntimeException("请指定设备编号");
        }
        request.setApp_id(appId);
        request.setDevice_id(request.getUniqueId());
        SQBPosResponse<TerminalActivateResponseData> response = call(request, vendorSn, vendorKey);
        if (!response.succeed()) {
            log.error("激活失败, error: {}", GSON.toJson(response));
            throw new RuntimeException("激活失败: " + response.getError_message());
        }
        DEVICE_SN.put(request.getDevice_id(), response.getBiz_response().getTerminal_sn());
        DEVICE_KEY.put(request.getDevice_id(), response.getBiz_response().getTerminal_key());
        return response;
    }

    public SQBPosResponse<TerminalCheckInResponseData> checkIn(TerminalCheckInRequestData request) {
        if (null != request.getDevice_id()) {
            request.setUniqueId(request.getDevice_id());
        }
        if (null != request.getUniqueId()) {
            request.setUniqueId(request.getUniqueId());
        }
        if (null == request.getUniqueId()) {
            throw new RuntimeException("请指定设备编号");
        }
        String sn = DEVICE_SN.get(request.getUniqueId());
        String key = DEVICE_KEY.get(request.getUniqueId());
        if (null == key) {
            throw new RuntimeException("设备未激活");
        }

        SQBPosResponse<TerminalCheckInResponseData> response = call(request, sn, key);
        if (!response.succeed()) {
            log.error("签到失败, error: {}", GSON.toJson(response));
            throw new RuntimeException("签到失败: " + response.getError_message());
        }
        DEVICE_SN.put(request.getDevice_id(), response.getBiz_response().getTerminal_sn());
        DEVICE_KEY.put(request.getDevice_id(), response.getBiz_response().getTerminal_key());
        return response;
    }

    public <T> SQBPosResponse<T> call(SQBPosRequest<T> request) {
        if (null == request.getUniqueId()) {
            throw new RuntimeException("请指定设备编号");
        }
        if (request instanceof TerminalActivateRequestData) {
            ((TerminalActivateRequestData) request).setDevice_id(request.getUniqueId());
            return (SQBPosResponse<T>) activate((TerminalActivateRequestData) request);
        }

        String sn = DEVICE_SN.get(request.getUniqueId());
        String key = DEVICE_KEY.get(request.getUniqueId());
        if (null == key) {
            throw new RuntimeException("设备未激活");
        }

        request.setTerminal_sn(sn);
        if (request instanceof TerminalCheckInRequestData) {
            return (SQBPosResponse<T>) checkIn((TerminalCheckInRequestData) request);
        }

        return call(request, sn, key);
    }

    private <T> SQBPosResponse<T> call(SQBPosRequest<T> request, String sn, String key) {
        request.setUniqueId(null);
        String requestJson = GSON.toJson(request);
        log.info("SQB request, path: {}, param: {}", request.url(), requestJson);
        HttpRequest httpRequest = HttpRequest.post(apiDomain + request.url())
                .header("Content-Type", "Application/json")
                .header("Authorization", sn + " " + DigestUtil.md5Hex(
                        (requestJson + key).getBytes(StandardCharsets.UTF_8)))
                .body(requestJson);
        @Cleanup HttpResponse httpResponse = httpRequest.execute();
        String responseJson = httpResponse.body();
        log.info("SQB response, path:{}, param: {}, return: {}", request.url(), requestJson, responseJson);
        // FIXME 这里泛型没处理好
        Type type = request.getClass().getGenericSuperclass();
        Type responseClass;
        if (!(type instanceof ParameterizedType)) {
            throw new RuntimeException("未找到返回类型类信息");
        } else {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            responseClass = parameterizedType.getActualTypeArguments()[0];
        }
        return GSON.fromJson(responseJson, responseClass);
    }
}
