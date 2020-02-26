package org.lanqiao.mvc.domain;

public class User {
    private String username;
    private int age;
    private String sex;
    private String addr;
    private int id;

    public User(String username, int age, String sex, String addr, int id) {
        this.username = username;
        this.age = age;
        this.sex = sex;
        this.addr = addr;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(String username, int age, String sex, String addr) {
        this.username = username;
        this.age = age;
        this.sex = sex;
        this.addr = addr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
