package com.study.android.memoproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.auth.FirebaseAuth;
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

public class login extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    private static final String TAG = "lecture";

    BootstrapButton btTranslate;
    EditText etSource;
    EditText etResult;
    String sName ;
    //언어 선택
    String sourceLang = "";
    String targetLang = "";

    String[] items = { "언어선택","한국","영어","중국","일본"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etSource = (EditText) findViewById(R.id.et_source);
        etResult = (EditText) findViewById(R.id.et_result);
        btTranslate = (BootstrapButton) findViewById(R.id.bt_translate);

        // 인텐트에 전달된 데이타 구하기
        Intent intent = getIntent();
        sName = intent.getStringExtra("CustomerName"); // 전달된 데이터를 sName에 저장
        //번역 실행버튼 클릭이벤트
        btTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //소스에 입력된 내용이 있는지 체크하고 넘어가자.
                if(etSource.getText().toString().length() == 0) {
                    Toast.makeText(login.this, "번역할 내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                    etSource.requestFocus();
                    return;
                } else if(sourceLang.equals("") || targetLang.equals("")) {
                    return;
                }


                //실행버튼을 클릭하면 AsyncTask를 이용 요청하고 결과를 반환받아서 화면에 표시하도록 해보자.
                NaverTranslateTask asyncTask = new NaverTranslateTask();
                String sText = etSource.getText().toString();
                asyncTask.execute(sText);
            }
        });

        //내 언어 선택
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, items );
        Spinner spinner = findViewById(R.id.spinner1);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // 아이템이 선택되엇을때 호출 됨
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if(items[position]=="한국"){
                    sourceLang = "ko";
                    Log.d("테스트",sourceLang);
                }else if(items[position]=="영어"){
                    sourceLang = "en";
                    Log.d("테스트",sourceLang);
                }
                else if(items[position]=="중국"){
                    sourceLang = "zh-CN";
                    Log.d("테스트",sourceLang);
                }
                else if(items[position]=="일본"){
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
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, items );
        Spinner spinner2 = findViewById(R.id.spinner2);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // 아이템이 선택되엇을때 호출 됨
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if(items[position]=="한국"){
                    targetLang = "ko";
                    Log.d("테스트",sourceLang);
                }else if(items[position]=="영어"){
                    targetLang = "en";
                    Log.d("테스트",sourceLang);
                }
                else if(items[position]=="중국"){
                    targetLang = "zh-CN";
                    Log.d("테스트",sourceLang);
                }
                else if(items[position]=="일본"){
                    targetLang = "ja";
                    Log.d("테스트",sourceLang);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                targetLang="";
            }
        });



        //음성인식 실행버튼 이벤트
        //이건 나중에...
    }

    public void btn1Clicked(View v){
        Toast.makeText(login.this, "채팅방 입장"  ,Toast.LENGTH_SHORT).show();
        startActivity(new Intent(login.this, ChatLogin.class));
        finish();
    }

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
        // sourceLang = "";
        // targetLang = "en";

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
                String postParams = "source="+sourceLang+"&target="+targetLang+"&text=" +text;
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
            etResult.setText(items.getTranslatedText());
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
