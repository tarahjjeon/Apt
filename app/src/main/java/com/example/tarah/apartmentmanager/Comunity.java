package com.example.tarah.apartmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Comunity extends AppCompatActivity {

    final int requestcode=11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunity);
        Intent intent=getIntent();
    }

    public void onClickBtn1(View v){
        Intent intent=new Intent(Comunity.this,Comunity1_1.class);
        startActivityForResult(intent,requestcode);
    }

    public void onClickBtn2(View v){

    }

}
