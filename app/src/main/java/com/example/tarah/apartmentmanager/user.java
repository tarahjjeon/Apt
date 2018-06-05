package com.example.tarah.apartmentmanager;

public class user {
    String id;
    String name;
    int code;
    public user(String id,String name,int code){
        this.id=id;
        this.name=name;
        this.code=code;
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
