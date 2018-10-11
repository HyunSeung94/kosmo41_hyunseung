package com.study.android.myproject;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "lecture";

    SQLiteDatabase database;
    SingerAdapter adapter;
    EditText editText1;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new SingerAdapter(this);

        ListView listView = findViewById(R.id.listView1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3){

                SingerItem item = (SingerItem)adapter.getItem(position);
                Toast.makeText(getApplicationContext(),
                        "selected" +item.getContents(), Toast.LENGTH_SHORT).show();
                //토스트 수정해서 DetailView 액티비티로 넘어가게 하기
            }
        });

        createMyDatabase();
        createMyTable();
        selectAllData();
        Log.e(TAG,"테스트1111");
        editText1=findViewById(R.id.editText1);
        button2=findViewById(R.id.button2);
    }

    //메모하기 버튼
    public void onButton1Clicked (View v){
        String userinput = editText1.getText().toString();
        Log.d(TAG,userinput);
        Log.e(TAG,"userinput:"+userinput);

        String sql = "insert into customer(contents) values ('"+userinput+"');";
        Log.e(TAG,"테스트2222");
        try {
            database.execSQL(sql);
            Toast.makeText(this,"저장되었습니다", Toast.LENGTH_SHORT).show();
            Log.e(TAG,"테스트3333");

        }catch (Exception e){
            e.printStackTrace();
            Log.e(TAG,"테스트4444");
        }

    }
    public void onBtn2Clicked(View v){
        selectAllData();
    }

   private void createMyDatabase(){
        String dbName = "customer.sqlite";
        try{
            database = openOrCreateDatabase(dbName, Activity.MODE_PRIVATE, null);
            Toast.makeText(this,"디비생성", Toast.LENGTH_SHORT).show();
            Log.e(TAG,"테스트5555");
        } catch(Exception e){
            e.printStackTrace();
            Log.e(TAG,"테스트6666");
        }
    }

    private void createMyTable(){

        String sql = "create table if not exists customer (contents text)";
        try{
            database.execSQL(sql);
            Toast.makeText(this,"테이블생성", Toast.LENGTH_SHORT).show();
            Log.e(TAG,"테스트7777");
        } catch(Exception e){
            e.printStackTrace();
            Log.e(TAG,"테스트8888");
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
        Log.e(TAG,"테스트9999");
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

                i++;
            }
        } catch (Exception e){
            e.printStackTrace();
            Log.e(TAG,"테스트101010 ");
        }
    }


}
