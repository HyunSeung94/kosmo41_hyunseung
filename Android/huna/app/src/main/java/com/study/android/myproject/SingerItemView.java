package com.study.android.myproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingerItemView extends LinearLayout {

    TextView textView1;

    public SingerItemView(Context context) {
        super(context);

        LayoutInflater inflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_singer_item_view, this, true);

        textView1 = findViewById(R.id.textView1);


    }
    public void setContents(String contents) {
        textView1.setText(contents);
    }


}
