package com.vantisspace.sdk.shouqianba.bean.pos;

import com.vantisspace.sdk.shouqianba.pos.bean.TerminalActivateRequestData;
import org.junit.Test;

public class PosPay {
    @Test
    public void test() {
        /*
            vendor_sn
            91802187
            vendor_key
            0b2fb7eda1366bbf8d7f8a427b0140fc
            app_id
            B扫C应用：2024071500007358
            小程序应用：2024071500007359

            商户参数（测试）
            激活码
            44397355
         */
        TerminalActivateRequestData activateRequestData = new TerminalActivateRequestData();
        activateRequestData.setApp_id("2024071500007358");
        activateRequestData.setCode("44397355");
        activateRequestData.setDevice_id("XJH_WWZ_TEST_001");
    }

}
