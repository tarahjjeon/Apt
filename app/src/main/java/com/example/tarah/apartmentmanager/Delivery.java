package com.example.tarah.apartmentmanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Delivery extends AppCompatActivity {
    GridView gridView;
    DeliveryAdapter adapter;
    Context context;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        databaseReference= FirebaseDatabase.getInstance().getReference("WebDB/post");

        gridView=(GridView) findViewById(R.id.gridView);
        adapter = new DeliveryAdapter(getApplicationContext(), R.layout.delivery_item);
        Intent intent=getIntent();
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

    public void showList(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            Intent intent=getIntent();
//            String userlive =intent.getIntExtra("idcode", 0);
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot data:dataSnapshot.getChildren()){

//                    if(data.child("code").getValue().equals(code)&&data.child("password").getValue().equals(pw)){
//
//                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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

