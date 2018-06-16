package com.example.tarah.apartmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Community_write extends AppCompatActivity {
    String nickname;    //현재 로그인된 유저의 별명 가져와야함
    EditText title;
    EditText price;
    CheckBox checkBox;
    EditText content;
    Button writebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_write);
        init();
    }

    public void init() {
        title = (EditText) findViewById(R.id.write_title);
        price = (EditText) findViewById(R.id.write_price);
        checkBox = (CheckBox) findViewById(R.id.write_isfree);
        content = (EditText) findViewById(R.id.write_content);
        writebtn = (Button) findViewById(R.id.write_btn);


        Intent intent=getIntent();
        addListener();
    }

    public void addListener() {
        writebtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //MartList에 키 추가
            }
        });
    }



}
