package com.pragma.powerup.messagingmicroservice.adapters.driving.http.dto.response;

public class MessageResponseDto {

    String mensaje;

    public MessageResponseDto(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}