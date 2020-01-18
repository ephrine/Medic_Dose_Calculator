package devesh.medic.dose;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
public class splashscreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.scr);
        ActionBar actionBar = getActionBar();
        actionBar.hide();

        AppCenter.start(getApplication(), getString(R.string.ms_appcenter_sec),
                Analytics.class, Crashes.class);


        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    sleep(1 * 1000);

                    // After 5 seconds redirect to another intent

                    Intent i = new Intent(getBaseContext(), age.class);
                    startActivity(i);

                    // Remove activity
                    finish();

                } catch (Exception e) {

                }
            }
        };

        // start thread
        background.start();

    }

}