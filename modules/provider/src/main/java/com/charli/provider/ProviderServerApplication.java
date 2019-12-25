package com.charli.provider;

import com.charli.provider.model.T_entity;
import com.charli.provider.mybatistest.T_dao;
import com.charli.provider.service.T_service;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

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
