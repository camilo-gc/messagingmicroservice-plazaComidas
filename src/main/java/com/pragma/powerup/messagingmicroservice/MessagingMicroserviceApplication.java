package com.pragma.powerup.messagingmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MessagingMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagingMicroserviceApplication.class, args);
	}
}
