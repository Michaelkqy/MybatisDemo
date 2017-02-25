package com.huitu.api.samples.user.entities;

import java.io.Serializable;

/**
 * Created by zhw on 2017/2/22.
 */
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -8437125167155459493L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public UserEntity() {

    }
    public UserEntity(String id,String name, String nickname,String passwrod, int age, int sex, boolean locked) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.passwrod = passwrod;
        this.age = age;
        this.sex = sex;
        this.locked = locked;
    }

    private String id;
    private String name;
    private String nickname;
    private String passwrod;
    private int age;
    private int sex;
    private boolean locked;
}
