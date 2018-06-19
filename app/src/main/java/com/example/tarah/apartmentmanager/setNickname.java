package com.example.tarah.apartmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class setNickname extends AppCompatActivity {
    EditText nickname;
    Button nickNameBtn;
    DatabaseReference databaseReference;
    final int requestCode=500;
    String code;
    String nick;
    String[]codeDong;

    EditText nickName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_nickname);

        databaseReference= FirebaseDatabase.getInstance().getReference("mainLogin/appuser");

        init();
    }

    public void init() {

        nickName = (EditText) findViewById(R.id.nickName);
        nickNameBtn = (Button) findViewById(R.id.nickNameBtn);
        Intent intent = getIntent();
        code = intent.getStringExtra("code");
        codeDong = code.split("-");
        databaseReference = FirebaseDatabase.getInstance().getReference("mainLogin/appuser");
        addListener();

    }

    public void addListener() {

String nickname=nickName.getText().toString();

            //디비에 등록하기,페이지 이동

            nickNameBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nick = nickName.getText().toString();
                    Toast.makeText(getApplicationContext(),nick+"님 환영합니다",Toast.LENGTH_SHORT).show();
                    databaseReference.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot data : dataSnapshot.getChildren()) {
                                if (data.child("code").getValue().toString().equals(code)) {
                                    databaseReference.child(data.getKey()).child("nickName").setValue(nick);
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    Intent intent = new Intent(setNickname.this, Comunity.class);
                    startActivity(intent);
                    intent.putExtra("code", code);
                    intent.putExtra("nick",nick);
                }

            });
        }
    }