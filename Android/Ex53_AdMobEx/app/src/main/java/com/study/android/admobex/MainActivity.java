package com.study.android.admobex;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends Activity {
    private static final String TAG = "lecture";
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 초기화
        String bannerid = getResources().getString(R.string.ad_unit_id_1);
        MobileAds.initialize(getApplicationContext(), bannerid);

        // 테스트 광고 부르기
        mAdView = (AdView) findViewById(R.id.adView);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }
            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.d(TAG, "b:"+errorCode);
            }
            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }
            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }
            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
            }
        });

        AdRequest adRequest = new AdRequest.Builder().
                addTestDevice("54133B91E943A32B1D1FE3C84114C71A").build();
        mAdView.loadAd(adRequest);

    }
}
