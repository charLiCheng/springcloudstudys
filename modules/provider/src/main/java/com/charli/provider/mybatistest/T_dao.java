package com.charli.provider.mybatistest;

import com.charli.provider.model.T_entity;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Description :
 * @Author xiaoli.cheng
 * @Date 2019/12/24 16:58
 */

@CacheNamespace
public interface T_dao {

    @Select("select * from t")
    public List<T_entity> query();

    @Update("update t set name='lili' where id=3")
    public int update();

}
