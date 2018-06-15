package com.example.tarah.apartmentmanager;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BaseActivity extends AppCompatActivity {
    public Typeface mTypeface=null;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        if(mTypeface==null){
            mTypeface=Typeface.createFromAsset(this.getAssets(),"font/BMJUA_ttf.ttf");
        }
        setGlobalFont(getWindow().getDecorView());
    }
    private void setGlobalFont(View view){
        if(view!=null){
            if(view instanceof ViewGroup){
                ViewGroup vg=(ViewGroup)view;
                int vgCnt=vg.getChildCount();
                for(int i=0;i<vgCnt;i++){
                    View v=vg.getChildAt(i);
                    if(v instanceof TextView){
                        ((TextView) v).setTypeface(mTypeface);
                    }
                    setGlobalFont(v);
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
