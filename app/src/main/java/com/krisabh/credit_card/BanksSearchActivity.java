package com.krisabh.credit_card;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdView;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;

public class BanksSearchActivity extends AppCompatActivity {


    ListView listView;
    ListViewAdapter adapter;
    Dialog dialog;
    ImageView close_popup;
    private AdView mAdView;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<Model> arrayList = new ArrayList<Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banks_search);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Pay Your Bill");




        title = new String[]{"ICICI","SBI","HDFC","Citi","Kotak","Axis","RBL","Yes Bank","Bank of India","Central Bank",
                "PNB","American Express","Bank of Baroda" ,"Indusland","Union Bank","HSBC","Andhra Bank","IDBI"
        };
        description = new String[]{"Credit Card Bill Payment","Credit Card Bill Payment","Credit Card Bill Payment",
                "Credit Card Bill Payment","Credit Card Bill Payment","Credit Card Bill Payment","Credit Card Bill Payment",
                "Credit Card Bill Payment","Credit Card Bill Payment","Credit Card Bill Payment","Credit Card Bill Payment",
                "Credit Card Bill Payment","Credit Card Bill Payment","Credit Card Bill Payment","Credit Card Bill Payment",
                "Credit Card Bill Payment","Credit Card Bill Payment","Credit Card Bill Payment"

        };
        icon = new int[]{R.drawable.icici_s,R.drawable.sbi_s,R.drawable.hdfc,R.drawable.citi_s,R.drawable.kotak,
                R.drawable.axix_s,R.drawable.rbl,R.drawable.yes_s,R.drawable.boi,R.drawable.cbi,R.drawable.pnb,R.drawable.amex,
                R.drawable.bob_s,R.drawable.indusland_s,R.drawable.union,R.drawable.hsbc,R.drawable.andhra,R.drawable.idbi_s
        };

        listView = findViewById(R.id.listView);

        for (int i =0; i<title.length; i++){
            Model model = new Model(title[i], description[i], icon[i]);
            //bind all strings in an array
            arrayList.add(model);
        }

        //pass results to listViewAdapter class
        adapter = new ListViewAdapter(this, arrayList);

        //bind the adapter to the listview
        listView.setAdapter(adapter);


        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else {
                    adapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id==R.id.action_creditScore){
            //do your functionality here
            Intent intent = new Intent(this,banks_and_score.class);
            startActivity(intent);
            return true;
        }
        if (id==R.id.action_aboutUs){
            //do your functionality here
            dialog=new Dialog(this);
            dialog.setContentView(R.layout.about_us);
            close_popup=(ImageView)dialog.findViewById(R.id.close_popup);

            close_popup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
            return true;
        }

        if(id==R.id.action_rateUs){
            try{
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.netflix.mediaclient"));
                startActivity(intent);

            }catch (ActivityNotFoundException e){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.netflix.mediaclient"));
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
