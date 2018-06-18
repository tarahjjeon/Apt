package com.example.tarah.apartmentmanager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MartItemView extends LinearLayout {
    TextView textView_title;
    TextView textView_subtitle;
    TextView textView_price;

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
        textView_title = (TextView) findViewById(R.id.title);
        textView_subtitle = (TextView) findViewById(R.id.subtitle);
        textView_price=(TextView) findViewById(R.id.price);
    }

    public void setTextView_title(String title){ textView_title.setText(title); }

    public void setTextView_subtitle(String subtitle){ textView_subtitle.setText(subtitle); }

    public void setTextView_price(String price) { textView_price.setText(price); }
}
