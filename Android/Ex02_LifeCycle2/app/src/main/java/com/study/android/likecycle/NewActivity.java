package com.study.android.likecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    String sName ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Toast.makeText(getApplicationContext(),"onCreate 호출됨", Toast.LENGTH_LONG).show();

        // 인텐트에 전달된 데이타 구하기
        Intent intent = getIntent();
        sName = intent.getStringExtra("CustomerName"); // 전달된 데이터를 sName에 저장

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"onStart 호출됨", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume 호출됨", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"onPause 호출됨", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"onStop 호출됨", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"onDestroy 호출됨", Toast.LENGTH_LONG).show();
    }

    public void onBtn1Clicked(View v){
        //토스트로 전달된 데이터 보여주기
        Toast.makeText(getApplicationContext(),
                "CustomerName : " + sName, Toast.LENGTH_SHORT).show(); //CustomerName 프린트한거고 sName은 데이터를 저장한변수
    }

    public void onBtn2Clicked(View v){
        Intent intent = new Intent();
        intent.putExtra("BackData","바보");
        setResult(10, intent);

        finish();
    }
}
