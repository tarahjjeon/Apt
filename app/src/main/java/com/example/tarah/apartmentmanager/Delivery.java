package com.example.tarah.apartmentmanager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class Delivery extends AppCompatActivity {
    GridView gridView;
    DeliveryAdapter adapter;
    Context context;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        gridView=(GridView) findViewById(R.id.gridView);
        adapter = new DeliveryAdapter(getApplicationContext(), R.layout.delivery_item);
//        adapter = new DeliveryAdapter();

        adapter.addItems(new DeliveryItem("2018-06-03", 1));
        adapter.addItems(new DeliveryItem("2018-06-05", 1));
        adapter.addItems(new DeliveryItem("2018-06-07", 0));
        adapter.addItems(new DeliveryItem("2018-06-08", 0));

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DeliveryItem item = (DeliveryItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택: "+item.getDate(), Toast.LENGTH_LONG).show();
            }
        });
    }
}

class DeliveryAdapter extends ArrayAdapter {
    Context context;
    ArrayList<DeliveryItem> items = new ArrayList<DeliveryItem>();

    public DeliveryAdapter(@NonNull Context context, int resource) {
        super(context, resource);

        this.context = context;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    public void addItems(DeliveryItem item){
        items.add(item);
    }

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

        DeliveryItemView view = new DeliveryItemView(context);
        DeliveryItem item = items.get(position);
        view.setTextView_date(item.getDate());
        view.setTextView_check(item.getCheck());

        return view;
    }

}

