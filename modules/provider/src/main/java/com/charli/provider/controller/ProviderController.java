package com.charli.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description : 
 * @Author xiaoli.cheng
 * @Date 2019/11/12 16:45
 */
@RestController
public class ProviderController {

    @RequestMapping(value = "/available")
    public String available() {
        return "Spring in Action";
    }

    @RequestMapping(value = "/checked-out")
    public String checkedOut() {
        return "Spring Boot in Action";
    }

}
