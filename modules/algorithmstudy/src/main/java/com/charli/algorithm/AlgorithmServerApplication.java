package com.charli.algorithm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class AlgorithmServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgorithmServerApplication.class, args);
	}

}
