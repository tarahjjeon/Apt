package com.example.tarah.apartmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Notice extends AppCompatActivity {
     Button ntcHome;
     TextView ntcAll,ntcDong;
     ListView noticeList,noticeList2;
     ArrayAdapter arrayAdapterAll,arrayAdapterDong;
     ArrayList<String> arrayListAll, arrayListDong;
    DatabaseReference noticeDataAll;
    DatabaseReference noticeDataDong;

    ArrayList<ArrayList<String>> mChildList=null;
    ArrayList<String> mChildListContent=null;
     int checkNum;
     final int requestcode=51;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        init();
        addListener();
    }
    public void init(){

        Intent intent=getIntent();
        ntcHome=findViewById(R.id.ntcHome);
        ntcAll=findViewById(R.id.ntcAll);
        ntcDong=findViewById(R.id.ntcDong);
        noticeList=findViewById(R.id.noticeList);
        noticeList2=findViewById(R.id.noticeList2);
        noticeList2.setVisibility(View.GONE);
        arrayListAll=new ArrayList<>();
        arrayListDong=new ArrayList<>();
        arrayAdapterAll=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayListAll);
        arrayAdapterDong=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayListDong);
        noticeList.setAdapter(arrayAdapterAll);
        noticeList2.setAdapter(arrayAdapterDong);
        checkNum=intent.getIntExtra("test",0);
//        arrayAdapterAll.add("NOTICE FOR ALL");
//        arrayAdapterDong.add("NOTICE FOR DONG");
        arrayAdapterDong.notifyDataSetChanged();
        arrayAdapterAll.notifyDataSetChanged();






      noticeDataAll= FirebaseDatabase.getInstance().getReference("webDB/notice/All");
      noticeDataDong=FirebaseDatabase.getInstance().getReference("webDB/notice/Building/101");
        if(checkNum==70){
            noticeList2.setVisibility(View.GONE);
            noticeList.setVisibility(View.VISIBLE);

        }
        else if(checkNum==72){
            noticeList.setVisibility(View.GONE);
            noticeList2.setVisibility(View.VISIBLE);

        }
        else
            Toast.makeText(getApplicationContext(),Integer.toString(checkNum),Toast.LENGTH_SHORT).show();


        readFile();
    }
    public void readFile(){
        noticeDataAll.addValueEventListener(new ValueEventListener() {
            String ntcA="";
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot data:dataSnapshot.getChildren()){
                    ntcA=data.child("content").getValue().toString();
                    arrayAdapterAll.add(ntcA);
                }
                noticeList.setAdapter(arrayAdapterAll);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        noticeDataDong.addValueEventListener(new ValueEventListener() {
            String ntcD="";
            int i=1;
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {


                   ntcD= data.child("content").getValue().toString() + "\n";
                  arrayAdapterDong.add(ntcD);
                }    noticeList2.setAdapter(arrayAdapterDong);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public  void addListener(){
        ntcHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Notice.this,Main3Activity.class);
                startActivityForResult(intent,requestcode);
            }
        });

        ntcAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noticeList2.setVisibility(View.GONE);
                noticeList.setVisibility(View.VISIBLE);
            }
        });
        ntcDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noticeList.setVisibility(View.GONE);
                noticeList2.setVisibility(View.VISIBLE);

            }
        });



    }
}
