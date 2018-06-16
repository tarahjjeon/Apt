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

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Complaint extends BaseActivity {
    TextView newCpt,cptS,cptS1,cptS2,cptG,cptG1;
    String code,refer;
    ArrayList<String> codeDong;
   DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
       init();

    }
    public void init(){
        Intent intent=getIntent();
        code=intent.getStringExtra("code");

        codeDong=new ArrayList<>();

        StringTokenizer st=new StringTokenizer(code, "-");
        codeDong.add(st.nextToken());
        codeDong.add(st.nextToken());

       refer="webDB/notice/each/"+codeDong.get(0);
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
        databaseReference= FirebaseDatabase.getInstance().getReference(refer);
        databaseReference.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String str=" ";
                String key=codeDong.get(1);
                for(DataSnapshot snapshot:dataSnapshot.getChildren())
                {

if(snapshot.getKey().toString().equals(key)) {
    str += snapshot.getValue().toString() + "\n";
}
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
