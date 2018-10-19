package com.study.android.memoproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;

public class ChatActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "lecture";
    // 채팅방
    private String CHAT_NAME;
    private String USER_NAME;

    private ListView chat_view;
    private ListView chat_view2;
    private EditText chat_edit;
    private BootstrapButton chat_send;



    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    DataSnapshot dataSnapshot;
    String chatdate;
    // 이메일
    private FirebaseAuth mAuth;
    //번역
    String sourceLang = "";
    String targetLang = "";
    String  translation = "";
        int translationcheck = 0;

    String[] items = { "내언어선택","한국","영어","중국","일본"};
    String[] items2 = { "번역언어선택","한국","영어","중국","일본"};
    //방이름 뷰
    TextView roomView;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);



        mAuth = FirebaseAuth.getInstance();
       // etResult = (EditText) findViewById(R.id.etResult);
        // 위젯 ID 참조
        chat_view = (ListView) findViewById(R.id.chat_view);
        roomView = (TextView)findViewById(R.id.roomView);
        chat_edit = (EditText) findViewById(R.id.chat_edit);
        chat_send = findViewById(R.id.chat_sent);

        // 로그인 화면에서 받아온 채팅방 이름, 유저 이름 저장
        Intent intent = getIntent();
        CHAT_NAME = intent.getStringExtra("chatName");
        USER_NAME = intent.getStringExtra("userName");
        name=mAuth.getCurrentUser().getDisplayName();
        // 채팅 방 입장
        roomView.setText(CHAT_NAME+"방입니다.");
        openChat(CHAT_NAME);



        // 메시지 전송 버튼에 대한 클릭 리스너 지정
        chat_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chat_edit.getText().toString().equals("")) {
                    return;
                }
                else if(sourceLang.equals("") || targetLang.equals("")) {
                    Toast.makeText(ChatActivity.this, "번역을 선택하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }



                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH시mm분ss초");
                chatdate = df.format(c.getTime());



                ChatDTO chat = new ChatDTO(USER_NAME, chat_edit.getText().toString(),chatdate); //ChatDTO를 이용하여 데이터를 묶는다.
                databaseReference.child("chat").child(CHAT_NAME).child(chatdate).setValue(chat); // 데이터 푸쉬
                //Toast.makeText(ChatActivity.this, "흠3"+translationcheck, Toast.LENGTH_SHORT).show();
                Log.e("LOG", "과연1111");
                openChat(CHAT_NAME);
                //실행버튼을 클릭하면 AsyncTask를 이용 요청하고 결과를 반환받아서 화면에 표시하도록 해보자.
                NaverTranslateTask asyncTask = new NaverTranslateTask();
                String sText = chat_edit.getText().toString();
                asyncTask.execute(sText);
                Log.e("LOG", "과연2222");

                chat_edit.setText(""); //입력창 초기화

            }
        });

        //내 언어 선택
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, items );
        Spinner spinner = findViewById(R.id.spinner1);
        
        spinner.setAdapter(adapter3);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // 아이템이 선택되엇을때 호출 됨
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if(items[position].equals("한국")){
                    sourceLang = "ko";
                    Log.d("테스트",sourceLang);
                }else if(items[position].equals("영어")){
                    sourceLang = "en";
                    Log.d("테스트",sourceLang);
                }
                else if(items[position].equals("중국")){
                    sourceLang = "zh-CN";
                    Log.d("테스트",sourceLang);
                }
                else if(items[position].equals("일본")){
                    sourceLang = "ja";
                    Log.d("테스트",sourceLang);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                sourceLang="";
            }
        });

        // 번역언어
        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, items2 );
        Spinner spinner2 = findViewById(R.id.spinner2);
        spinner2.setAdapter(adapter4);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // 아이템이 선택되엇을때 호출 됨
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if(items2[position].equals("한국")){
                    targetLang = "ko";
                    Log.d("테스트",sourceLang);
                }else if(items2[position].equals("영어")){
                    targetLang = "en";
                    Log.d("테스트",sourceLang);
                }
                else if(items2[position].equals("중국")){
                    targetLang = "zh-CN";
                    Log.d("테스트",sourceLang);
                }
                else if(items2[position].equals("일본")){
                    targetLang = "ja";
                    Log.d("테스트",sourceLang);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                targetLang="";
            }
        });

    }
    private void addMessage(DataSnapshot dataSnapshot, ArrayAdapter<String> adapter,ArrayAdapter<String> adapter2) {

        ChatDTO chatDTO = dataSnapshot.getValue(ChatDTO.class);
        LinearLayout layout = new LinearLayout(getApplicationContext());
        layout.setOrientation(LinearLayout.VERTICAL);
//
//            layout.addView(view1);


        if(USER_NAME.equals(chatDTO.getUserName())) {
            SingerItemView view = new SingerItemView(getApplicationContext());

            view.setName(chatDTO.getUserName() +" : "+chatDTO.getMessage());
            layout.addView(view);

        } else{
            SingerItemView1 view2 = new SingerItemView1(getApplicationContext());
            view2.setName2(chatDTO.getMessage());
            layout.addView(view2);
        }
        Log.e("LOG", "테스트222222");

        //adapter.add(chatDTO.getUserName() + " : " + chatDTO.getMessage());
        //adapter2.add(chatDTO.getTime());

    }
    public void removeMessage(DataSnapshot dataSnapshot, ArrayAdapter<String> adapter) {
        Log.e("LOG", "테스트333333");
        ChatDTO chatDTO = dataSnapshot.getValue(ChatDTO.class);
        adapter.remove(chatDTO.getUserName() + " : " + chatDTO.getMessage());
//        Toast.makeText(this, "remove!?", Toast.LENGTH_SHORT).show();
    }

    //네이버번역
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    //ASYNCTASK
    public class NaverTranslateTask extends AsyncTask<String, Void, String> {

        public String resultText;
        //Naver
        String clientId = "sbARUH4PVaGXToPs6BiZ";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "TGfD3aqjej";//애플리케이션 클라이언트 시크릿값";
        //언어선택도 나중에 사용자가 선택할 수 있게 옵션 처리해 주면 된다.


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        //AsyncTask 메인처리
        @Override
        protected String doInBackground(String... strings) {
            //네이버제공 예제 복사해 넣자.
            //Log.d("AsyncTask:", "1.Background");
            Log.e("LOG", "테스트44444");
            String sourceText = strings[0];

            try {
                //String text = URLEncoder.encode("만나서 반갑습니다.", "UTF-8");
                String text = URLEncoder.encode(sourceText, "UTF-8");
                String apiURL = "https://openapi.naver.com/v1/language/translate";
                URL url = new URL(apiURL);
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("X-Naver-Client-Id", clientId);
                con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
                // post request
                String postParams = "source="+sourceLang+"&target="+targetLang+"&text=" + text;
                con.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                wr.writeBytes(postParams);
                wr.flush();
                wr.close();
                int responseCode = con.getResponseCode();
                BufferedReader br;
                if(responseCode==200) { // 정상 호출
                    br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                } else {  // 에러 발생
                    br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                }
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                //System.out.println(response.toString());
                return response.toString();

            } catch (Exception e) {
                //System.out.println(e);
                Log.d("error", e.getMessage());
                return null;
            }
        }

        //번역된 결과를 받아서 처리
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //최종 결과 처리부
            Log.d("background result", s.toString()); //네이버에 보내주는 응답결과가 JSON 데이터이다.
            Log.e("LOG", "테스트55555");
            //JSON데이터를 자바객체로 변환해야 한다.
            //Gson을 사용할 것이다.

            Gson gson = new GsonBuilder().create();
            JsonParser parser = new JsonParser();
            JsonElement rootObj = parser.parse(s.toString())
                    //원하는 데이터 까지 찾아 들어간다.
                    .getAsJsonObject().get("message")
                    .getAsJsonObject().get("result");
            //안드로이드 객체에 담기
            TranslatedItem items = gson.fromJson(rootObj.toString(), TranslatedItem.class);
            //Log.d("result", items.getTranslatedText());

            //번역 말

            Log.e("LOG", "테스트66666");
            translation = items.getTranslatedText();
            ChatDTO chat1 = new ChatDTO("Papago", translation, chatdate); //ChatDTO를 이용하여 데이터를 묶는다.
            databaseReference.child("chat").child(CHAT_NAME).child("Papago").setValue(chat1);
            openChat(CHAT_NAME);
            Log.e("LOG", "과연3333");
            //Toast.makeText(ChatActivity.this, "흠1" + translationcheck, Toast.LENGTH_SHORT).show();// 데이터 푸쉬
            // 시간처리
//            Handler mHandler = new Handler();
//            mHandler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                }
//            }, 1000); // 2000ms



            Log.e("LOG", "테스트77777");
//            Calendar c = Calendar.getInstance();
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH시mm분ss초");
//            chatdate = df.format(c.getTime());
//            Toast.makeText(ChatActivity.this, "과연"+chatdate, Toast.LENGTH_SHORT).show();

//            ChatDTO chat = new ChatDTO("번역",translation,chatdate); //ChatDTO를 이용하여 데이터를 묶는다.
//            databaseReference.child("chat").child(CHAT_NAME).child(chatdate).setValue(chat); // 데이터 푸쉬



        }






        //자바용 그릇
        private class TranslatedItem {
            String translatedText;

            public String getTranslatedText() {
                return translatedText;
            }
        }
    }



    private void openChat(final String chatName) {
        // 리스트 어댑터 생성 및 세팅
        final ArrayAdapter<String> adapter

                = new ArrayAdapter<String>(this, R.layout.chat,R.id.textView1);
        final ArrayAdapter<String> adapter2

                = new ArrayAdapter<String>(this, R.layout.chat2, R.id.textView2);
        adapter.clear();
        adapter.notifyDataSetChanged();//새로고침
        adapter2.clear();
        adapter2.notifyDataSetChanged();//새로고침
        chat_view.setAdapter(adapter);

        chat_view.setAdapter(adapter2);
        Log.e("LOG", "테스트88888");
        chat_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, final int position, long arg3) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ChatActivity.this);

                builder.setMessage("메세지를 삭제하시겠습니까?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("알림")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Log.e("LOG", "s:"+adapter.getItem(position));


                                //방삭제 databaseReference.child("/chat/"+CHAT_NAME).setValue(null);
//                                Query applesQuery = ref.child("firebase-test").orderByChild("title").equalTo("Apple");
                                databaseReference.child("/chat/"+CHAT_NAME+"/"+adapter2.getItem(position)+"/").setValue(null);
                                Toast.makeText(ChatActivity.this, "메시지삭제"+adapter2.getItem(position) , Toast.LENGTH_SHORT).show();
                                adapter.notifyDataSetChanged();//새로고침
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id){
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();


//                Toast.makeText(getApplicationContext(),
//                        "selected : " + adapter.getItem(position)+mAuth.getCurrentUser().getEmail(),
//                        Toast.LENGTH_SHORT).show();
            }
        });


        // 데이터 받아오기 및 어댑터 데이터 추가 및 삭제 등..리스너 관리
            databaseReference.child("chat").child(chatName).addChildEventListener(new ChildEventListener() {

                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    Log.e("LOG", "테스트99999");

                    //listview 자동 스크롤
                    chat_view.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
                    chat_view.setSelection(adapter.getCount() - 1);
//                    chat_view2.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
//                    chat_view2.setSelection(adapter2.getCount() - 1);
                    addMessage(dataSnapshot, adapter, adapter2);
                    Log.e("LOG", "s:" + s);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    adapter.notifyDataSetChanged();//새로고침
                    addMessage(dataSnapshot, adapter, adapter2);
                    Log.e("LOG", "새로고침2");
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    removeMessage(dataSnapshot, adapter);
                    Log.e("LOG", "새로고침3");
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                    adapter.notifyDataSetChanged();//새로고침
                    Log.e("LOG", "새로고침4");
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.e("LOG", "새로고침5");
                }

            });



    }




}
