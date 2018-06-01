package com.example.tarah.apartmentmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Complaint extends AppCompatActivity {
    TextView newCpt,cptS,cptS1,cptS2,cptG,cptG1;

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
        cptS1=findViewById(R.id.cptS1);
        cptS2=findViewById(R.id.cptS2);
        cptG=findViewById(R.id.cptG);
        cptG1=findViewById(R.id.cptG1);
       // cptS2.setVisibility(View.GONE);

    }


}
