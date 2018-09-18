package com.study.android.hello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    String sName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        // 인텐트에 전달된 데이타 구하기
        Intent intent = getIntent();
        sName = intent.getStringExtra("CustomerName"); // 전달된 데이터를 sName에 저장
    }

    public void onBtn1Clicked(View v){
        //토스트로 전달된 데이터 보여주기
        Toast.makeText(getApplicationContext(),
                "CustomerName : " + sName, Toast.LENGTH_SHORT).show(); //CustomerName 프린트한거고 sName은 데이터를 저장한변수
    }
    public void onBtn2Clicked(View v){
        Intent intent = new Intent();
        intent.putExtra("BackData","강감찬");
        setResult(10, intent);

        finish();
    }
}
