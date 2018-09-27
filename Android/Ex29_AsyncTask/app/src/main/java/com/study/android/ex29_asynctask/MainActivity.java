package com.study.android.ex29_asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
// 쓰레드를 사용할때는 Ex29_AsyncTask사용 하는게 좋다. 안드로이드에서

    private static final String TAG = "lecture";

    ProgressBar mProgress1;
    int mProgressStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgress1 = findViewById(R.id.progressBar1);
    }

    public void onBtnClicked(View v) {
        new CounterTask().execute(0);
    }

    //파라미터에 Integer 3개가 아래 메소드 3개에 순서대로 들어감
    class CounterTask extends AsyncTask<Integer, Integer, Integer> {
        protected  void onPreExecute() {

        }
        @Override
        protected Integer doInBackground(Integer... integers) {
            while (mProgressStatus < 100) {
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                mProgressStatus ++;
                publishProgress(mProgressStatus);
            }
            return mProgressStatus;
        }

        protected  void onProgressUpdate(Integer...value){
            mProgress1.setProgress(mProgressStatus);
        }

        protected  void onPostExecute(Integer result){
            mProgress1.setProgress(mProgressStatus);
        }

    }
}
