package com.charli.consumer.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @Description : 
 * @Author xiaoli.cheng
 * @Date 2019/12/24 15:02
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Params {

    private Long id;

    /**
     * 工号
     */
    private String jobNumber;

    /**
     * 登录用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;


}
