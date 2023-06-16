package com.pragma.powerup.messagingmicroservice.domain.spi;


public interface ITwilioPersistencePort {

    void sendSMS(String msg, String phoneTo);

    String sendCodeVerificationSMS(String message, String phoneTo);

    String validateCodeVerificationSMS(String code, String phoneTo);


}
