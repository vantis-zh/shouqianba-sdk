package com.vantisspace.sdk.shouqianba.pos.bean;

import java.util.HashMap;

public class Extend extends HashMap<String, String> {
    public interface Param {
        String HB_FQ_NUM = "hb_fq_num";
        String HB_FQ_SELLER_PERCENT = "hb_fq_seller_percent";
    }

    /**
     * 目前支持3/6/12期，前置参数为extended.extend_params
     */
    public String getHbFqNum() {
        return this.get(Param.HB_FQ_NUM);
    }

    /**
     * 商家承担手续费传入100，用户承担手续费传入0，前置参数为extended.extend_params
     */
    public String getHbFqSellerPercent() {
        return this.get(Param.HB_FQ_NUM);
    }
}
