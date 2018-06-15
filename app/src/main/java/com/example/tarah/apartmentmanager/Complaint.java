package com.example.tarah.apartmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Complaint extends BaseActivity {
    TextView newCpt,cptS,cptS1,cptS2,cptG,cptG1;
   DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        init();

    }
    public void init(){
        Intent intent=getIntent();
        newCpt=findViewById(R.id.newCpt);
        cptS=findViewById(R.id.cptS);
       // cptS1=findViewById(R.id.cptS1);
       // cptS2=findViewById(R.id.cptS2);
        cptG=findViewById(R.id.cptG);
       //cptG1=findViewById(R.id.cptG1);
       // cptS2.setVisibility(View.GONE);
        //addListener();
        getNewCpt();
    }
   public void getNewCpt(){
        databaseReference= FirebaseDatabase.getInstance().getReference("webDB/notice/each/101");
        databaseReference.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String str=" ";
                for(DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                  str+=snapshot.getValue().toString()+"\n";
                }
                newCpt.setText(str);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
   }
 public void addListener(){


 }
}
