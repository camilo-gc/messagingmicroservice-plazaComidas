package com.pragma.powerup.messagingmicroservice.domain.usecase;

import com.pragma.powerup.messagingmicroservice.domain.api.ITwilioServicePort;
import com.pragma.powerup.messagingmicroservice.domain.spi.ITwilioPersistencePort;


public class TwilioUseCase implements ITwilioServicePort {

    private final ITwilioPersistencePort twilioPersistencePort;

    public TwilioUseCase(ITwilioPersistencePort twilioPersistencePort) {
        this.twilioPersistencePort = twilioPersistencePort;
    }

    public void notifyOrderStatus(String message, String phone){
        twilioPersistencePort.sendSMS(message, phone);
    }

    public String sendCodeVerificationSMS(String message, String phone){
        return twilioPersistencePort.sendCodeVerificationSMS(message, phone);
    }

    public String validateCodeVerificationSMS(String code, String phoneTo){
        return twilioPersistencePort.validateCodeVerificationSMS(code, phoneTo);
    }

}
