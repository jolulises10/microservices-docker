package com.mktp.poc.arch.purchasesmktp.service;

public enum GeneralMessagesEnum {
    NO_PURCHASES_FOUND("No Purchases found");

    private String value;

    private GeneralMessagesEnum(String value){
        this.value = value;
    }
}
