package com.example.tarah.apartmentmanager;

public class Delivery {


        boolean check;
        String date;
        String r_user;

    public Delivery(boolean check, String date, String r_user) {
        this.check = check;
        this.date = date;
        this.r_user = r_user;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getR_user() {
        return r_user;
    }

    public void setR_user(String r_user) {
        this.r_user = r_user;
    }
}
