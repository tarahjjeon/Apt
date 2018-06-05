package com.example.tarah.apartmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText loginC;
    EditText loginPW;
    Button loginBtn;
    final int requestCode=123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference hyojin= FirebaseDatabase.getInstance().getReference("mainLogin/user");
        user first=new user("apt","효진",318);
       hyojin.child(first.getId()).setValue( first);
       //hyojin.child(first.getId()).child("name").setValue("윤채");
        // hyojin.child(first.getId()).removeValue();

        init();
        addListener();
    }

    public void init() {
        loginC = (EditText) findViewById(R.id.loginC);
        loginPW = (EditText) findViewById(R.id.loginPW);
        loginBtn = (Button) findViewById(R.id.loginBtn);

        String code = loginC.getText().toString();
        String pw = loginPW.getText().toString();

        Intent intent=getIntent();
    }

    public void addListener() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivityForResult(intent,requestCode);
            }
        });
    }
}