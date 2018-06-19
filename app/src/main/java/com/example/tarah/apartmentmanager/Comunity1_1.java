package com.example.tarah.apartmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

public class Comunity1_1 extends AppCompatActivity {
    Button write, mypage;
    final int requestcode11 = 340;
    final int requestcode12 = 350;
    ListView list;
    ArrayAdapter arrayAdapter;//list 와 arrlist 연결
    static final String[] LIST_MENU = {"디지털/가전", "의류/잡화", "유아용품","가구/인테리어",
            "도서","반려동물 용품","식품","기타" } ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunity1_1);
        init();
        addListener();
    }

    public void init(){
        write =(Button) findViewById(R.id.write_btn);
        mypage = (Button)findViewById(R.id.mypage_btn);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,LIST_MENU);
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
//        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String strText = (String) parent.getItemAtPosition(position);
//            }
//        });
    }

    public void addListener () {

        write.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Comunity1_1.this, Community_write.class);
                startActivityForResult(intent, requestcode11);
            }
        });

        mypage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Comunity1_1.this, CommunityMypage.class);
                startActivityForResult(intent, requestcode12);
            }
        });
    }





}
