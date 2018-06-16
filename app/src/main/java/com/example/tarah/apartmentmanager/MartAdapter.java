package com.example.tarah.apartmentmanager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MartAdapter extends ArrayAdapter{

    Context context;
    ArrayList<MartItem> items = new ArrayList<MartItem>();

    public MartAdapter(@NonNull Context context, int resource) {
        super(context, resource);

        this.context = context;
    }


    @Override
    public int getCount() {
        return items.size();
    }

//    public void addItems(DeliveryItem item){
//        items.add(item);
//    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MartItemView view = new MartItemView(context);
        MartItem item = items.get(position);
//        view.setTextView_date(item.getDate());
//        view.setTextView_check(item.getCheck());

        return view;
    }

}