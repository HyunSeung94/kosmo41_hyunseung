package com.study.android.memoproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingerItemView1 extends LinearLayout {

    TextView textView2;




    public SingerItemView1(Context context) {
        super(context);

        LayoutInflater inflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.chat2,this,true);

        textView2 = findViewById(R.id.textView2);
    }


    public void setName2(String name) {
        textView2.setText(name);
    }
}
