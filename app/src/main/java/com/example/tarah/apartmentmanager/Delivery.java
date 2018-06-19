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
    String code;
    String[] codeDong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        databaseReference= FirebaseDatabase.getInstance().getReference("WebDB/post");

        gridView=(GridView) findViewById(R.id.gridView);
        adapter = new DeliveryAdapter(getApplicationContext(), R.layout.delivery_item);

        Intent intent=getIntent();
        code=intent.getStringExtra("code");
        codeDong=code.split("-");
        String refer="webDB/notice/Building/"+codeDong[0];//동이고 codeDong[1]은 호야

//        adapter.addItems(new DeliveryItem("2018-06-03", 1));
//        adapter.addItems(new DeliveryItem("2018-06-05", 1));
//        adapter.addItems(new DeliveryItem("2018-06-07", 0));
//        adapter.addItems(new DeliveryItem("2018-06-08", 0));

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

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot data:dataSnapshot.getChildren()){
                    //동, 호가 같은면 출력
                    if(data.child("buildingNum").getValue().equals(codeDong[1])&&data.child("roomNum").getValue().equals(codeDong[2])){
                        String date = data.child("date").getValue().toString();
                        int check = Integer.parseInt(data.child("check").getValue().toString());
                        adapter.addItems(new DeliveryItem(date,check));
                    }
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

