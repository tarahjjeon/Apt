package com.example.tarah.apartmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Complaint extends BaseActivity {
    TextView newCpt,cptS,cptS1,cptS2,cptG,cptG1;
    String code,refer;
    ArrayList<String> codeDong;
    String[] codeArray={""};
   DatabaseReference databaseReference;

    final int requestcode1 = 51;
    final int requestcode2 = 52;

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
codeArray=code.split("-");
//        StringTokenizer st=new StringTokenizer(code, "-");
//        codeDong.add(st.nextToken());
//        codeDong.add(st.nextToken());
       // refer="webDB/notice/each/"+codeDong.get(1);
       refer="webDB/notice/each/"+codeArray[1];
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
String key=codeArray[2];
               // String key=codeDong.get(2);
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
     cptS.setOnClickListener(new View.OnClickListener() {

         @Override
         public void onClick(View v) {
             Intent intent = new Intent(Complaint.this, ComplaintSend.class);
             startActivityForResult(intent, requestcode1);
             intent.putExtra("iswho2",0);
         }
     });
     cptG.setOnClickListener(new View.OnClickListener() {

         @Override
         public void onClick(View v) {
             Intent intent = new Intent(Complaint.this, ComplaintSend.class);
             startActivityForResult(intent, requestcode2);
             intent.putExtra("iswho2",1);
         }
     });

 }


}
