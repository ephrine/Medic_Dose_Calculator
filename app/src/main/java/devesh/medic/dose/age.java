package devesh.medic.dose;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class age extends Activity {

    public String age;
    public String ad_dose;
    public String ans;
    public String formula;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.yf);
        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#E1BEE7")));

        WebView myWebView = (WebView) findViewById(R.id.webView1);
         myWebView.loadUrl("https://sites.google.com/site/medicdosecalc/tracker");
        myWebView = (WebView) findViewById(R.id.webView1);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        // AdMob---------------------------------------------------------------------------------


      //   Banner ad

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this); // interstitial ad

     //   mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        // // sample
        // test
        // AD

        mInterstitialAd.setAdUnitId("ca-app-pub-6702661245453687/9040173059"); // WARNING
        // !!!!!->
        // My
        // OWN
        // f**kin
        // AD
        // id

        requestNewInterstitial();

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                finish();
            }
        });

    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                //.addTestDevice("YOUR_DEVICE_HASH")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }


    // Google Analytics code
    // -----------------------------------------------------------------------------------



    // My app main
    // Code-----------------------------------------------------------------------------------
    public void reset(View v) {
        final EditText age_val = (EditText) findViewById(R.id.editText1);
        final EditText ad_val = (EditText) findViewById(R.id.editText2);
        final TextView tx = (TextView) findViewById(R.id.textView5);
        age_val.setText("0");
        ad_val.setText("0");
        tx.setText("");

    }

    public void wei(View view) {
        Intent we = new Intent(this, weight.class);
        startActivity(we);
        finish();

    }

    public void young() {
        final TextView tx = (TextView) findViewById(R.id.textView5);
        final EditText age_val = (EditText) findViewById(R.id.editText1);
        age = age_val.getText().toString();
        final EditText ad_val = (EditText) findViewById(R.id.editText2);
        ad_dose = ad_val.getText().toString();
        double num;
        double age1 = Double.parseDouble(age);

        double de;
        double ad_dose1 = Double.parseDouble(ad_dose);

        double answ;
        num = age1 + 12;
        de = age1 / num;
        answ = de * ad_dose1;

        ans = String.valueOf(answ);

        tx.setText("Accurate Dosage is " + ans);

    }

    public void dilling() {
        final TextView tx = (TextView) findViewById(R.id.textView5);
        final EditText age_val = (EditText) findViewById(R.id.editText1);
        age = age_val.getText().toString();
        final EditText ad_val = (EditText) findViewById(R.id.editText2);
        ad_dose = ad_val.getText().toString();
        double num;
        double age1 = Double.parseDouble(age);
        double de;
        double ad_dose1 = Double.parseDouble(ad_dose);

        num = ad_dose1 / 20;
        de = age1 * num;

        ans = String.valueOf(de);

        tx.setText("Accurate Dosage is " + ans);

    }

    public void cowling() {
        final TextView tx = (TextView) findViewById(R.id.textView5);
        final EditText age_val = (EditText) findViewById(R.id.editText1);
        age = age_val.getText().toString();
        final EditText ad_val = (EditText) findViewById(R.id.editText2);
        ad_dose = ad_val.getText().toString();
        double num;
        double age1 = Double.parseDouble(age);
        double de;
        double ad_dose1 = Double.parseDouble(ad_dose);
        double answ;

        num = age1 + 1;
        de = num / 24;
        answ = de * ad_dose1;

        ans = String.valueOf(answ);

        tx.setText("Accurate Dosage is " + ans);

    }

    public void fried() {

        final TextView tx = (TextView) findViewById(R.id.textView5);
        final EditText age_val = (EditText) findViewById(R.id.editText1);
        age = age_val.getText().toString();
        final EditText ad_val = (EditText) findViewById(R.id.editText2);
        ad_dose = ad_val.getText().toString();
        double num;
        double age1 = Double.parseDouble(age);
        double de;
        double ad_dose1 = Double.parseDouble(ad_dose);

        num = age1 / 150;
        de = num * ad_dose1;

        ans = String.valueOf(de);

        tx.setText("Accurate Dosage is " + ans);

    }

    public void bastedo() {
        final TextView tx = (TextView) findViewById(R.id.textView5);
        final EditText age_val = (EditText) findViewById(R.id.editText1);
        age = age_val.getText().toString();
        final EditText ad_val = (EditText) findViewById(R.id.editText2);
        ad_dose = ad_val.getText().toString();
        double num;
        double age1 = Double.parseDouble(age);
        double de;
        double ad_dose1 = Double.parseDouble(ad_dose);
        double answ;

        num = age1 + 3;
        de = num / 30;
        answ = de * ad_dose1;

        ans = String.valueOf(answ);

        tx.setText("Accurate Dosage is " + ans);
    }

    public void calc_age(View v) {
        RadioButton but = (RadioButton) findViewById(R.id.radio0);
        RadioButton but1 = (RadioButton) findViewById(R.id.radio1);
        RadioButton but2 = (RadioButton) findViewById(R.id.radio2);
        RadioButton but3 = (RadioButton) findViewById(R.id.radio3);
        RadioButton but4 = (RadioButton) findViewById(R.id.radio4);
        final EditText age_val = (EditText) findViewById(R.id.editText1);

        if (but.isChecked()) {

            young();
        }
        if (but1.isChecked()) {
            dilling();
        }
        if (but2.isChecked()) {
            cowling();
        }
        if (but3.isChecked()) {
            fried();
        }
        if (but4.isChecked()) {
            bastedo();
        } else {

        }

    }

    public void fred(View view) {
        TextView child = (TextView) findViewById(R.id.textView1);
        child.setText("Child Age(Months):");
        TextView tx = (TextView) findViewById(R.id.textView5);
        tx.setText("");

    }

    public void yf(View view) {
        TextView child = (TextView) findViewById(R.id.textView1);
        child.setText("Child Age(years):");
        TextView tx = (TextView) findViewById(R.id.textView5);
        tx.setText("");

    }

    public void df(View view) {
        TextView child = (TextView) findViewById(R.id.textView1);
        child.setText("Child Age(years):");
        TextView tx = (TextView) findViewById(R.id.textView5);
        tx.setText("");

    }

    public void cf(View view) {
        TextView child = (TextView) findViewById(R.id.textView1);
        child.setText("Child Age(years):");
        TextView tx = (TextView) findViewById(R.id.textView5);
        tx.setText("");

    }

    public void bf(View view) {
        TextView child = (TextView) findViewById(R.id.textView1);
        child.setText("Child Age(years):");
        TextView tx = (TextView) findViewById(R.id.textView5);
        tx.setText("");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.about:
                Intent ab = new Intent(this, about.class);
                startActivity(ab);
                break;
            case R.id.search:
               Intent abc = new Intent(this, drug_search.class);
                startActivity(abc);
                break;
            case R.id.pro:
                Intent pro = new Intent(this, pro.class);
                startActivity(pro);
                break;

            default:
                break;
        }

        return true;
    }

    @Override
    public void onBackPressed() {

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            finish();
        }

    }
}