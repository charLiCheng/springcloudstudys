package com.charli.provider.service;

import com.charli.provider.config.FeignConfig;
import com.charli.provider.model.Params;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description :
 * @Author xiaoli.cheng
 * @Date 2019/12/24 15:06
 */
@FeignClient(name = "consumer", configuration = FeignConfig.class)
public interface SendFeignService {

    /**
     * 获取基本信息
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/api/v1/getDatabaseInfo", method = RequestMethod.POST)
    Params getDatabaseInfo(@RequestBody Params params);

}
