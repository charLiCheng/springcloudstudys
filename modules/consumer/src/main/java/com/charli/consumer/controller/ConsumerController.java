package com.charli.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @Author xiaoli.cheng
 * @Date 2019/11/12 17:07
 */
@RestController
public class ConsumerController {

    @RequestMapping(value = "/checked-out")
    public String checkedOut() {
        return "Spring Boot in Action";
    }
}
