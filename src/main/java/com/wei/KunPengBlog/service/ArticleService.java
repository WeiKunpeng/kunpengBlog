package com.wei.KunPengBlog.service;

import com.sun.javafx.collections.MappingChange;
import com.wei.KunPengBlog.bean.Article;
import com.wei.KunPengBlog.common.Result;
import com.wei.KunPengBlog.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by weikunpeng on 2018/11/5.
 */

@Service
public class ArticleService {



    @Autowired
    private ArticleDao articleDao;



    public List<Article> allArticle(){


        return articleDao.allArticle();


    }



    public Article queryByCid(int cid){



        return articleDao.queryByCid(cid);
    }


    public Article queryByTitle(String title){


        return articleDao.queryByTitle(title);
    }

    public List<Article> queryByUid(int uid){


        return articleDao.queryByUid(uid);
    }

    public List<Article> queryByType(String type){


        return articleDao.queryByType(type);
    }


}
