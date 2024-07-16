package com.vantisspace.sdk.shouqianba.pos.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProviderResponse implements Serializable {
    /**
     * 核销单品信息
     */
    private List<ProviderGoodsDetail> goods_details;
    /**
     * 核销券信息
     */
    private List<ProviderVoucherDetail> voucher_details;
}
