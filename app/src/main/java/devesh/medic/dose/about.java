package devesh.medic.dose;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class about extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        getActionBar().setTitle("");
        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9C27B0")));


        	AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        	mAdView.loadAd(adRequest);

    }
public void visit(View v){
    Intent intent = new Intent(Intent.ACTION_VIEW);
    intent.setData(Uri.parse("http://ephrine.blogspot.com")); //Google play store
    startActivity(intent);


}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.about_share, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.fb_pg:

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.facebook.com/ephrinepharma")); //Google play store
                startActivity(intent);

                break;
            case R.id.google_plus_share:

                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("https://plus.google.com/+DeveshChaudhari95")); //Google play store
                startActivity(intent1);
                break;
            default:
                break;
        }

        return true;
    }


    public void update(View view) {


        Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setData(Uri.parse("market://details?id=devesh.medic.dose")); //Google play store
        startActivity(intent);

    }


}