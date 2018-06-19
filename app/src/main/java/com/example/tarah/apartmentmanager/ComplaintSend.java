package com.example.tarah.apartmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ComplaintSend extends AppCompatActivity {
    TextView who1;
    TextView who2;
    int iswho2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_send);
        Intent intent=getIntent();
        who1 = (TextView) findViewById(R.id.who1);
        who2 = (TextView) findViewById(R.id.who2);
        iswho2 = intent.getIntExtra("iswho2",0);

        if(iswho2==1){
            who1.setVisibility(View.GONE);
            who2.setVisibility(View.VISIBLE);
        }
    }

}
