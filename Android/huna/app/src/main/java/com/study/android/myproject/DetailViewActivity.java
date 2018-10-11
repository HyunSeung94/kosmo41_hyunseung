package com.study.android.myproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DetailViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
    }
    //리스트로 가기
    public void onButton4Clicked (View v) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //삭제하기
    public void onButton5Clicked (View v) {


    }
}
