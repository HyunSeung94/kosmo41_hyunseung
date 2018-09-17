package com.study.android.hello;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lecture"; // 코드를 합칠때 공통적으로 하기위함

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //메모리에 있는 내용 불러오기

        //버튼1:
        // 클릭 이벤트 추가
        //로그 출력 추가
        //토스트 생성 추가
        //예전방식이긴 하지만 편한방법이 안되는경우 때문에 배움
        Button button1 = findViewById(R.id.button1);    //버튼불러오기
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.d(TAG,"로그 출력"); //뭐라고 반응하는지 적기
                Toast.makeText(getApplicationContext(),"긴 토스트", Toast.LENGTH_LONG).show();
            }


        });
    }

    //버튼2:
    //인텐트 만들어 웹브라우저 띄우기
    //버튼에 onclick에서 바로 메소드불러서 연결하는 편한방법(안되는경우 있음)
    public void onBtn2Clicked(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(intent);
    }

    public void onBtn2Clicked2(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01025148593"));
        startActivity(intent);
    }
}
