package com.wei.KunPengBlog.service;

import com.wei.KunPengBlog.bean.User;
import com.wei.KunPengBlog.common.Result;
import com.wei.KunPengBlog.dao.UseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by weikunpeng on 2018/11/2.
 */

@Service
public class UserService {


    @Autowired
    private UseDao useDao;


    public Result login(String username, String password) {


        User user = useDao.queryByUsername(username);

        System.out.printf(user.toString());

        if (user == null) {
            return new Result(0, "不存在用户名", null);
        }

        if (!user.getPassword().equals(password)) {
            return new Result(0, "密码错误", null);
        }

        return new Result(1, "登陆成功", user);


    }

    public Result loginById(int uid) {

        User user = useDao.queryById(uid);

        if (user == null) {
            return new Result(0, "不存在用户", null);
        }


        return new Result(1, "登陆成功", user);

    }


    public Result allUser() {

        return new Result<List<User>>(1, "所有用户", useDao.allUser());


    }


    public Result register(User user) {


        User user1 = useDao.queryByUsername(user.getUsername());

        System.out.printf(user.toString());


        if (user1 != null) {
            return new Result(0, "该用户已经存在", null);
        }

        try {

            System.out.printf(user.toString());
            useDao.addOne(user);
        } catch (Exception e) {
            System.out.println(e + e.getMessage());
            return new Result(0, "注册失败", null);
        }




        return new Result(1, "注册成功", useDao.queryByUsername(user.getUsername()));
    }


}
