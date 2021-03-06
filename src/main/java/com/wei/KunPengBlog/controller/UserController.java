package com.wei.KunPengBlog.controller;

import com.wei.KunPengBlog.bean.Article;
import com.wei.KunPengBlog.bean.User;
import com.wei.KunPengBlog.common.Result;
import com.wei.KunPengBlog.service.ArticleService;
import com.wei.KunPengBlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.HttpCookie;
import java.util.List;

/**
 * Created by weikunpeng on 2018/11/2.
 */


@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;


    @PostMapping("/loginById")
    @ResponseBody
    public Result login(@RequestParam int uid) {


        return userService.loginById(uid);

    }

    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestParam String username, @RequestParam String password, HttpServletResponse httpServletResponse) {


        Result result = userService.login(username, password);

        if (result != null && result.getCode() == 1) {


            Cookie cookie = new Cookie("user", username);
            httpServletResponse.addCookie(cookie);
            return new Result(200, "登陆成功", "/user/userhome");


        }

        return result;

    }


    @GetMapping("/userhome")
    public String userhome(HttpServletRequest httpServletRequest, Model model) {


        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (Cookie temp : cookies) {
                System.out.printf(temp.getName() + temp.getValue());

                if (temp.getName().equals("user") && temp.getValue() != null) {


                    User user = userService.queryByUsername(temp.getValue());
                    user.setPassword("");


                    List list=articleService.queryByUid(user.getUid());

                    model.addAttribute("articleList",list);
                    model.addAttribute("user",user);
                    return "articleList";
                }
            }
        }


        return "index";


    }


    @GetMapping("/allUser")
    @ResponseBody
    public Result allUser() {


        return userService.allUser();

    }

    @PostMapping("/register")
    @ResponseBody
    public Result register(@RequestBody User user) {

        if (user == null) {
            return new Result(0, "注册失败，请输入参数", null);
        }


        return userService.register(user);
    }


    @GetMapping("/index")
    public String welcome(HttpServletRequest httpServletRequest,Model model) {


        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (Cookie temp : cookies) {
                if (temp.getName().equals("user")) {

//                    model.addAttribute("user",temp.getValue());


                    User user = userService.queryByUsername(temp.getValue());
                    user.setPassword("");


                    List list=articleService.queryByUid(user.getUid());

                    model.addAttribute("articleList",list);
                    model.addAttribute("user",user);
                    //return "/articleList";
//                    model.addAttribute("")
                    return "articleList";
                }
            }
        }

        return "index";


    }


    /**
     * 退出登陆
     */

    @GetMapping("/unlogin")
    public String unlogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {


        Cookie[] cookies = httpServletRequest.getCookies();

        if (cookies != null) {
            for (Cookie temp : cookies) {
                temp.setMaxAge(0);
                httpServletResponse.addCookie(temp);
            }
        }

        return "index";


    }


    @GetMapping("/add")
    public String add(){

        return "addOne";
    }


}
