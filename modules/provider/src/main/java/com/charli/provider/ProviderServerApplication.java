package com.charli.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @Description :  @EnableDiscoveryClient不加这个注解会出错,注册不上去,感觉应该有问题
 * @Author xiaoli.cheng
 * @Date 2019/11/12 16:50
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ProviderServerApplication {

	public static void main(String[] args) {SpringApplication.run(ProviderServerApplication.class, args);}

}
