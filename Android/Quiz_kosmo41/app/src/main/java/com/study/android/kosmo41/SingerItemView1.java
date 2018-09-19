package com.study.android.kosmo41;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingerItemView1 extends LinearLayout {

    TextView textView4;
    TextView textView5;
    TextView textView6;
    ImageView imageView2;



    public SingerItemView1(Context context) {
        super(context);

        LayoutInflater inflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item_view2,this,true);




        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        imageView2 = findViewById(R.id.imageView2);

    }


    public void setName2(String name) {
        textView4.setText(name);
    }

    public void setAge2(String Age) {
        textView5.setText(Age);
    }

    public void setAddress2(String address) {
        textView6.setText(address);
    }

    public void setImage2(int imgNum) {
        imageView2.setImageResource(imgNum);
    }





    public TextView getTextView4() {
        return textView4;
    }

    public void setTextView4(TextView textView4) {
        this.textView4 = textView4;
    }

    public TextView getTextView5() {
        return textView5;
    }

    public void setTextView5(TextView textView5) {
        this.textView5 = textView5;
    }

    public TextView getTextView6() {
        return textView6;
    }

    public void setTextView6(TextView textView6) {
        this.textView6 = textView6;
    }

    public ImageView getImageView2() {
        return imageView2;
    }

    public void setImageView2(ImageView imageView2) {
        this.imageView2 = imageView2;
    }



}
