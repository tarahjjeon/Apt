package com.example.tarah.apartmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    ImageButton setBtn3;
    Button addBtn,addBtn2;
    TextView notice1,notice2,complaint,delivery,visitCar,community;
    RelativeLayout notice01,notice02;
    boolean check=true;

   final int requestcode=34;
//    final int requestcode2=35;
//    final int requestcode3=36;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
        addListener();
    }
    public void init(){
        Intent intent=getIntent();
        setBtn3=(ImageButton)findViewById(R.id.setBtn3);
       notice1=(TextView)findViewById(R.id.notice1);
       notice2=(TextView)findViewById(R.id.notice2);
       complaint=(TextView)findViewById(R.id.complaint);
       delivery=(TextView)findViewById(R.id.delivery);
       visitCar=(TextView)findViewById(R.id.visitCar);
       community=(TextView)findViewById(R.id.community);
//       notice01=(RelativeLayout)findViewById(R.id.notice01);
//       notice02=(RelativeLayout)findViewById(R.id.notice02);



    }
    public void addListener(){

        notice1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(check) {
                    notice2.setVisibility(v.GONE);

                    notice1.setHeight(200);


                    check=!check;
                }else {
                    notice2.setVisibility(v.VISIBLE);
                    notice2.setHeight(108);


                    check=!check;
                }
            }
        });
        notice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(check) {
                    notice1.setVisibility(v.GONE);
                    notice2.setHeight(205);
                    addBtn.setVisibility(View.VISIBLE);
                    addBtn2.setVisibility(View.GONE);
                    check=!check;
                }
                else {
                    notice1.setVisibility(v.VISIBLE);
                    notice2.setHeight(108);
                    addBtn.setVisibility(View.GONE);
                    addBtn2.setVisibility(View.GONE);
                    check=!check;
                }
            }
        });
        complaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(Main3Activity.this,Complaint.class);
               startActivityForResult(intent,requestcode);

            }
        });
//        addBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(Main3Activity.this,Notice.class);
//                startActivityForResult(intent,requestcode2);
//            }
//        });
//        addBtn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent2=new Intent(Main3Activity.this,Notice.class);
//                startActivityForResult(intent2,requestcode3);
//            }
//        });


    }
}
