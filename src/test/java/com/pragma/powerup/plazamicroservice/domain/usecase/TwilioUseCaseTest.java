package com.pragma.powerup.plazamicroservice.domain.usecase;


import com.pragma.powerup.messagingmicroservice.domain.api.ITwilioServicePort;
import com.pragma.powerup.messagingmicroservice.domain.spi.ITwilioPersistencePort;
import com.pragma.powerup.messagingmicroservice.domain.usecase.TwilioUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;


@ExtendWith(MockitoExtension.class)
class TwilioUseCaseTest {

    private ITwilioPersistencePort twilioPersistencePort;
    private ITwilioServicePort twilioServicePort;

    @BeforeEach
    void setUp() {
        this.twilioPersistencePort = mock(ITwilioPersistencePort.class);
        this.twilioServicePort = new TwilioUseCase(twilioPersistencePort);
    }

    void notifyOrderStatus(){
        twilioPersistencePort.sendSMS("asd", "321");
        twilioServicePort.notifyOrderStatus("asd", "321");
    }

}
