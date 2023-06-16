package com.pragma.powerup.messagingmicroservice.domain.spi;

public interface IJwtProviderConfigurationPort {

    String getIdFromToken(String token);

    String getUserNameFromToken(String token);

    String getRoleFromToken(String token);

}
