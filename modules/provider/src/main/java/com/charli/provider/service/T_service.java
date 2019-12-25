package com.charli.provider.service;

import com.charli.provider.model.T_entity;
import com.charli.provider.mybatistest.T_dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description : 
 * @Author xiaoli.cheng
 * @Date 2019/12/24 17:13
 */
@Service
public class T_service {

    @Autowired
    private T_dao t_dao;

    public void query(){
        List<T_entity> list = t_dao.query();

        for (T_entity t_entity:list){
            System.out.println(t_entity.getName());
        }

    }

    public void update(){
        t_dao.update();
    }

    public void setT_dao(T_dao t_dao){
        this.t_dao = t_dao;
    }


}
