package com.study.android.myproject;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lecture";

    SQLiteDatabase database;
    SingerAdapter adapter;
    EditText editText1;
    SpeechRecognizer mRecognizer;
    String test ;
    ArrayList<SingerItem> items = new ArrayList<>();//


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new SingerAdapter(this);

        ListView listView = findViewById(R.id.listView1); //변수초기화
        listView.setAdapter(adapter);  // 어댑터 할당



        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int position, long arg3){

               SingerItem item = (SingerItem)adapter.getItem(position);
              String sql = "delete from customer where contents = '"+item.getContents()+"'";


                try{
                    database.execSQL(sql);
                    Toast.makeText(MainActivity.this,"데이터 삭제"+item.getContents(), Toast.LENGTH_SHORT).show();
                } catch(Exception e){
                    e.printStackTrace();
                }
                selectAllData();
                return false;
            }
        });

        createMyDatabase();
        createMyTable();
        selectAllData();


        editText1=findViewById(R.id.editText1);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED){

            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.RECORD_AUDIO)){

            }else{
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.RECORD_AUDIO}, 1);
            }
        }

        mRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        mRecognizer.setRecognitionListener(recognitionListener);

    }

    //메모하기 버튼
    public void onButton1Clicked (View v){
        String userinput = editText1.getText().toString();
        Log.d(TAG,userinput);

        String sql = "insert into customer(contents) values ('"+userinput+"');";

        try {
            database.execSQL(sql);
            Toast.makeText(this,"저장되었습니다", Toast.LENGTH_SHORT).show();

            selectAllData();

        }catch (Exception e){
            e.printStackTrace();

        }

    }

    public void onButton2Clicked (View v){
        try{
            //음성인식의 실행
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getPackageName());
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR");

            intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "음성 검색");

            mRecognizer.startListening(intent);
        } catch (ActivityNotFoundException e){
            Log.d(TAG, "ActivityNotFoundException");
        }
    }

    public void onButton3Clicked (View v){
        deleteMyTable();
        adapter.notifyDataSetChanged();
        createMyDatabase();
        createMyTable();
        selectAllData();
    }



   private void createMyDatabase(){
        String dbName = "customer.sqlite";
        try{
            database = openOrCreateDatabase(dbName, Activity.MODE_PRIVATE, null);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private void createMyTable(){

        String sql = "create table if not exists customer (contents text)";
        try{
            database.execSQL(sql);

        } catch(Exception e){
            e.printStackTrace();
        }

    }


    private void deleteMyTable(){
        String sql = "drop table customer";

        try{
            database.execSQL(sql);
            Toast.makeText(this,"테이블삭제", Toast.LENGTH_SHORT).show();

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private void selectAllData(){
        String sql = "select contents from customer";

        adapter.clear();
        try{
            Cursor cursor = database.rawQuery(sql, null);

            int count = cursor.getCount();

            int i =0;
            while(i<count){
                cursor.moveToNext();

                String contents = cursor.getString(0);

                Log.d(TAG, "aaa:"+contents);
                SingerItem item = new SingerItem(contents);
                adapter.addItem(item);
                adapter.notifyDataSetChanged();



                i++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    private RecognitionListener recognitionListener = new RecognitionListener() {
        @Override
        public void onReadyForSpeech(Bundle bundle) {

        }

        @Override
        public void onBeginningOfSpeech() {

        }

        @Override
        public void onRmsChanged(float v) {

        }

        @Override
        public void onBufferReceived(byte[] bytes) {

        }

        @Override
        public void onEndOfSpeech() {

        }

        @Override
        public void onError(int i) {

        }

        @Override
        public void onResults(Bundle bundle) {
            String key="";
            key = SpeechRecognizer.RESULTS_RECOGNITION;
            ArrayList<String> mResult = bundle.getStringArrayList(key);

            String[] rs = new String[mResult.size()];
            mResult.toArray(rs);

            editText1.setText(rs[0]);
        }

        @Override
        public void onPartialResults(Bundle bundle) {

        }

        @Override
        public void onEvent(int i, Bundle bundle) {

        }
    };


}
