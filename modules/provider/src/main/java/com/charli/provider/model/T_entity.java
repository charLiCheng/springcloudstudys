package com.charli.provider.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Description :
 * @Author xiaoli.cheng
 * @Date 2019/12/24 17:01
 */
@Setter
@Getter
@ToString
public class T_entity {

    private int id;

    private String name;

    private String age;

    private String phone;

    private String mail;

    private Date addTime;
}
