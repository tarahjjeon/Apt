package com.example.tarah.apartmentmanager;

public class DeliveryItem {
    String date;
    int check;

    public DeliveryItem(String date, int check){
        this.date = date;
        this.check = check;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }
}
