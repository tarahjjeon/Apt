package com.example.tarah.apartmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    Button addCarBtn;
    Button userSetBtn;
    EditText newPw;
    EditText carNum,car2Num,car3Num;

    int carCount=0;
    final int requestcode=23;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        addListener();
    }
    public void init(){
        Intent intent=getIntent();

        addCarBtn=(Button)findViewById(R.id.addCarBtn);
        userSetBtn=(Button)findViewById(R.id.userSetBtn);
        newPw=(EditText)findViewById(R.id.newPw);
        carNum=(EditText)findViewById(R.id.carNum);
        car2Num=(EditText)findViewById(R.id.car2Num);
        car3Num=(EditText)findViewById(R.id.car3Num);
        car2Num.setVisibility(View.GONE);
        car3Num.setVisibility(View.GONE);
    }

    public void addListener(){

        addCarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(carCount==0)
                {
                car2Num.setVisibility(v.VISIBLE);
            carCount++;

                }
                else
                {car3Num.setVisibility(v.VISIBLE); }
            }
        });
        userSetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
               startActivityForResult(intent,requestcode);
            }
        });
    }

}
