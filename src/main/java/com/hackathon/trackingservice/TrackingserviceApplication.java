package com.hackathon.trackingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.hackathon.trackingservice")
@SpringBootApplication
public class TrackingserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackingserviceApplication.class, args);
	}
}
