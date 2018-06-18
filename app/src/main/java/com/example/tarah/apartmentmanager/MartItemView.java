package com.example.tarah.apartmentmanager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class MartItemView extends LinearLayout {
//    TextView textView_date;
//    TextView textView_check;
//    ImageView imageView_check;

    public MartItemView(Context context) {
        super(context);
        init(context);
    }

    public MartItemView(Context context, AttributeSet attrs){
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.mart_item, this, true);

//        textView_date = (TextView) findViewById(R.id.textView_date);
//        textView_check=(TextView) findViewById(R.id.textView_check);
//        imageView_check=(ImageView) findViewById(R.id.imageView_check);
    }
}
