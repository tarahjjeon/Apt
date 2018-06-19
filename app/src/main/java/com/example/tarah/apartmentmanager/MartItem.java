package com.example.tarah.apartmentmanager;

public class MartItem {
    String title;
    String subtitle;
    String price;

    public MartItem(String title, String subtitle, String price){
        this.title = title;
        this.subtitle = subtitle;
        this.price = price;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String date) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String subtitle) {
        this.price = price;
    }

}
