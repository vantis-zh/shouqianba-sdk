package com.vantisspace.sdk.shouqianba.pos.common.client;

import com.vantisspace.sdk.shouqianba.pos.bean.*;
import com.vantisspace.sdk.shouqianba.pos.common.bean.SQBPosResponse;
import org.junit.Test;

import java.math.BigDecimal;

public class SQBPosClientTest {
    @Test
    public void testActivate() {
        String uniqueId = "";
        String appId = "";
        String vendorSn = "";
        String vendorKey = "";
        String activateCode = "44397355";
        SQBPosClient client = new SQBPosClient(
                appId,
                vendorSn,
                vendorKey,
                "https://vsi-api.shouqianba.com");
        TerminalActivateRequestData request = new TerminalActivateRequestData();
        request.setCode(activateCode);
        request.setUniqueId(uniqueId);
        SQBPosResponse<TerminalActivateResponseData> response = client.activate(request);
        System.out.println(response);
        TerminalCheckInRequestData checkInRequest = new TerminalCheckInRequestData();
        checkInRequest.setUniqueId(uniqueId);
        SQBPosResponse<TerminalCheckInResponseData> checkInResponse = client.checkIn(checkInRequest);
        System.out.println(checkInResponse);
        UPayRequestData uPayRequestData = new UPayRequestData();
        uPayRequestData.setUniqueId(uniqueId);
        uPayRequestData.setClient_sn(uniqueId + "_" + System.currentTimeMillis());
        uPayRequestData.setTotal_amount("2");
        uPayRequestData.setDynamic_id(request.getClient_sn());
        uPayRequestData.setSubject(request.getUniqueId() + "_SUBJECT");
        SQBPosResponse<UPayResponseData> uPayResponse = client.call(uPayRequestData);
        System.out.println(uPayResponse);
    }
}
