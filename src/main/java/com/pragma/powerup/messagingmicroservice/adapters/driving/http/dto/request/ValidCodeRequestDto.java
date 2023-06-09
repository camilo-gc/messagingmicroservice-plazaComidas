package com.pragma.powerup.messagingmicroservice.adapters.driving.http.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ValidCodeRequestDto {

    @NotBlank
    private String code;

    @NotBlank
    @Pattern(regexp = "\\+[0-9]{12}", message = "invalid phone number")
    private String phone;

}
