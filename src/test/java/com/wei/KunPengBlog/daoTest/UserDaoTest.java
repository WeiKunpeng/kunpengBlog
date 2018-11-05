package com.wei.KunPengBlog.daoTest;

import com.wei.KunPengBlog.KunPengBlogApplicationTests;
import com.wei.KunPengBlog.bean.User;
import com.wei.KunPengBlog.dao.UseDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by weikunpeng on 2018/11/5.
 */
public class UserDaoTest extends KunPengBlogApplicationTests {


    @Autowired
    UseDao useDao;



    @Test
    public void userDaoTest(){


        User user=new User();

        user.setUsername("guo");
        user.setPassword("123");
        user.setEmail("guohongbin@guazi.com");


        useDao.addOne(user);


    }
}
