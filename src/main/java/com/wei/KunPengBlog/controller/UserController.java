package com.wei.KunPengBlog.controller;

import com.wei.KunPengBlog.bean.User;
import com.wei.KunPengBlog.common.Result;
import com.wei.KunPengBlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by weikunpeng on 2018/11/2.
 */


@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/loginById")
    @ResponseBody
    public Result login(@RequestParam int uid){


        return userService.loginById(uid);

    }

    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestParam String username,@RequestParam String password){


        return userService.login(username,password);

    }


    @GetMapping("/allUser")
    @ResponseBody
    public Result allUser(){


        return userService.allUser();

    }

    @PostMapping("/register")
    @ResponseBody
    public Result register(@RequestBody User user){

        if(user==null){
            return new Result(0,"注册失败，请输入参数",null);
        }


        return userService.register(user);
    }


}
