package com.pragma.powerup.messagingmicroservice.domain.api;


public interface ITwilioServicePort {

    void notifyOrderStatus(String message, String phone);

    String sendCodeVerificationSMS(String message, String phone);

    String validateCodeVerificationSMS(String code, String phoneTo);

}
