package com.vantisspace.sdk.shouqianba.litepos.bean;

import lombok.Data;

import javax.smartcardio.Card;
import java.io.Serializable;
import java.util.List;

@Data
public class CardIssueResponseData implements Serializable {
    /**
     * 1, 卡列表 卡列表，数组
     */
    private List<Card> cards;
}
