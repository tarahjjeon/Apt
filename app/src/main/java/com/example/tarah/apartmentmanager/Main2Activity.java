package com.example.tarah.apartmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main2Activity extends AppCompatActivity {
    Button addCarBtn;
    Button userSetBtn;
    EditText newPw;
    EditText carNum,car2Num,car3Num;
    String pw,carN,carN2,carN3;
    DatabaseReference people;
    user user1;
    String code;
    String[] codeDong;

    int carCount=0;
    final int requestcode=23;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();

    }
    public void init(){
        Intent intent=getIntent();
        code=intent.getStringExtra("code");
        addCarBtn=(Button)findViewById(R.id.addCarBtn);
        userSetBtn=(Button)findViewById(R.id.userSetBtn);
        newPw=(EditText)findViewById(R.id.newPw);
        carNum=(EditText)findViewById(R.id.carNum);
        car2Num=(EditText)findViewById(R.id.car2Num);
        car3Num=(EditText)findViewById(R.id.car3Num);
        car2Num.setVisibility(View.GONE);
        car3Num.setVisibility(View.GONE);
        codeDong=code.split("-");
        String refer="mainLogin/appuser";
        people=FirebaseDatabase.getInstance().getReference(refer);
        String key=codeDong[1];
       addListener();

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
               pw=newPw.getText().toString();
               carN=carNum.getText().toString();
               carN2=car2Num.getText().toString();
               carN3=car3Num.getText().toString();
               //user만 바꿀수 있다.ㅎㅎ


               people.child("user1").child("password").setValue(pw);
               people.child("user1").child("carNum").setValue(carN);
                people.child("user1").child("carNum2").setValue(carN2);
                people.child("user1").child("carNum3").setValue(carN3);
//
//                people.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        user1=dataSnapshot.child("user1").getValue(user.class);
//                        user1.setCode(pw);
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });
               Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
                intent.putExtra("code",code);
                setResult(RESULT_OK,intent);
                finish();
               startActivityForResult(intent,requestcode);
            }
        });


    }

}
