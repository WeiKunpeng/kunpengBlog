package com.wei.KunPengBlog.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.wei.KunPengBlog.bean.Article;
import com.wei.KunPengBlog.bean.User;
import com.wei.KunPengBlog.common.Result;
import com.wei.KunPengBlog.service.ArticleService;
import com.wei.KunPengBlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by weikunpeng on 2018/11/5.
 */


@Controller
@RequestMapping("/article")
public class ArticleController {


    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;


    /**
     * 全部文章
     *
     * @return
     */


    @GetMapping("/allArticle")
    @ResponseBody
    public Result allArticle() {


        List<Article> list = articleService.allArticle();

        return new Result(1, "所有文章", list);


    }

    /**
     * 根据文章id查询文章
     *
     * @param cid
     * @return
     */


    @GetMapping("/queryByCid/{cid}")
    public Result queryByCid(@PathVariable int cid) {

        Article article = articleService.queryByCid(cid);


        if (article == null) {
            return new Result(0, "不存在该文章", null);
        }

        return new Result(1, "查询成功", article);


    }

    /**
     * 根据userID查询文章
     *
     * @param uid
     * @return
     */


    @GetMapping("/queryByUid/{uid}")
    public String queryByUid(@PathVariable int uid, Model model) {

        List<Article> list = articleService.queryByUid(uid);


//        if(list==null){
//            return new Result(0,"该用户没有文章",null);
//        }
//
//
//        return new Result(1,"查询成功",list);


        model.addAttribute("articleList", list);


        return "articleList";


    }


    /**
     * 根据标题查询
     *
     * @param title
     * @return
     */
    @GetMapping("/queryByTitle/{title}")
    public Result queryByTitle(@PathVariable String title) {


        Article article = articleService.queryByTitle(title);


        if (article == null) {
            return new Result(0, "不存在该文章", null);
        }

        return new Result(1, "查询成功", article);

    }


    /**
     * 根据类型查询
     *
     * @param type
     * @return
     */
    @GetMapping("/queryByType/{type}")
    public Result queryByType(@PathVariable String type) {

        List<Article> list = articleService.queryByType(type);


        if (list == null) {
            return new Result(0, "该用户没有文章", null);
        }


        return new Result(1, "查询成功", list);


    }


    @PostMapping("/preview")
    public String preview(Model model, HttpServletRequest httpServletRequest) {


        Map map = httpServletRequest.getParameterMap();

//        System.out.println("1111");
//        System.out.println(map.size());
//
//        Iterator entries = map.entrySet().iterator();
//        while (entries.hasNext()) {
//            Map.Entry entry = (Map.Entry) entries.next();
//            Object key = entry.getKey();
//            String value = (String) entry.getValue();
//            System.out.println("Key = " + key + ", Value = " + value);
//        }

        Article article = new Article();

        article.setTitle(((String[]) map.get("title"))[0]);
        article.setDesc(((String[]) map.get("desc"))[0]);
        article.setContent(((String[]) map.get("content"))[0]);
        article.setCreate_time(new Date());
        article.setUpdate_time(new Date());

        System.out.println(article);


        if (article != null) {


            Cookie[] cookies = httpServletRequest.getCookies();


            if (cookies != null) {
                for (Cookie temp : cookies) {

                    if (temp.getName().equals("user")) {


                        User user = userService.queryByUsername(temp.getValue());
                        user.setPassword("");
                        model.addAttribute("user", user);
                        // model.addAttribute("article", article);
                    }
                }
            }


        }

        model.addAttribute("article", article);
        return "preview";
    }


    @GetMapping("/insert")
    public String insert(HttpServletRequest httpServletRequest, Model model) {


        Cookie[] cookies = httpServletRequest.getCookies();

        if (cookies != null) {
            for (Cookie temp : cookies) {

                if (temp.getName().equals("user") && temp.getValue() != null) {
                    User user = userService.queryByUsername(temp.getValue());


                    System.out.println(user);
                    user.setPassword("");
                    model.addAttribute("user", user);
                }
            }
        }

        return "insert";


    }
}