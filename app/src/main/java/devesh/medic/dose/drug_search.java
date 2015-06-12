package devesh.medic.dose;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by Devesh on 5/19/2015.
 */
public class drug_search extends Activity {
    InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#E1BEE7")));
        setContentView(R.layout.drug_search);

        ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);
progress.setVisibility(View.INVISIBLE);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);

  //      mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");   //sample test AD

    //  mInterstitialAd.setAdUnitId("ca-app-pub-6702661245453687/9040173059");      // WARNING !!!!!-> My OWN f**kin AD id

    //    requestNewInterstitial();


     //   mInterstitialAd.setAdListener(new AdListener() {
     //       @Override
      //      public void onAdClosed() {
       //         requestNewInterstitial();
      //          finish();
      //     }
     //   }};


    }

  //  private void requestNewInterstitial() {
 //       AdRequest adRequest = new AdRequest.Builder()
                //       .addTestDevice("YOUR_DEVICE_HASH")
   //             .build();
//
   //     mInterstitialAd.loadAd(adRequest);
  //  }


    public void drug_search(View v) {

        EditText search = (EditText) findViewById(R.id.drug_search_box);
        String s = search.getText().toString();

        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.loadUrl("http://www.drugs.com/search.php?searchterm=" + s);
        ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);
        progress.setVisibility(View.VISIBLE);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebViewClient(new MyWebViewClient());

    }
    private class MyWebViewClient extends WebViewClient {

        ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {



            // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs

       //     if (mInterstitialAd.isLoaded()) {
        //        mInterstitialAd.show();
       //     } else {
       //     }
            Context context = getApplicationContext();
            CharSequence text = "Opening in web browser";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);
            progress.setVisibility(View.VISIBLE);

            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
            progress.setVisibility(View.INVISIBLE);

        }


    }



}
