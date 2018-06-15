package com.example.tarah.apartmentmanager;

public class user {
    String id;
    String name;
    String code;
    String carNum;

    String password;


    public user(String id, String name, String code, String carNum, Delivery delivery, String password) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.carNum = carNum;

        this.password = password;
    }

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}






