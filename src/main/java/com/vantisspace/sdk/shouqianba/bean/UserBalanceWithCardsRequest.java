package com.vantisspace.sdk.shouqianba.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserBalanceWithCardsRequest implements Serializable {
    private String userChannel;
    private String userId;
    private String balanceFilter;
    private String expiredFilter;
}
