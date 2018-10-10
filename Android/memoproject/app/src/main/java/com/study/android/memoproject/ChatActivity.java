package com.study.android.memoproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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
    private EditText chat_edit;
    private Button chat_send;



    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    DataSnapshot dataSnapshot;
    String chatdate;
    // 이메일
    private FirebaseAuth mAuth;
    //번역
    String  translation = "";
    int translationcheck = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        mAuth = FirebaseAuth.getInstance();
       // etResult = (EditText) findViewById(R.id.etResult);
        // 위젯 ID 참조
        chat_view = (ListView) findViewById(R.id.chat_view);
        chat_edit = (EditText) findViewById(R.id.chat_edit);
        chat_send = (Button) findViewById(R.id.chat_sent);

        // 로그인 화면에서 받아온 채팅방 이름, 유저 이름 저장
        Intent intent = getIntent();
        CHAT_NAME = intent.getStringExtra("chatName");
        USER_NAME = intent.getStringExtra("userName");

        // 채팅 방 입장
        openChat(CHAT_NAME);

        // 메시지 전송 버튼에 대한 클릭 리스너 지정
        chat_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chat_edit.getText().toString().equals("")) {
                    return;
                }
                translationcheck ++;
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH시mm분ss초");
                chatdate = df.format(c.getTime());

                //실행버튼을 클릭하면 AsyncTask를 이용 요청하고 결과를 반환받아서 화면에 표시하도록 해보자.
                NaverTranslateTask asyncTask = new NaverTranslateTask();
                String sText = chat_edit.getText().toString();
                asyncTask.execute(sText);

                ChatDTO chat = new ChatDTO(USER_NAME, chat_edit.getText().toString(),chatdate); //ChatDTO를 이용하여 데이터를 묶는다.
                databaseReference.child("chat").child(CHAT_NAME).child(chatdate).setValue(chat); // 데이터 푸쉬
                Toast.makeText(ChatActivity.this, "흠3"+translationcheck, Toast.LENGTH_SHORT).show();
                openChat(CHAT_NAME);
                translationcheck ++;

                chat_edit.setText(""); //입력창 초기화

            }
        });

    }
    private void addMessage(DataSnapshot dataSnapshot, ArrayAdapter<String> adapter,ArrayAdapter<String> adapter2) {

        ChatDTO chatDTO = dataSnapshot.getValue(ChatDTO.class);
        adapter.add(chatDTO.getUserName() + " : " + chatDTO.getMessage());
        adapter2.add(chatDTO.getTime());

       // Toast.makeText(this, "이거타는거니!?", Toast.LENGTH_SHORT).show();

    }
    private void addppagoMessage(DataSnapshot dataSnapshot, ArrayAdapter<String> adapter,ArrayAdapter<String> adapter2) {

        ChatDTO chatDTO = dataSnapshot.getValue(ChatDTO.class);
        adapter.add(chatDTO.getUserName() + " : " + chatDTO.getMessage());
        adapter2.add(chatDTO.getTime());
        // Toast.makeText(this, "이거타는거니!?", Toast.LENGTH_SHORT).show();

    }


    public void removeMessage(DataSnapshot dataSnapshot, ArrayAdapter<String> adapter) {
        ChatDTO chatDTO = dataSnapshot.getValue(ChatDTO.class);
        adapter.remove(chatDTO.getUserName() + " : " + chatDTO.getMessage());
//        Toast.makeText(this, "remove!?", Toast.LENGTH_SHORT).show();
    }


    private void openChat(final String chatName) {
        // 리스트 어댑터 생성 및 세팅
        final ArrayAdapter<String> adapter

                = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1);
        final ArrayAdapter<String> adapter2

                = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1);
        chat_view.setAdapter(adapter);
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
//                                StringTokenizer t1 = new StringTokenizer(adapter.getItem(position));
//                                String name = t1.nextToken();
//                                t1.nextToken();
//                                String msg = t1.nextToken();
//                                Log.e("LOG", "s:"+msg);
//                                Log.e("LOG", "s:"+name);

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
                    addMessage(dataSnapshot, adapter, adapter2);
                    Log.e("LOG", "s:" + s);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    removeMessage(dataSnapshot, adapter);
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });



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
        String sourceLang = "ko";
        String targetLang = "en";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        //AsyncTask 메인처리
        @Override
        protected String doInBackground(String... strings) {
            //네이버제공 예제 복사해 넣자.
            //Log.d("AsyncTask:", "1.Background");

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

            //번역결과를 텍스트뷰에 넣는다.
            //etResult.setText(items.getTranslatedText());

            //번역 말


            translation = items.getTranslatedText();
            ChatDTO chat1 = new ChatDTO("Papago", translation, chatdate); //ChatDTO를 이용하여 데이터를 묶는다.
            databaseReference.child("chat").child(CHAT_NAME).child(chatdate).setValue(chat1);
            Toast.makeText(ChatActivity.this, "흠1" + translationcheck, Toast.LENGTH_SHORT).show();// 데이터 푸쉬
            openChat(CHAT_NAME);


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


}
