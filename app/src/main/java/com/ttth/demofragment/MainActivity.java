package com.ttth.demofragment;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // tìm fragment hiện tại theo id
        Fragment fragmentCurrent = getSupportFragmentManager().findFragmentById(R.id.flFragment);
        if (fragmentCurrent == null){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.flFragment, new MainRvFragment());
            transaction.commit();
        }
    }
}

