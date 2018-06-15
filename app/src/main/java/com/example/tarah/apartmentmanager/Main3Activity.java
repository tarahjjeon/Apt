package com.example.tarah.apartmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main3Activity extends BaseActivity{
    ImageButton setBtn3,complaint, delivery, visitCar,  community;

    TextView notice1, notice2;
    DatabaseReference databaseReference1, databaseReference2;


    final int requestcode11 = 34;
    final int requestcode12 = 35;
    final int requestcode13 = 36;
    final int requestcode14 = 37;
    final int requestcode15 = 38;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();

    }

    public void init() {
        Intent intent = getIntent();
        setBtn3 = (ImageButton) findViewById(R.id.setBtn3);
        notice1 = (TextView) findViewById(R.id.notice1);
        notice2 = (TextView) findViewById(R.id.notice2);
        complaint = (ImageButton) findViewById(R.id.complaint);
        delivery = (ImageButton) findViewById(R.id.delivery);
        visitCar = (ImageButton) findViewById(R.id.visitCar);
        community = (ImageButton) findViewById(R.id.community);
//       notice01=(RelativeLayout)findViewById(R.id.notice01);
//       notice02=(RelativeLayout)findViewById(R.id.notice02);
        show();
        addListener();
    }

    public void show() {
        databaseReference1 = FirebaseDatabase.getInstance().getReference("webDB/notice/All");
        databaseReference2 = FirebaseDatabase.getInstance().getReference("webDB/notice/Building/101");
        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String notice = "<아파트 공지>"+"\n";
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    notice += data.child("content").getValue().toString() + "\n";
                }
                notice1.setText(notice);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        databaseReference2.addValueEventListener(new ValueEventListener() {
            String notice = "<우리 동 공지>"+"\n";

            int i=1;
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {



                         notice += data.child("title").getValue().toString() + "\n";
                         i++;

                }     notice2.setText(notice);
                }




            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
    public void addListener () {

        notice1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Main3Activity.this, Notice.class);
                intent.putExtra("test", 70);
                startActivityForResult(intent, requestcode12);

            }
        });
        notice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Main3Activity.this, Notice.class);
                intent.putExtra("test", 72);
                startActivityForResult(intent, requestcode13);

            }
        });
        complaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, Complaint.class);
                startActivityForResult(intent, requestcode11);

            }
        });
        community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
                Intent intent = new Intent(Main3Activity.this, Comunity.class);
                startActivityForResult(intent, requestcode14);
            }
        });
//delivery.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        Intent intent=new Intent(Main3Activity.this,Delivery.class);
//        startActivityForResult(intent,requestcode15);
        // }
//});
=======
                Intent intent=new Intent(Main3Activity.this,Comunity.class);
                startActivityForResult(intent,requestcode14);
            }
        });
        delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(Main3Activity.this, "택배 클릭", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Main3Activity.this,Delivery.class);
                startActivityForResult(intent,requestcode15);
            }
        });
>>>>>>> 42d51caedb55444e789f8ddf5f4141cd496d0c72
//visitCar.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        Intent intent=new Intent(Main3Activity.visitCar.class);
//        startActivityForResult(intent,requestcode5);
//    }
//});
//        addBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(Main3Activity.this,Notice.class);
//                startActivityForResult(intent,requestcode2);
//            }
//        });
//        addBtn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent2=new Intent(Main3Activity.this,Notice.class);
//                startActivityForResult(intent2,requestcode3);
//            }
//        });


    }
}
