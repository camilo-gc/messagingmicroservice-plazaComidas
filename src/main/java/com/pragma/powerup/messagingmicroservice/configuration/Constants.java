package com.pragma.powerup.messagingmicroservice.configuration;


public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String RESPONSE_MESSAGE_KEY = "message";
    public static final String SMS_SENT_MESSAGE = "notification sent correctly";
    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";
    public static final String WRONG_CREDENTIALS_MESSAGE = "Wrong credentials";
    public static final String SWAGGER_TITLE_MESSAGE = "Plaza API Pragma Power Up";
    public static final String SWAGGER_DESCRIPTION_MESSAGE = "Plaza microservice";
    public static final String SWAGGER_VERSION_MESSAGE = "1.0.0";
    public static final String SWAGGER_LICENSE_NAME_MESSAGE = "Apache 2.0";
    public static final String SWAGGER_LICENSE_URL_MESSAGE = "http://springdoc.org";
    public static final String SWAGGER_TERMS_OF_SERVICE_MESSAGE = "http://swagger.io/terms/";

    public static final String SENT_CODE_STATUS_KEY = "sent_code_status";
    public static final String VERIFICATION_STATUS_KEY = "verification_status";
}
