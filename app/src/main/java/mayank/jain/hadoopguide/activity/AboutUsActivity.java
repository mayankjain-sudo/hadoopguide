package mayank.jain.hadoopguide.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import mayank.jain.hadoopguide.R;
import mayank.jain.hadoopguide.others.DataProvider;

public class AboutUsActivity extends AppCompatActivity {

    TextView textView;
    InterstitialAd mInterstitialAd;
    private AdView mAdView,mAdViewup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        textView = (TextView) findViewById(R.id.about_us);
        textView.setText(DataProvider.ABOUT_US);

        mAdView = (AdView) findViewById(R.id.adView);
        mAdViewup = (AdView) findViewById(R.id.adViewup);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdViewup.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));

        AdRequest adRequest1 = new AdRequest.Builder()
//               .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                // Check the LogCat to get your test device ID
//                .addTestDevice("D111024B336D512A1E53203F5C981C2E")
                .build();
        mInterstitialAd.loadAd(adRequest1);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }

    }
}
