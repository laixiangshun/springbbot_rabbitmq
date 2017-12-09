package com.rabbitmq.user;

import java.io.Serializable;

/**
 * Created by lailai on 2017/12/9.
 */
public class User implements Serializable{
    private String name;
    private String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
