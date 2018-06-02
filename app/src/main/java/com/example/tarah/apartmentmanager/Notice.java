package com.example.tarah.apartmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Notice extends AppCompatActivity {
     Button ntcHome;
     TextView ntcAll,ntcDong;
     ListView noticeList,noticeList2;
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
        checkNum=intent.getIntExtra("test",0);
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
