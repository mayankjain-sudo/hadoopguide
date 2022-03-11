package mayank.jain.hadoopguide.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Layout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ZoomControls;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import mayank.jain.hadoopguide.R;
import mayank.jain.hadoopguide.fragments.HadoopConfigurationFragment;
import mayank.jain.hadoopguide.fragments.HomeFragment;
import mayank.jain.hadoopguide.fragments.IntroductionFragment;
import mayank.jain.hadoopguide.fragments.JavaConfigurationFragment;
import mayank.jain.hadoopguide.fragments.MachineSetupFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, HomeFragment.OnFragmentInteractionListener,
        IntroductionFragment.OnFragmentInteractionListener,MachineSetupFragment.OnFragmentInteractionListener,
        HadoopConfigurationFragment.OnFragmentInteractionListener,JavaConfigurationFragment.OnFragmentInteractionListener {

    public static int navItemIndex = 0;
    // tags used to attach the fragments
    private static final String TAG_HOME = "home";
    private static final String TAG_INTRODUCTION = "introduction";
    private static final String TAG_MACHINESETUP = "machinesetup";
    private static final String TAG_JAVACONF = "javaconf";
    private static final String TAG_HADOOPCONF = "hadoopconf";

    public static String CURRENT_TAG = TAG_HOME;

    DrawerLayout drawer;

    // toolbar titles respected to selected nav menu item
    private String[] activityTitles;
    private Handler mHandler;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mHandler = new Handler();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
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
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    private void loadHomeFragment() {

        // set toolbar title
        setToolbarTitle();
        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }
        invalidateOptionsMenu();
    }

    private Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                // home
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                // photos
                IntroductionFragment introductionFragment = new IntroductionFragment();
                return introductionFragment;
            case 2:
                // movies fragment
                MachineSetupFragment machineSetupFragment = new MachineSetupFragment();
                return machineSetupFragment;
            case 3:
                // notifications fragment
                JavaConfigurationFragment javaConfigurationFragment = new JavaConfigurationFragment();
                return javaConfigurationFragment;

            case 4:
                // settings fragment
                HadoopConfigurationFragment hadoopConfigurationFragment = new HadoopConfigurationFragment();
                return hadoopConfigurationFragment;

            default:
                return new HomeFragment();
        }
    }

    private void setToolbarTitle() {
        getSupportActionBar().setTitle(activityTitles[navItemIndex]);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            //Replacing the main content with ContentFragment Which is our Inbox View;
            case R.id.nav_home:
                navItemIndex = 0;
                CURRENT_TAG = TAG_HOME;
                loadHomeFragment();
                break;
            case R.id.nav_introduction:
                navItemIndex = 1;
                CURRENT_TAG = TAG_INTRODUCTION;
                loadHomeFragment();
                break;
            case R.id.nav_machinesetup:
                navItemIndex = 2;
                CURRENT_TAG = TAG_MACHINESETUP;
                loadHomeFragment();
                break;
            case R.id.nav_javaconf:
                navItemIndex = 3;
                CURRENT_TAG = TAG_JAVACONF;
                loadHomeFragment();
                break;
            case R.id.nav_hadoopconf:
                navItemIndex = 4;
                CURRENT_TAG = TAG_HADOOPCONF;
                loadHomeFragment();
                break;
            case R.id.nav_aboutus:
                // launch new intent instead of loading fragment
                startActivity(new Intent(MainActivity.this, AboutUsActivity.class));
                drawer.closeDrawers();
                return true;
            default:
                navItemIndex = 0;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
