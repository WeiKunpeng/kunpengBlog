package com.wei.KunPengBlog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

/**
 * Created by weikunpeng on 2018/11/21.
 */


@RestController
@RequestMapping("/test")
public class TestController1 {





    @GetMapping("/test1")
    public String test1(String id){


        System.out.println(id);



        return id;


    }

    @GetMapping("/test2")
    public String test2(String id){


        System.out.println(id);



        return id;


    }



}
