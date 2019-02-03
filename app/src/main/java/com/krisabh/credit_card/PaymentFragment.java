package com.krisabh.credit_card;

import android.content.Context;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;



public class PaymentFragment extends Fragment {

    public PaymentFragment() {
        // Required empty public constructor
    }

    private AdView mAdView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_payment,
                container, false);
        Button button = (Button) view.findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // do something
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bankbazaar.com/credit-score.html?ck=Y%2BziX71XnZjIM9ZwEflsyLrVcYEHO5c6Bpn9bfScaCyZC0TqFEkhF6ljN6nbC1ZXXBwImSfaF7%2BS%0AmJOG7qYyyg%3D%3D&rc=1"));
                startActivity(browserIntent);
            }
        });

        MobileAds.initialize(getActivity(), "ca-app-pub-3940256099942544~3347511713");
        mAdView = (AdView) view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        return view;
    }






}
