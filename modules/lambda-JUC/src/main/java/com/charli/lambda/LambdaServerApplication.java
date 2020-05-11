package com.charli.lambda;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@MapperScan("com.charli.lambda.mapper")
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class LambdaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LambdaServerApplication.class, args);
	}

}
