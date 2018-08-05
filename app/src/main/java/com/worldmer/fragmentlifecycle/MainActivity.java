package com.worldmer.fragmentlifecycle;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, FragResponse {

    Button btnFragA, btnFragB, btnFragC;
    String TAG = "ActivityLifeCycle";
    FragA fragA;
    FragB fragB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFragA = (Button) findViewById(R.id.btnfragA);
        btnFragB = (Button) findViewById(R.id.btnfragB);
        btnFragC = (Button) findViewById(R.id.btnfragC);
        btnFragA.setOnClickListener(this);
        btnFragB.setOnClickListener(this);
        btnFragC.setOnClickListener(this);
        fragA = new FragA();
        fragB = new FragB();
        Log.d(TAG, "ACT A onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ACT A onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ACT A onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ACT A onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ACT A onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "ACT A onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "ACT A onDestroy()");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG, "ACT A onBackPressed()");
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "ACT A onClick()");

        switch (view.getTag().toString()) {
            case "A":
                getSupportActionBar().setTitle("Fragment A");
                replaceFragment(fragA);
                break;
            case "B":
                getSupportActionBar().setTitle("Fragment B");
                replaceFragment(fragB);
                break;
            case "C":
                getSupportActionBar().setTitle("Activity");
                removeFragment(fragA);
                removeFragment(fragB);
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(android.R.id.content, fragment);
        transaction.commit();
        Log.d("TAG1122","Size : REPLACE " +manager.getFragments().size());
    }

    public void addFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, fragment);
        transaction.commit();
        Log.d("TAG1122","Size : ADD " +manager.getFragments().size());
    }

    public void removeFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
        Log.d("TAG1122","Size : REMOVE " +manager.getFragments().size());
    }

    public void getCount()
    {

    }
    @Override
    public void onfragClick(View view) {
        Log.d(TAG, "ACT A onClick()");

        switch (view.getTag().toString()) {
            case "A":
                getSupportActionBar().setTitle("Fragment A");
                replaceFragment(fragA);
                break;
            case "B":
                getSupportActionBar().setTitle("Fragment B");
                replaceFragment(fragB);
                break;
            case "C":
                getSupportActionBar().setTitle("Activity");
                removeFragment(fragA);
                removeFragment(fragB);
        }
    }

    @Override
    public void onfragBack(int responseCode) {

    }
}
