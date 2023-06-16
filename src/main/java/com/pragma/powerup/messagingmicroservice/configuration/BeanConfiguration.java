package com.pragma.powerup.messagingmicroservice.configuration;


import com.pragma.powerup.messagingmicroservice.adapters.driven.apis.twilio.adapter.TwilioApiAdapter;
import com.pragma.powerup.messagingmicroservice.domain.api.ITwilioServicePort;
import com.pragma.powerup.messagingmicroservice.domain.spi.ITwilioPersistencePort;
import com.pragma.powerup.messagingmicroservice.domain.usecase.TwilioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    @Bean
    public ITwilioServicePort twilioServicePort() {
        return new TwilioUseCase(twilioPersistencePort());
    }

    @Bean
    public ITwilioPersistencePort twilioPersistencePort() {
        return new TwilioApiAdapter();
    }

}