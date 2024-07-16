package com.vantisspace.sdk.shouqianba.litepos.common.client;

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
import com.vantisspace.sdk.shouqianba.litepos.bean.SQBAliPayRequestBody;
import com.vantisspace.sdk.shouqianba.litepos.bean.SQBAliPayResponseData;
import com.vantisspace.sdk.shouqianba.litepos.bean.SQBWeixinPayRequestBody;
import com.vantisspace.sdk.shouqianba.litepos.bean.SQBWeixinPayResponseData;
import com.vantisspace.sdk.shouqianba.litepos.bean.callback.Callback;
import com.vantisspace.sdk.shouqianba.litepos.common.bean.*;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

@Slf4j
public class SQBLitePosClient {
    public static final Gson GSON = new GsonBuilder()
            .disableHtmlEscaping()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();
    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss+08:00";

    public SQBLitePosClient(String appId, String privateKey, String verifyPublicKey, String apiDomain) {
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

    public SQBLitePosResponse<SQBAliPayResponseData> aliPay(SQBAliPayRequestBody request) {
        SQBLitePosRequest<SQBAliPayRequestBody> signedRequest = generateRequest(request);
        String responseJson = call(ALIPAY_PURCHASE, signedRequest);
        return GSON.fromJson(
                responseJson,
                new TypeToken<SQBLitePosResponse<SQBAliPayResponseData>>() {
                }.getType());
    }

    public SQBLitePosResponse<SQBWeixinPayResponseData> weixinPay(SQBWeixinPayRequestBody request) {
        SQBLitePosRequest<SQBWeixinPayRequestBody> signedRequest = generateRequest(request);
        String responseJson = call(WEIXINPAY, signedRequest);
        return GSON.fromJson(
                responseJson,
                new TypeToken<SQBLitePosResponse<SQBWeixinPayResponseData>>() {
                }.getType());
    }

    public SQBLitePosResponse<SQBVoidPayResponseData> voidPay(SQBVoidPayRequest request) {
        SQBLitePosRequest<SQBVoidPayRequest> signedRequest = generateRequest(request);
        String responseJson = call(CANCEL, signedRequest);
        return GSON.fromJson(
                responseJson,
                new TypeToken<SQBLitePosResponse<SQBVoidPayResponseData>>() {
                }.getType());
    }

    public SQBLitePosResponse<SQBSalesQueryResponseData> query(SQBSalesQueryRequest request) {
        SQBLitePosRequest<SQBSalesQueryRequest> signedRequest = generateRequest(request);
        String responseJson = call(SALES_QUERY, signedRequest);
        SQBLitePosResponse<SQBSalesQueryResponseData> response = GSON.fromJson(
                responseJson,
                new TypeToken<SQBLitePosResponse<SQBSalesQueryResponseData>>() {
                }.getType());

        return response;
    }

    public SQBLitePosResponse<SQBRefundResponseData> refund(SQBRefundRequest request) {
        SQBLitePosRequest<SQBRefundRequest> signedRequest = generateRequest(request);
        String responseJson = call(REFUND, signedRequest);
        SQBLitePosResponse<SQBRefundResponseData> response = GSON.fromJson(
                responseJson,
                new TypeToken<SQBLitePosResponse<SQBRefundResponseData>>() {
                }.getType());

        return response;
    }

    public <T extends Callback> SQBLitePosRequest<T> decodeCallback(String json,
                                                                    String signAlgorithm,
                                                                    boolean ignoreVerify) {
        if (!ignoreVerify && !verifySignForWebhook(json, signAlgorithm)) {
            throw new RuntimeException("签名验证失败");
        }
        return GSON.fromJson(json, new TypeToken<SQBLitePosRequest<T>>() {
        }.getType());
    }

    public <T extends Callback> SQBLitePosRequest<T> decodeCallback(String json, String signAlgorithm) {
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

    private <T> String call(String path, SQBLitePosRequest<T> request) {
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

    private <U> SQBLitePosRequest<U> generateRequest(U requestBody) {
        SQBLitePosRequest.Request<U> request = new SQBLitePosRequest.Request<>(appId, requestBody);
        Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKey, null);
        String json = GSON.toJson(request);
        byte[] signResult = sign.sign(json.getBytes(StandardCharsets.UTF_8));
        return new SQBLitePosRequest<>(request, Base64.encode(signResult));
    }

    public String generateWebhookResponse(WebhookGenerateRequest webhookGenerateRequest) {
        SQBLitePosResponse.BodyData<Void> bodyData = new SQBLitePosResponse.BodyData<>();
        bodyData.setResult_code("200");
        SQBLitePosResponse.Body<Void> body = new SQBLitePosResponse.Body<>();
        body.setResult_code("200");
        body.setBiz_response(bodyData);
        Head head = new Head();
        head.setAppid(appId);
        SQBLitePosResponse.Response<Void> response = new SQBLitePosResponse.Response<>();
        response.setHead(head);
        response.setBody(body);
        SQBLitePosResponse<Void> sqbLitePosResponse = new SQBLitePosResponse<>();
        sqbLitePosResponse.setResponse(response);
        Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, privateKey, null);
        String json = GSON.toJson(response);
        byte[] signResult = sign.sign(json.getBytes(StandardCharsets.UTF_8));
        sqbLitePosResponse.setSignature(Base64.encode(signResult));
        return GSON.toJson(sqbLitePosResponse);
    }

    public <T> SQBLitePosResponse<T> call(RequestData<T> requestBody) {
        SQBLitePosRequest<RequestData<T>> request = generateRequest(requestBody);
        String responseJson = call(requestBody.url(), request);
        Type jsonType = new TypeToken<SQBLitePosResponse<T>>() {
        }.getType();
        return GSON.fromJson(responseJson, jsonType);
    }

//    public <T> SQBResponse<T> call(RequestData<T> requestBody, Type typeOfT) {
//        SQBRequest<RequestData<T>> request = generateRequest(requestBody);
//        String responseJson = call(requestBody.url(), request);
//        return GSON.fromJson(responseJson, typeOfT);
//    }
}
