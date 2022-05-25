package com.github.halibobor.bean;

import java.io.Serializable;

public class User  implements Serializable {
    private static final long serialVersionUID = -8088742348807697485L;

    private String userName;

    public User() {
        System.out.println("call construct method");
    }

    public String getUserName() {
        System.out.println("call get method getUserName");
        return userName;
    }

    public void setUserName(String userName) {
        System.out.println("call set  method setUserName");
        this.userName = userName;
    }
}