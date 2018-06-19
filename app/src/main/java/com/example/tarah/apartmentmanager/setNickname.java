package com.example.tarah.apartmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class setNickname extends AppCompatActivity {

    String code;
    String nick;
    String[] codeDong;
    DatabaseReference databaseReference;
    EditText nickName;
    Button nickNameBtn;
   final int requestCode=777;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_nickname);
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