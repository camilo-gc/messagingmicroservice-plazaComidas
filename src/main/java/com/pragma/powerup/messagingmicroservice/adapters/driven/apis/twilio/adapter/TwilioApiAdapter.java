package com.pragma.powerup.messagingmicroservice.adapters.driven.apis.twilio.adapter;


import com.pragma.powerup.messagingmicroservice.domain.spi.ITwilioPersistencePort;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.verify.v2.Service;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import com.twilio.type.PhoneNumber;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Value;


@CommonsLog
public class TwilioApiAdapter implements ITwilioPersistencePort {

    @Value("${twilio.accountSid}")
    private String account;
    @Value("${twilio.authToken}")
    private String token;
    @Value("${twilio.phoneFrom}")
    private String phoneFrom;

    private Service service;


    private Service getService(){
        Twilio.init(account, token);

        if (service == null) {
            service = Service.creator("claim order").create();
        }
        return service;
    }

    @Override
    public void sendSMS(String msg, String phoneTo) {

        Twilio.init(account, token);
        Message message = Message.creator(
                new PhoneNumber(phoneTo),
                new PhoneNumber(phoneFrom),
                msg
        ).create();

        log.info(message.getStatus() + " + " + message.getSid());

    }

    //@Override
    public String sendCodeVerificationSMS(String message, String phoneTo) {

        Twilio.init(account, token);
        Verification verification = Verification.creator(
                getService().getSid(),
                phoneTo,
                "sms"
        )
        //.setCustomMessage(message)
        .create();

        log.info(verification.getStatus() + " + " + verification.getSid() );

        return verification.getStatus();
    }
    public String validateCodeVerificationSMS(String code, String phoneTo) {

        Twilio.init(account, token);
        VerificationCheck verificationCheck = VerificationCheck.creator( getService().getSid(), code )
                .setTo(phoneTo).create();

        log.info(verificationCheck.getStatus() + " + " + verificationCheck.getSid());

        return verificationCheck.getStatus();

    }

}
