package com.krisabh.credit_card;

import android.content.Intent;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdView;

public class BankListActivity extends AppCompatActivity {
    LinearLayout l1, l2;
    Button btnsub;
    Animation uptodown, downtoup;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_list);



        btnsub = (Button) findViewById(R.id.buttonsub);
        l1 = (LinearLayout) findViewById(R.id.l1);
        l2 = (LinearLayout) findViewById(R.id.l2);
        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        l1.setAnimation(uptodown);
        l2.setAnimation(downtoup);

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener()
                                      {
                                          @Override
                                          public void onAdClosed() {
                                              Intent intent = new Intent(BankListActivity.this, BanksSearchActivity.class);
                                              startActivity(intent);
                                              mInterstitialAd.loadAd(new AdRequest.Builder().build());
                                          }
                                      }

        );



    }








    public void load_bank_and_score(View view) {
        if(mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        }
        else{
            Intent intent = new Intent(this, BanksSearchActivity.class);
            startActivity(intent);
        }


    }
}