package com.wei.KunPengBlog.dao;

import com.wei.KunPengBlog.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by weikunpeng on 2018/11/2.
 */

@Mapper
public interface UseDao {



//    @Select("SELECT * FROM happiness WHERE uid = #{uid}")
    User queryById(int uid);


    User queryByUsername(String username);


    List<User> allUser();


    void addOne(User user);


//    User queryByUsernam(String username);
//
//    List<User> UserList();
//
//
//
//    User register(User user);

}
