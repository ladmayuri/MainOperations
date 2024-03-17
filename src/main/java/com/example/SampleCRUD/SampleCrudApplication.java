package com.example.SampleCRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SampleCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleCrudApplication.class, args);
	}

}
