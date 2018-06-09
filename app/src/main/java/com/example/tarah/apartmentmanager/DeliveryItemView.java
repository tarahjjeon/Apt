package com.example.tarah.apartmentmanager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DeliveryItemView extends LinearLayout {
    TextView textView_date;
    TextView textView_check;
    ImageView imageView_check;

    public DeliveryItemView(Context context) {
        super(context);
        init(context);
    }

    public DeliveryItemView(Context context, AttributeSet attrs){
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.delivery_item, this, true);

        textView_date = (TextView) findViewById(R.id.textView_date);
        textView_check=(TextView) findViewById(R.id.textView_check);
        imageView_check=(ImageView) findViewById(R.id.imageView_check);
    }

    public void setTextView_date(String date) {
        textView_date.setText(date);
    }

    public void setTextView_check(int check) {
        if(check == 0) {
            textView_check.setText("수령완료");
            imageView_check.setImageResource(R.drawable.deliveryboxcheckimg);
        }else{
            textView_check.setText("택배도착");
            imageView_check.setImageResource(R.drawable.deliveryboximg);
        }
    }
}
