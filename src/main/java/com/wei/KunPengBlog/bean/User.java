package com.wei.KunPengBlog.bean;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by weikunpeng on 2018/11/2.
 */


public class User {

    private int uid;
    private String username;


    //@JsonIgnore
    private String password;

    private String email;
    private Date create_time;


    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String email, Date createTime) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.create_time = createTime;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + create_time +
                '}';
    }


    @Override
    public boolean equals(Object obj) {

        User user = (User) obj;


        if (user != null) {

            if (user.getUsername().equals(this.getUsername()) && user.getPassword().equals(this.getPassword())) {
                return true;
            }
        }

        return false;
    }
}
