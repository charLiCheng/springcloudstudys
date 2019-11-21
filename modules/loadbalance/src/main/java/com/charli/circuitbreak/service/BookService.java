package com.charli.circuitbreak.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class BookService {

    private final RestTemplate restTemplate;

    public BookService(RestTemplate rest){
        this.restTemplate = rest;
    }

    public String reliable(){
        return "Cloud Native Java (没有商品了!!)";
    }

}
