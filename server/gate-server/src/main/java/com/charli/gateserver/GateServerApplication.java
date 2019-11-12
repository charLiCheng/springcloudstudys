package com.charli.gateserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients
public class GateServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GateServerApplication.class, args);
	}

}
