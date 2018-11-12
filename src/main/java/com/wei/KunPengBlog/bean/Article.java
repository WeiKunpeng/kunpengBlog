package com.wei.KunPengBlog.bean;

import java.util.Date;

/**
 * Created by weikunpeng on 2018/11/5.
 */
public class Article {


    private int cid;
    private int uid;
    private int type;
    private String title;
    private String desc;
    private String content;
    private String url;
    private String tags;
    private int hits;
    private int stars;
    private Date create_time;
    private Date update_time;


    public Article() {
    }


    public Article(int cid, int uid, int type, String title, String content, String url, String tags, int hits, int stars, Date create_time, Date update_time) {
        this.cid = cid;
        this.uid = uid;
        this.type = type;
        this.title = title;
        this.content = content;
        this.url = url;
        this.tags = tags;
        this.hits = hits;
        this.stars = stars;
        this.create_time = create_time;
        this.update_time = update_time;
    }


    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }


    @Override
    public String toString() {
        return "Article{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                ", tags='" + tags + '\'' +
                ", hits=" + hits +
                ", stars=" + stars +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
