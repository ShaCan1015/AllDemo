package com.example.shacan.sqlite_page.bean;

import android.widget.TextView;

/**
 * Created by Administrator on 2016/8/23 0023.
 */
public class User {

    private int id;
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
