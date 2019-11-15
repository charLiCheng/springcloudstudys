package com.charli.circuitbreak.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class BookService {

    private final RestTemplate restTemplate;

    public BookService(RestTemplate rest){
        this.restTemplate = rest;
    }

    @HystrixCommand(fallbackMethod = "reliable")
    public String readingList(){
        URI uri = URI.create("http://localhost:8604/recommended");

        return this.restTemplate.getForObject(uri,String.class);
    }

    public String reliable(){
        return "Cloud Native Java (没有商品了!!)";
    }



}
