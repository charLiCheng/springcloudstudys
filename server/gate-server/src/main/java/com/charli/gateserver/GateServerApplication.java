package com.charli.gateserver;

import com.charli.gateserver.filters.SimpleFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients
public class GateServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GateServerApplication.class, args);
	}

	@Bean
	public SimpleFilter simpleFilter(){
		return new SimpleFilter();
	}

}
