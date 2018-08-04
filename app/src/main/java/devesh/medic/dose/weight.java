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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class weight extends Activity {

    public String weight;
    public String ad_dose;
    public String ans;
    public String result_pg;


    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.weight);
        this.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#E1BEE7")));


        MobileAds.initialize(this, getString(R.string.AdMod_app_id));
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mInterstitialAd = new InterstitialAd(this);

        mInterstitialAd.setAdUnitId(getString(R.string.Ad_int_id));  
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
                //       .addTestDevice("YOUR_DEVICE_HASH")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }


    public void reset(View v) {
        final EditText age_val = (EditText) findViewById(R.id.editText1);
        final EditText ad_val = (EditText) findViewById(R.id.editText2);
        final TextView tx = (TextView) findViewById(R.id.textView6);
        age_val.setText("0");
        ad_val.setText("0");
        tx.setText("");

    }

    public void age_c(View view) {

        Intent age = new Intent(this, age.class);
        startActivity(age);
        finish();
    }

    public void kg() {
        final TextView tx = (TextView) findViewById(R.id.textView6);
        final EditText age_val = (EditText) findViewById(R.id.editText1);
        weight = age_val.getText().toString();
        final EditText ad_val = (EditText) findViewById(R.id.editText2);
        ad_dose = ad_val.getText().toString();
        double num;
        double weight1 = Double.parseDouble(weight);

        double de;
        double ad_dose1 = Double.parseDouble(ad_dose);

        num = weight1 / 70;
        de = num * ad_dose1;

        ans = String.valueOf(de);

        setContentView(R.layout.result_w);

        result_pg = "1";
        TextView result = (TextView) findViewById(R.id.textView17);
        TextView r_weight = (TextView) findViewById(R.id.textView16);
        r_weight.setText("Child of weight " + weight);
        result.setText(ans);

        // tx.setText("Accurate Dosage is " + ans);

    }

    public void pound() {
        final TextView tx = (TextView) findViewById(R.id.textView6);
        final EditText age_val = (EditText) findViewById(R.id.editText1);
        weight = age_val.getText().toString();
        final EditText ad_val = (EditText) findViewById(R.id.editText2);
        ad_dose = ad_val.getText().toString();
        double num;
        double pound1 = Double.parseDouble(weight);
        double de;
        double ad_dose1 = Double.parseDouble(ad_dose);

        num = pound1 / 150;
        de = num * ad_dose1;

        ans = String.valueOf(de);

        setContentView(R.layout.result_w);

        result_pg = "1";
        TextView result = (TextView) findViewById(R.id.textView17);
        TextView r_weight = (TextView) findViewById(R.id.textView16);
        r_weight.setText("Child of weight " + weight);
        result.setText(ans);

        // tx.setText("Accurate Dosage is " + ans);

    }

    public void calc_p(View v) {
        RadioButton but = (RadioButton) findViewById(R.id.radio0);
        RadioButton but1 = (RadioButton) findViewById(R.id.radio1);

        if (but.isChecked()) {
            kg();
        }
        if (but1.isChecked()) {
            pound();
        }

    }

    public void closex(View v) {
        result_pg = "0";
        setContentView(R.layout.weight);

    }

    public void closebt(View v) {
        result_pg = "0";
        setContentView(R.layout.weight);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //    Inflate the menu items for use in the action bar
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

  /*          case R.id.search:
                Intent abc = new Intent(this, drug_search.class);
                startActivity(abc);
                break;
*/
            default:
                break;
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        if (result_pg == "1") {
            result_pg = "0";
            setContentView(R.layout.weight);
        } else {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                finish();
            }
        }

<<<<<<< HEAD
    }
}
=======
}
}
>>>>>>> e7a8b0ea3bf368e63b499a4621120c95feac893e
