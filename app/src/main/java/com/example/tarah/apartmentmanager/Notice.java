package com.example.tarah.apartmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Notice extends AppCompatActivity {
     Button ntcHome;
     TextView ntcAll,ntcDong;
     ListView noticeList,noticeList2;
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
    }
    public  void addListener(){
        ntcHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Notice.this,MainActivity.class);
                startActivityForResult(intent,requestcode);
            }
        });
    }
}
