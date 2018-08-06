package com.worldmer.fragmentlifecycle;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, FragResponse {

    Button btnFragA, btnFragB, btnFragC;
    String TAG = "LifeCycle";
    FragA fragA;
    FragB fragB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "ACT onCreate()");
        btnFragA = (Button) findViewById(R.id.btnfragA);
        btnFragB = (Button) findViewById(R.id.btnfragB);
        btnFragC = (Button) findViewById(R.id.btnfragC);
        btnFragA.setOnClickListener(this);
        btnFragB.setOnClickListener(this);
        btnFragC.setOnClickListener(this);
        fragA = new FragA();
        fragB = new FragB();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ACT onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ACT onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ACT onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ACT onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "ACT onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "ACT onDestroy()");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG, "ACT onBackPressed()");
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "ACT onClick()");
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
    }

    public void addFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(android.R.id.content, fragment);
        transaction.commit();
    }

    public void removeFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }

    @Override
    public void onFragClick(View view) {
        Log.d(TAG, "ACT onFragClick()");
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
