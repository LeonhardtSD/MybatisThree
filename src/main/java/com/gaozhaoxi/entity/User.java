package com.gaozhaoxi.entity;

/**
 * @author Leon
 */

public class User {
    private Long id;
    private String userName;
    private String password;
    private String address;

    public User(){

    }
    public User(Long id, String userName, String password, String address){
        this.id=id;
        this.userName = userName;
        this.password=password;
        this.address=address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        String out="id:"+id+", username:"+ userName +", password:"+password+", address:"+address;
        return out;
    }
}
