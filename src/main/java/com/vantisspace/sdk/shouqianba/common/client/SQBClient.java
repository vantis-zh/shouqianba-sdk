package com.vantisspace.sdk.shouqianba.common.client;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import cn.hutool.http.HttpUtil;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.vantisspace.sdk.shouqianba.bean.SQBAliPayRequestBody;
import com.vantisspace.sdk.shouqianba.bean.SQBAliPayResponseData;
import com.vantisspace.sdk.shouqianba.bean.SQBWeixinPayRequestBody;
import com.vantisspace.sdk.shouqianba.bean.SQBWeixinPayResponseData;
import com.vantisspace.sdk.shouqianba.bean.callback.Callback;
import com.vantisspace.sdk.shouqianba.common.bean.*;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

@Slf4j
public class SQBClient {
    public static final Gson GSON = new GsonBuilder()
            .disableHtmlEscaping()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();
    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss+08:00";

    public SQBClient(String appId, String privateKey, String verifyPublicKey, String apiDomain) {
        this.appId = appId;
        this.privateKey = privateKey;
        this.verifyPublicKey = verifyPublicKey;
        this.apiDomain = apiDomain;
    }

    private final String appId;
    private final String privateKey;
    private final String verifyPublicKey;
    private final String apiDomain;
    private static final String ALIPAY_PURCHASE = "/api/lite-pos/v1/sales/purchase";
    private static final String WEIXINPAY = "/api/lite-pos/v1/sales/ipay";
    private static final String SALES_QUERY = "/api/lite-pos/v1/sales/query";
    private static final String REFUND = "/api/lite-pos/v1/sales/refund";
    private static final String CANCEL = "/api/lite-pos/v1/sales/void";

    public SQBResponse<SQBAliPayResponseData> aliPay(SQBAliPayRequestBody request) {
        SQBRequest<SQBAliPayRequestBody> signedRequest = generateRequest(request);
        String responseJson = call(ALIPAY_PURCHASE, signedRequest);
        return GSON.fromJson(
                responseJson,
                new TypeToken<SQBResponse<SQBAliPayResponseData>>() {
                }.getType());
    }

    public SQBResponse<SQBWeixinPayResponseData> weixinPay(SQBWeixinPayRequestBody request) {
        SQBRequest<SQBWeixinPayRequestBody> signedRequest = generateRequest(request);
        String responseJson = call(WEIXINPAY, signedRequest);
        return GSON.fromJson(
                responseJson,
                new TypeToken<SQBResponse<SQBWeixinPayResponseData>>() {
                }.getType());
    }

    public SQBResponse<SQBVoidPayResponseData> voidPay(SQBVoidPayRequest request) {
        SQBRequest<SQBVoidPayRequest> signedRequest = generateRequest(request);
        String responseJson = call(CANCEL, signedRequest);
        return GSON.fromJson(
                responseJson,
                new TypeToken<SQBResponse<SQBVoidPayResponseData>>() {
                }.getType());
    }

    public SQBResponse<SQBSalesQueryResponseData> query(SQBSalesQueryRequest request) {
        SQBRequest<SQBSalesQueryRequest> signedRequest = generateRequest(request);
        String responseJson = call(SALES_QUERY, signedRequest);
        SQBResponse<SQBSalesQueryResponseData> response = GSON.fromJson(
                responseJson,
                new TypeToken<SQBResponse<SQBSalesQueryResponseData>>() {
                }.getType());

        return response;
    }

    public SQBResponse<SQBRefundResponseData> refund(SQBRefundRequest request) {
        SQBRequest<SQBRefundRequest> signedRequest = generateRequest(request);
        String responseJson = call(REFUND, signedRequest);
        SQBResponse<SQBRefundResponseData> response = GSON.fromJson(
                responseJson,
                new TypeToken<SQBResponse<SQBRefundResponseData>>() {
                }.getType());

        return response;
    }

    public <T extends Callback> SQBRequest<T> decodeCallback(String json,
                                                             String signAlgorithm,
                                                             boolean ignoreVerify) {
        if (!ignoreVerify && !verifySignForWebhook(json, signAlgorithm)) {
            throw new RuntimeException("签名验证失败");
        }
        return GSON.fromJson(json, new TypeToken<SQBRequest<T>>() {
        }.getType());
    }

    public <T extends Callback> SQBRequest<T> decodeCallback(String json, String signAlgorithm) {
        return decodeCallback(json, signAlgorithm, false);
    }

    private boolean verifySign(String response) {
        return verifySign(response, SignAlgorithm.SHA256withRSA);
    }

    private boolean verifySign(String response, SignAlgorithm algorithm) {
        JsonObject responseJsonObject = GSON.fromJson(response, JsonObject.class);
        String signature = responseJsonObject.get("signature").getAsString();
        String responseJson = responseJsonObject.get("response").toString();
        Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, null, verifyPublicKey);
        return sign.verify(responseJson.getBytes(StandardCharsets.UTF_8), Base64.decode(signature));
    }

    private boolean verifySignForWebhook(String response) {
        JsonObject responseJsonObject = GSON.fromJson(response, JsonObject.class);
        String signAlgorithm = responseJsonObject.get("sign_type").getAsString() + "withRSA";
        return verifySignForWebhook(response, signAlgorithm);
    }

    private boolean verifySignForWebhook(String response, String signAlgorithm) {
        JsonObject responseJsonObject = GSON.fromJson(response, JsonObject.class);
        return verifySignForWebhook(responseJsonObject, signAlgorithm);
    }

    private boolean verifySignForWebhook(JsonObject responseJsonObject, String signAlgorithm) {
        String signature = responseJsonObject.get("signature").getAsString();
        if (CharSequenceUtil.isEmpty(signAlgorithm)) {
            signAlgorithm = responseJsonObject.get("sign_type").getAsString() + "withRSA";
        }
        String responseJson = responseJsonObject.get("request").toString();
        Sign sign = SecureUtil.sign(SignAlgorithm.valueOf(signAlgorithm), null, verifyPublicKey);
        return sign.verify(responseJson.getBytes(StandardCharsets.UTF_8), Base64.decode(signature));
    }

    private <T> String call(String path, SQBRequest<T> request) {
        String requestJson = GSON.toJson(request);
        log.info("SQB request, path: {}, param: {}", path, requestJson);
        String responseJson = HttpUtil.post(apiDomain + path, requestJson);
        log.info("SQB response, path:{}, param: {}, return:{}", path, requestJson, responseJson);
        boolean verified = verifySign(responseJson);
        if (!verified) {
            throw new RuntimeException("签名验证失败");
        }
        return responseJson;
    }

    private <U> SQBRequest<U> generateRequest(U requestBody) {
        SQBRequest.Request<U> request = new SQBRequest.Request<>(appId, requestBody);
        Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKey, null);
        String json = GSON.toJson(request);
        byte[] signResult = sign.sign(json.getBytes(StandardCharsets.UTF_8));
        return new SQBRequest<>(request, Base64.encode(signResult));
    }

    public String generateWebhookResponse(WebhookGenerateRequest webhookGenerateRequest) {
        SQBResponse.BodyData<Void> bodyData = new SQBResponse.BodyData<>();
        bodyData.setResult_code("200");
        SQBResponse.Body<Void> body = new SQBResponse.Body<>();
        body.setResult_code("200");
        body.setBiz_response(bodyData);
        Head head = new Head();
        head.setAppid(appId);
        SQBResponse.Response<Void> response = new SQBResponse.Response<>();
        response.setHead(head);
        response.setBody(body);
        SQBResponse<Void> sqbResponse = new SQBResponse<>();
        sqbResponse.setResponse(response);
        Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKey, null);
        String json = GSON.toJson(response);
        byte[] signResult = sign.sign(json.getBytes(StandardCharsets.UTF_8));
        sqbResponse.setSignature(Base64.encode(signResult));
        return GSON.toJson(sqbResponse);
    }

    public <T> SQBResponse<T> call(RequestData<T> requestBody) {
        SQBRequest<RequestData<T>> request = generateRequest(requestBody);
        String responseJson = call(requestBody.url(), request);
        Type jsonType = new TypeToken<SQBResponse<T>>() {
        }.getType();
        return GSON.fromJson(responseJson, jsonType);
    }

//    public <T> SQBResponse<T> call(RequestData<T> requestBody, Type typeOfT) {
//        SQBRequest<RequestData<T>> request = generateRequest(requestBody);
//        String responseJson = call(requestBody.url(), request);
//        return GSON.fromJson(responseJson, typeOfT);
//    }
}
