package com.itheima.entity;

import java.io.Serializable;

/**
 * (UserEntity)实体类
 *
 * @author makejava
 * @since 2020-03-13 14:46:14
 */
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 957228765200783348L;
    
    private Integer id;
    
    private String name;
    
    private String password;
    
    private String perms;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

}