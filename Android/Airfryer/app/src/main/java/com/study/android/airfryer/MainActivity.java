package com.study.android.airfryer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtn1Clicked(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sukm83.blog.me/221349311236"));
        startActivity(intent);
    }

    public void onBtn2Clicked(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/jin_hee316/221321390267"));
        startActivity(intent);
    }

    public void onBtn3Clicked(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/yium797979/221352910049"));
        startActivity(intent);
    }

    public void onBtn4Clicked(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://plantip.blog.me/221354365034"));
        startActivity(intent);
    }
    public void onBtn5Clicked(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/tlsghk833/221371366924"));
        startActivity(intent);
    }
    public void onBtn6Clicked(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/yium797979/221352910049"));
        startActivity(intent);
    }



}
