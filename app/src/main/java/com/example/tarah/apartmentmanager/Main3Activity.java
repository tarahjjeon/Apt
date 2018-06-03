package com.example.tarah.apartmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    ImageButton setBtn3;

    TextView notice1,notice2,complaint,delivery,visitCar,community;



   final int requestcode11=34;
  final int requestcode12=35;
    final int requestcode13=36;
    final int requestcode14=37;
    final int requestcode15=38;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
        addListener();
    }
    public void init(){
        Intent intent=getIntent();
        setBtn3=(ImageButton)findViewById(R.id.setBtn3);
       notice1=(TextView)findViewById(R.id.notice1);
       notice2=(TextView)findViewById(R.id.notice2);
       complaint=(TextView)findViewById(R.id.complaint);
       delivery=(TextView)findViewById(R.id.delivery);
       visitCar=(TextView)findViewById(R.id.visitCar);
       community=(TextView)findViewById(R.id.community);
//       notice01=(RelativeLayout)findViewById(R.id.notice01);
//       notice02=(RelativeLayout)findViewById(R.id.notice02);

    }
    public void addListener(){

        notice1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                    Intent intent=new Intent(Main3Activity.this,Notice.class);
                    intent.putExtra("test",70);
                    startActivityForResult(intent,requestcode12);

            }
        });
        notice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(Main3Activity.this,Notice.class);
                intent.putExtra("test",72);
                startActivityForResult(intent,requestcode13);

            }
        });
        complaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(Main3Activity.this,Complaint.class);
                startActivityForResult(intent,requestcode11);

            }
        });
community.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Main3Activity.this,Comunity.class);
        startActivityForResult(intent,requestcode14);
    }
});
delivery.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Main3Activity.this,Delivery.class);
        startActivityForResult(intent,requestcode15);
    }
});
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
