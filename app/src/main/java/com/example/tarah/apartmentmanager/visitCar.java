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

public class visitCar extends AppCompatActivity {
Button vCarSave;
String code;
EditText vCarNum,vCarDate;
DatabaseReference databaseReference;
final int requestcode=510;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit_car);
        init();
    }
    public void init(){
        Intent intent=getIntent();
        code=intent.getStringExtra("code");
        vCarSave=(Button)findViewById(R.id.vCarSave);
        vCarNum=(EditText)findViewById(R.id.vCarNum);
        vCarDate=(EditText)findViewById(R.id.vCarDate);
        databaseReference= FirebaseDatabase.getInstance().getReference("webDB/visitCar");
        addListener();

    }
    public void addListener(){
        vCarSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseReference.child("carNum").setValue(vCarNum.getText().toString());
                databaseReference.child("date").setValue(vCarDate.getText().toString());
                Intent intent=new Intent(visitCar.this,Main3Activity.class);
                intent.putExtra("code",code);
                startActivityForResult(intent,requestcode);

            }
        });
    }
}
