package com.example.tarah.apartmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class CommunityMypage extends AppCompatActivity {
 TextView showNick;

 String code,v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_mypage);
        init();
    }
    public void init(){
       showNick=(TextView) findViewById(R.id.showNick);
        Intent intent = getIntent();


       showNick.setText("aptZoa");

    }
   }



