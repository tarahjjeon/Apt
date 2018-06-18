package com.example.tarah.apartmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class setNickname extends AppCompatActivity {
    EditText nickname;
    Button regibtn;
    DatabaseReference databaseReference;
    final int requestCode=500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_nickname);

        databaseReference= FirebaseDatabase.getInstance().getReference("mainLogin/appuser");
        init();
    }

    public void init() {
        nickname = (EditText) findViewById(R.id.nickname);
        regibtn = (Button) findViewById(R.id.regi);
        Intent intent=getIntent();
        addListener();
    }

    public void addListener() {
        regibtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),nickname+"님 환영합니다",Toast.LENGTH_SHORT).show();
                //디비에 등록하기,페이지 이동
                Intent intent = new Intent(setNickname.this, Comunity.class);
                intent.putExtra("nickname",nickname.getText().toString());  //별명 등록
                startActivityForResult(intent, requestCode);
            }
        });
    }
}
