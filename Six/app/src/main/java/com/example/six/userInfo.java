package com.example.six;

public class userInfo {
    private int id;
    private String username;
    private String password;
    private String sex;
    private int age;
    public userInfo(int id, String name, String psd, String sex, int age){
        this.id = id;
        this.username = name;
        this.password = psd;
        this.sex = sex;
        this.age = age;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "userInfo{" + "id = " + id + ", username = '" + username + '\'' + ", password = '"
                + password + '\'' + ", sex = '" + sex + '\'' + ", age = " + age + '}';
    }
}
