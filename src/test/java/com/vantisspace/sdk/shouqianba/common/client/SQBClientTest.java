package com.vantisspace.sdk.shouqianba.common.client;

import cn.hutool.core.lang.UUID;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import com.google.gson.Gson;
import com.vantisspace.sdk.shouqianba.bean.*;
import com.vantisspace.sdk.shouqianba.bean.callback.CardIssueCallback;
import com.vantisspace.sdk.shouqianba.bean.callback.SQBPayCallback;
import com.vantisspace.sdk.shouqianba.common.bean.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.vantisspace.sdk.shouqianba.common.client.SQBClient.GSON;

@Slf4j
public class SQBClientTest {
    private static final SQBClient shouQianBaClient;

    static {
        shouQianBaClient = new SQBClient(
                "",
                "",
                "",
                "https://vapi.shouqianba.com");
    }


    @Test
    public void testActivate() {
        WalletActivateRequestData request = new WalletActivateRequestData();
        request.setBrand_code("");
        request.setUser_channel("1");
        request.setUser_id("");
        request.setClient_member_id("");
        SQBResponse<WalletActivateResponseData> response = shouQianBaClient.call(request);
        log.info("回调解析: {}", GSON.toJson(response));
    }

    @Test
    public void testTopUp() {
        WalletTopUpRequestData request = new WalletTopUpRequestData();
        request.setBrand_code("");
        request.setUser_channel("1");
        request.setUser_id("");
        request.setCard_number("");
        request.setOut_trade_no("");
        request.setAmount("100");
        request.setNet_amount("0");
        request.setSubject("测试送充值金额");
        request.setClient_member_id("");
        SQBResponse<WalletTopUpResponseData> response = shouQianBaClient.call(request);
        log.info("回调解析: {}", GSON.toJson(response));
    }

    @Test
    public void testAliPay() {
        String amount = "100";
        SQBAliPayRequestBody request = new SQBAliPayRequestBody();
        request.setRequest_id(UUID.fastUUID().toString(true));
        request.setBrand_code("");
        request.setStore_sn("");
        request.setWorkstation_sn("0");
        request.setCheck_sn(request.getRequest_id());
        request.setScene("10");
        request.setSales_time(new SimpleDateFormat(SQBClient.DATE_FORMAT).format(new Date()));
        request.setExpire_time("15");
        request.setAmount(amount);
        request.setItem_amount(amount);
        request.setFreight("0");
        request.setCurrency("156");
        request.setSubject("测试支付宝订单");
        request.setDescription("测试支付宝订单描述");
        request.setOperator("测试操作员");
        request.setCustomer("测试顾客");
        request.setIndustry_code("0");
        request.setPos_info(request.getRequest_id());
        request.setNotify_url("");
        request.setReturn_url("");
        RequestTender tender = new RequestTender();
        tender.setTender_type("3");
        tender.setSub_tender_type("302");
        tender.setAmount(amount);
        request.setTenders(Collections.singletonList(tender));
        SQBResponse<SQBAliPayResponseData> sqbAliPayResponse = shouQianBaClient.aliPay(request);
        log.info("订单号: " + request.getRequest_id());
        log.info("地址: " + sqbAliPayResponse.getResponse().getBody().getBiz_response().getData().getCashier_url());
    }

    @Test
    public void testWeixinPay() {
        SQBWeixinPayRequestBody request = new SQBWeixinPayRequestBody();
        request.setRequest_id(UUID.fastUUID().toString(true));
        request.setBrand_code("");
        request.setStore_sn("测试店铺");
        request.setWorkstation_sn("0");
        request.setCheck_sn(request.getRequest_id());
        request.setSales_time(new SimpleDateFormat(SQBClient.DATE_FORMAT).format(new Date()));
        request.setExpire_time("15");
        request.setAmount("1");
        request.setItem_amount("1");
        request.setFreight("0");
        request.setCurrency("156");
        request.setSubject("测试微信订单");
        request.setDescription("测试微信订单描述");
        request.setOperator("测试操作员");
        request.setCustomer("测试顾客");
        request.setNotify_url("");
//        request.setReturn_url("");
        request.setTender_type("3");
        request.setSub_tender_type("301");
        request.setScene_type("3");
        request.setAppid("");
        request.setPayer_uid("");

        SQBResponse<SQBWeixinPayResponseData> response = shouQianBaClient.weixinPay(request);
        log.info("订单号: " + request.getRequest_id());
    }

    @Test
    public void testQuery() {
        SQBSalesQueryRequest request = new SQBSalesQueryRequest();
        request.setBrand_code("");
        request.setStore_sn("");
        request.setWorkstation_sn("0");
        request.setCheck_sn("");
        SQBResponse<SQBSalesQueryResponseData> sqbResponse = shouQianBaClient.query(request);
        log.info(new Gson().toJson(sqbResponse));
        String status = Optional.ofNullable(sqbResponse)
                .map(SQBResponse::getResponse)
                .map(SQBResponse.Response::getBody)
                .map(SQBResponse.Body::getBiz_response)
                .map(SQBResponse.BodyData::getData)
                .map(SQBSalesQueryResponseData::getTenders)
                .map(tenders -> tenders.get(0))
                .map(ResponseTender::getPay_status)
                .orElse(null);
        log.info(status);
    }

    @Test
    public void testRefundQuery() {
        SQBSalesQueryRequest request = new SQBSalesQueryRequest();
        request.setBrand_code("");
        request.setStore_sn("");
        request.setWorkstation_sn("0");
        request.setCheck_sn("");
        SQBResponse<SQBSalesQueryResponseData> sqbResponse = shouQianBaClient.query(request);
        log.info(new Gson().toJson(sqbResponse));
        String status = Optional.ofNullable(sqbResponse)
                .map(SQBResponse::getResponse)
                .map(SQBResponse.Response::getBody)
                .map(SQBResponse.Body::getBiz_response)
                .map(SQBResponse.BodyData::getData)
                .map(SQBSalesQueryResponseData::getTenders)
                .map(tenders -> tenders.get(0))
                .map(ResponseTender::getPay_status)
                .orElse(null);
        log.info(status);
    }

    @Test
    public void cancelPay() {
        SQBVoidPayRequest request = new SQBVoidPayRequest();
        request.setRequest_id(UUID.fastUUID().toString(true));
        request.setBrand_code("");
        request.setOriginal_store_sn("");
        request.setOriginal_workstation_sn("0");
        request.setOriginal_check_sn("");
        SQBResponse<SQBVoidPayResponseData> sqbResponse = shouQianBaClient.voidPay(request);
        log.info(new Gson().toJson(sqbResponse));
        String storeSn = Optional.ofNullable(sqbResponse)
                .map(SQBResponse::getResponse)
                .map(SQBResponse.Response::getBody)
                .map(SQBResponse.Body::getBiz_response)
                .map(SQBResponse.BodyData::getData)
                .map(SQBVoidPayResponseData::getStore_sn)
                .orElse(null);
        log.info(storeSn);
    }

    @Test
    public void testRefundParallel() throws Exception {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100, 100, 100, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1));
        for (int i = 0; i < 100; i++) {
            final int i0 = i;
            threadPoolExecutor.execute(() -> {
                try {
                    testRefund(Integer.toString(i0), -1, "");
                } catch (Exception e) {
                    log.error("测试退款报错", e);
                }
            });
        }
        threadPoolExecutor.shutdown();
        boolean b;
        do {
            b = threadPoolExecutor.awaitTermination(100, TimeUnit.SECONDS);
        } while (!b);
    }

    @Test
    public void testRefund() throws Exception {
        testRefund("1", -3, "");
        testRefund("1", -3, "");
        testRefund("1", -3, "");
    }

    public void testRefund(String flag, Integer amountCent, String tenderSn) throws Exception {
        SQBRefundRequest request = new SQBRefundRequest();
        request.setRequest_id(UUID.fastUUID().toString(true));
        request.setBrand_code("");
        request.setStore_sn("");
        request.setStore_name("");
        request.setWorkstation_sn("0");
        request.setCheck_sn(request.getRequest_id());
        request.setSales_time(new SimpleDateFormat(SQBClient.DATE_FORMAT).format(new Date()));
        request.setAmount(String.valueOf(amountCent));
        request.setCurrency("CNY");
        request.setSubject("测试退款");
//        request.setDescription();
        request.setOperator("测试操作员");
        request.setCustomer("测试顾客备注");
        request.setIndustry_code("0");
        request.setPos_info("测试POS机");
        request.setNotify_url("");
        SQBRefundRequest.Tender tender = new SQBRefundRequest.Tender();
        tender.setTransaction_sn(UUID.fastUUID().toString(true));
        tender.setAmount(String.valueOf(amountCent));
        tender.setPay_status("0");
        tender.setCreate_time(new SimpleDateFormat(SQBClient.DATE_FORMAT).format(new Date()));
        tender.setOriginal_tender_sn(tenderSn);
        request.setTenders(Collections.singletonList(tender));
        SQBResponse<SQBRefundResponseData> refund = shouQianBaClient.refund(request);
        log.info("退款: {} {}", flag, refund);
    }

    @Test
    public void testCardQuery() {
        CardsRequestData requestData = new CardsRequestData();
        requestData.setBrand_code("");
        requestData.setUser_channel("1");
        requestData.setUser_id(""); // vantis
        SQBResponse<CardsResponseData> response = shouQianBaClient.call(requestData);
        log.info(GSON.toJson(response));
    }

    @Test
    public void testCardRedeem() {
        CardRedeemRequestData requestData = new CardRedeemRequestData();
        requestData.setBrand_code("");
        requestData.setOut_trade_no("");
        requestData.setSubject("测试扣减");
        requestData.setUser_channel("1");
        requestData.setUser_id(""); // vantis
        requestData.setTotal_amount(BigDecimal.valueOf(100));
        requestData.setBody("测试扣减");
        CardRedeem cardRedeem = new CardRedeem();
        cardRedeem.setCard_number("");
        SQBResponse<CardRedeemResponseData> response = shouQianBaClient.call(requestData);
        log.info(GSON.toJson(response));
    }

    /**
     * 核销记录查询,使用记录查询
     */
    @Test
    public void testCardRedeemRecordsQuery() {
        CardUsedRequestData requestData = new CardUsedRequestData();
        requestData.setBrand_code("");
        requestData.setUser_id(""); // vantis
        requestData.setCard_number("");
        SQBResponse<CardUsedResponseData> response = shouQianBaClient.call(requestData);
        log.info(GSON.toJson(response));
    }

    /**
     * 购卡回调
     */
    @Test
    public void testCardIssueCallback() {
        CardIssueCallback request = new CardIssueCallback();
        String response = shouQianBaClient.generateWebhookResponse(new WebhookGenerateRequest());
        log.info(response);
    }

    /**
     * 退卡回调
     */
    @Test
    public void testCardReturnCallback() {
        String response = shouQianBaClient.generateWebhookResponse(new WebhookGenerateRequest());
        log.info(response);
    }

    @Test
    public void testCardRedeemQuery() {
        CardRedeemQueryRequestData requestData = new CardRedeemQueryRequestData();
        requestData.setBrand_code("");
        requestData.setOut_trade_no("");
        SQBResponse<CardRedeemResponseData> response = shouQianBaClient.call(requestData);
        log.info(GSON.toJson(response));
    }

    @Test
    public void testCardRefund() {
        CardRefundRequestData requestData = new CardRefundRequestData();
        requestData.setBrand_code("");
        requestData.setOut_trade_no("");
        requestData.setRefund_reason("测试退款");
        requestData.setBody("测试退款消息体");
        requestData.setOut_request_no(UUID.fastUUID().toString(true));
        requestData.setUser_channel("1");
        requestData.setUser_id(""); // vantis
        requestData.setStore_id("");
        requestData.setTerminal_id("0");
        /*CardRedeem cardRedeem = new CardRedeem();
        cardRedeem.setCard_number("");
        cardRedeem.setTotal_amount(BigDecimal.valueOf(1));
        requestData.setRefund_list(Collections.singletonList(cardRedeem));*/
        SQBResponse<CardRefundResponseData> response = shouQianBaClient.call(requestData);
        log.info(GSON.toJson(response));
    }

    @Test
    public void testCardRefundQuery() {
        CardRefundQueryRequestData requestData = new CardRefundQueryRequestData();
        requestData.setBrand_code("");
        requestData.setOut_trade_no("");
        requestData.setOut_request_no(UUID.fastUUID().toString(true));
        SQBResponse<CardRefundQueryResponseData> response = shouQianBaClient.call(requestData);
        log.info(GSON.toJson(response));
    }

    @Test
    public void testWebhook() throws ParseException {
        String json = "";
        SQBRequest<SQBPayCallback> request = shouQianBaClient.decodeCallback(json, SignAlgorithm.SHA1withRSA.getValue(), false);
        log.info("回调解析: {}", GSON.toJson(request));
        log.info("回调中的支付时间: {}", new SimpleDateFormat(SQBClient.DATE_FORMAT)
                .parse(request.getRequest().getBody().getTenders().get(0).getPay_time())
                .getTime());
    }

}
