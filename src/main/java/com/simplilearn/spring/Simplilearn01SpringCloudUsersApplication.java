package com.simplilearn.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Simplilearn01SpringCloudUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(Simplilearn01SpringCloudUsersApplication.class, args);
	}

}
