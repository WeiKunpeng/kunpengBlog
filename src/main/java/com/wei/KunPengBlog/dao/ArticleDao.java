package com.wei.KunPengBlog.dao;

import com.wei.KunPengBlog.bean.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by weikunpeng on 2018/11/5.
 */


@Mapper
public interface ArticleDao {



    List<Article> allArticle();


    List<Article> queryByUid(int uid);

    Article queryByCid(int cid);

    Article queryByTitle(String title);

    List<Article> queryByType(String type);


}
