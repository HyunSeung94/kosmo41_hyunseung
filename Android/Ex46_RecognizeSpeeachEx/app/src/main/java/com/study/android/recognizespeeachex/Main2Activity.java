package com.study.android.recognizespeeachex;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements RecognitionListener{

    private static final String TAG = "lecture";

    private static final int REQUEST_CODE = 1000;
    TextView textView1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView1 = findViewById(R.id.textView1);
    }

    public void onBtn1Clicked(View v){
        try{
            //음성 인식의 실행(1)
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,getPackageName());
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR");
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"음성 검색");
            intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,1);

            startActivityForResult(intent, REQUEST_CODE);
        } catch (ActivityNotFoundException e){
            Log.d(TAG, "ActivityNotFoundException");
        }
    }

    @Override
    public void onReadyForSpeech(Bundle params) {

    }

    @Override
    public void onBeginningOfSpeech() {

    }

    @Override
    public void onRmsChanged(float rmsdB) {

    }

    @Override
    public void onBufferReceived(byte[] buffer) {

    }

    @Override
    public void onEndOfSpeech() {

    }

    @Override
    public void onError(int error) {
        String message;
        switch (error) {
            case SpeechRecognizer.ERROR_AUDIO:
                message = "오디오 에러";
                break;
            case SpeechRecognizer.ERROR_CLIENT:
                message = "오디오 에러";
                break;
            case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                message = "오디오 에러";
                break;
            case SpeechRecognizer.ERROR_NETWORK:
                message = "오디오 에러";
                break;
            case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                message = "오디오 에러";
                break;
            case SpeechRecognizer.ERROR_NO_MATCH:
                message = "오디오 에러";
                break;
            case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                message = "오디오 에러";
                break;
            case SpeechRecognizer.ERROR_SERVER:
                message = "오디오 에러";
                break;
            case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                message = "오디오 에러";
                break;
                default:
                    message = "알수 없음";
                    break;
        }

    }

    @Override
    public void onResults(Bundle results) {

    }

    @Override
    public void onPartialResults(Bundle partialResults) {

    }

    @Override
    public void onEvent(int eventType, Bundle params) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case REQUEST_CODE : {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> text = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    String[] rs = new String[text.size()];
                    text.toArray(rs);

                    textView1.setText(rs[0]);

                }
                break;
            }
        }
    }
}
