package com.pragma.powerup.messagingmicroservice.adapters.driving.http.handlers.impl;


import com.pragma.powerup.messagingmicroservice.adapters.driving.http.handlers.ITwilioHandler;
import com.pragma.powerup.messagingmicroservice.domain.api.ITwilioServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TwilioHandlerImpl implements ITwilioHandler {

    private final ITwilioServicePort twilioServicePort;

    @Override
    public void notifyOrderStatus(String message, String phone) {
        twilioServicePort.notifyOrderStatus( message, phone );
    }

    @Override
    public String sendCodeVerificationSMS(String message, String phone) {
        return twilioServicePort.sendCodeVerificationSMS(message, phone );
    }

    @Override
    public String validCodeVerificationSMS(String message, String phone) {
        return twilioServicePort.validateCodeVerificationSMS( message, phone );
    }

}
