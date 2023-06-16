package com.pragma.powerup.messagingmicroservice.adapters.driving.http.handlers;


public interface ITwilioHandler {

    void notifyOrderStatus(String message, String phone);

    String sendCodeVerificationSMS(String message, String phone);

    String validCodeVerificationSMS(String message, String phone);
}
