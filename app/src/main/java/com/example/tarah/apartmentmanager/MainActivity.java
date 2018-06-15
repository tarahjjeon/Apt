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

public class MainActivity extends AppCompatActivity {

    EditText loginC;
    EditText loginPW;
    Button loginBtn;
    final int requestCode=123;
    String code,pw;
    DatabaseReference databaseReference;
    String userSet;
    DataSnapshot dataSnapshotSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       databaseReference= FirebaseDatabase.getInstance().getReference("mainLogin/appuser");

       // user first=new user("user","서영","318","7685","318");
      // databaseReference.child(first.getId()).setValue( first);

//        DatabaseReference hyojin= FirebaseDatabase.getInstance().getReference("mainLogin/user");
//        user first=new user("apt","효진",318);
//       hyojin.child(first.getId()).setValue( first);

       //hyojin.child(first.getId()).child("name").setValue("윤채");
        // hyojin.child(first.getId()).removeValue();

        init();

    }

    public void init() {
        loginC = (EditText) findViewById(R.id.loginC);
        loginPW = (EditText) findViewById(R.id.loginPW);
        loginBtn = (Button) findViewById(R.id.loginBtn);



        Intent intent=getIntent();
        addListener();
    }

  public void addListener() {

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                code = loginC.getText().toString();
                pw = loginPW.getText().toString();
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        int check=0;
                        for(DataSnapshot data:dataSnapshot.getChildren()){

                            if(data.child("code").getValue().equals(code)&&data.child("password").getValue().equals(pw)){
                                check++;                                                           }
                            }
                           if(check>0){

                                Toast.makeText(getApplicationContext(),"환영합니다",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                               intent.putExtra("code",code);
                               setResult(RESULT_OK,intent);
                               finish();
                                startActivityForResult(intent, requestCode);
                            } else {
                               Toast.makeText(getApplicationContext(), "로그인 오류", Toast.LENGTH_SHORT).show();
loginPW.setText("");loginC.setText("");
                           }

                        }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });




            }
        });
    }
}