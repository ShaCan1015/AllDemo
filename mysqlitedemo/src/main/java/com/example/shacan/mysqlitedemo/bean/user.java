package com.example.shacan.mysqlitedemo.bean;

/**
 * Created by Administrator on 2016/8/18 0018.
 */
public class User {
    private int id;
    private String name;

    public User() {
    }
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
