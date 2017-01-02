package com.ttth.demofragment;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ttth.adapter.RVAdapter;
import com.ttth.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String FRAGMENT_FIRST = "fragment_first";
    private MainRvFragment mainRvFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
    }

    private void initFragment() {
        mainRvFragment = new MainRvFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.flFragment, mainRvFragment);
        transaction.commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        getSupportFragmentManager().putFragment(outState,FRAGMENT_FIRST, mainRvFragment);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        mainRvFragment = (MainRvFragment) getSupportFragmentManager().getFragment(savedInstanceState, FRAGMENT_FIRST);
    }
}

