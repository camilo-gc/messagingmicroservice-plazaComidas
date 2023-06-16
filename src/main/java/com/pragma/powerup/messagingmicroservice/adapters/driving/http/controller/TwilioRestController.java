package com.pragma.powerup.messagingmicroservice.adapters.driving.http.controller;

import com.pragma.powerup.messagingmicroservice.adapters.driving.http.dto.request.SmsRequestDto;
import com.pragma.powerup.messagingmicroservice.adapters.driving.http.dto.request.ValidCodeRequestDto;
import com.pragma.powerup.messagingmicroservice.adapters.driving.http.handlers.ITwilioHandler;
import com.pragma.powerup.messagingmicroservice.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/notify")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
public class TwilioRestController {

    private final ITwilioHandler twilioHandler;

    @Operation(summary = "Send sms notify",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Notification sent",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Restaurant already exists",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error"))),
                    @ApiResponse(responseCode = "403", description = "Role not allowed for restaurant creation",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/sms")
    public ResponseEntity<Map<String, String>> notifyOrderStatus(@Valid @RequestBody SmsRequestDto smsRequestDto) {

        twilioHandler.notifyOrderStatus(smsRequestDto.getMessage(), smsRequestDto.getPhone());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.SMS_SENT_MESSAGE));

    }

    @PostMapping("/send-code")
    public ResponseEntity<Map<String, String>> sendCodeSms(@Valid @RequestBody SmsRequestDto smsRequestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(Collections.singletonMap(
                        Constants.SENT_CODE_STATUS_KEY,
                        twilioHandler.sendCodeVerificationSMS(smsRequestDto.getMessage(), smsRequestDto.getPhone()))
                );

    }

    @PostMapping("/valid-code")
    public ResponseEntity<Map<String, String>> validCodeSms(@Valid @RequestBody ValidCodeRequestDto validCodeRequestDto) {
        return ResponseEntity.ok(Collections.singletonMap(Constants.VERIFICATION_STATUS_KEY,
                twilioHandler.validCodeVerificationSMS(validCodeRequestDto.getCode(), validCodeRequestDto.getPhone()))
        );
    }


}