package com.example.tarah.apartmentmanager;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
import android.support.annotation.NonNull;
=======
>>>>>>> a51f9bd8365b06109b3a8269363efaba71abdfdf
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
<<<<<<< HEAD

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
=======
import android.widget.Toast;
>>>>>>> a51f9bd8365b06109b3a8269363efaba71abdfdf

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

<<<<<<< HEAD
    String code;
    String nick;
    String[] codeDong;
    DatabaseReference databaseReference;
    EditText nickName;
    Button nickNameBtn;
   final int requestCode=777;
=======
public class setNickname extends AppCompatActivity {
    EditText nickname;
    Button regibtn;
    DatabaseReference databaseReference;
    final int requestCode=500;
>>>>>>> a51f9bd8365b06109b3a8269363efaba71abdfdf
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_nickname);
<<<<<<< HEAD
=======

        databaseReference= FirebaseDatabase.getInstance().getReference("mainLogin/appuser");
>>>>>>> a51f9bd8365b06109b3a8269363efaba71abdfdf
        init();
    }

    public void init() {
<<<<<<< HEAD
        nickName = (EditText) findViewById(R.id.nickName);
        nickNameBtn = (Button) findViewById(R.id.nickNameBtn);
        Intent intent = getIntent();
        code = intent.getStringExtra("code");
        codeDong = code.split("-");
        databaseReference = FirebaseDatabase.getInstance().getReference("mainLogin/appuser");
        addListener();
=======
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
>>>>>>> a51f9bd8365b06109b3a8269363efaba71abdfdf
    }

        public void addListener () {
            nickNameBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nick = nickName.getText().toString();
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
                }

            });
        }
    }