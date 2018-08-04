package devesh.medic.dose;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by Devesh & Madhuri on 5/26/2015.
 */
public class pro extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.pro);
        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#E1BEE7")));


    }

    public void pro(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setData(Uri.parse("market://details?id=devesh.medic.plus")); //Google play store
        startActivity(intent);
    }

}
