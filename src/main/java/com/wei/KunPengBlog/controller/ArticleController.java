package com.wei.KunPengBlog.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.wei.KunPengBlog.bean.Article;
import com.wei.KunPengBlog.common.Result;
import com.wei.KunPengBlog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by weikunpeng on 2018/11/5.
 */


@RestController
@RequestMapping("/article")
public class ArticleController {



    @Autowired
    private ArticleService articleService;


    /**
     * 全部文章
     * @return
     */


    @GetMapping("/allArticle")
    public Result allArticle(){


        List<Article> list=articleService.allArticle();

        return new Result(1,"所有文章",list);



    }

    /**
     * 根据文章id查询文章
     * @param cid
     * @return
     */


    @GetMapping("/queryByCid/{cid}")
    public Result queryByCid(@PathVariable int cid){

        Article article=articleService.queryByCid(cid);


        if(article==null){
            return new Result(0,"不存在该文章",null);
        }

        return new Result(1,"查询成功",article);



    }

    /**
     * 根据userID查询文章
     * @param uid
     * @return
     */



    @GetMapping("/queryByUid/{uid}")
    public Result queryByUid(@PathVariable int uid){

        List<Article> list= articleService.queryByUid(uid);


        if(list==null){
            return new Result(0,"该用户没有文章",null);
        }


        return new Result(1,"查询成功",list);


    }


    /**
     * 根据标题查询
     * @param title
     * @return
     */
    @GetMapping("/queryByTitle/{title}")
    public Result queryByTitle(@PathVariable String title){


        Article article=articleService.queryByTitle(title);


        if(article==null){
            return new Result(0,"不存在该文章",null);
        }

        return new Result(1,"查询成功",article);

    }


    /**
     * 根据类型查询
     * @param type
     * @return
     */
    @GetMapping("/queryByType/{type}")
    public Result queryByType(@PathVariable String type){

        List<Article> list= articleService.queryByType(type);


        if(list==null){
            return new Result(0,"该用户没有文章",null);
        }


        return new Result(1,"查询成功",list);


    }









}
