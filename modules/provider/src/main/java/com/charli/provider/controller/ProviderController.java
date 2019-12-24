package com.charli.provider.controller;

import com.charli.provider.model.Params;
import com.charli.provider.service.SendFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @Author xiaoli.cheng
 * @Date 2019/11/12 16:45
 */
@RestController
public class ProviderController {

    @Autowired
    private SendFeignService sendFeignService;

    @RequestMapping(value = "/available")
    public String available() {
        return "Spring in Action";
    }

    @RequestMapping(value = "/checked-out")
    public String checkedOut() {
        return "Spring Boot in Action";
    }

    @RequestMapping(value = "/getDataBaseInfoC-out")
    public Params getDataBaseInfoC() {
        Params params = new Params();
        params.setUsername("charli");
        params.setJobNumber("007");
        params.setId(1L);

        Params databaseInfo = sendFeignService.getDatabaseInfo(params);

        return databaseInfo;
    }

    /**
     * 响应的信息
     * {
     * "id": 1,
     * "jobNumber": "007",
     * "username": "charli",
     * "password": "6666666",
     * "mobile": "13564897546",
     * "email": "334567463@qq,com"
     * }
     */

}
