package com.vantisspace.sdk.shouqianba.bean;

import com.vantisspace.sdk.shouqianba.common.bean.RequestData;
import lombok.Data;

@Data
public class WalletActivateRequestData implements RequestData<WalletActivateResponseData> {
    private String brand_code;
    private String user_channel;
    private String user_id;
    private String client_member_id;

    @Override
    public String url() {
        return "/api/lite-member/v1/issuer/svc/activate";
    }
}
