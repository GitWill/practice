package com.example.nerd.midtownmma;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by nerd on 7/16/2017.
 */

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        int buttonID = getIntent().getIntExtra("buttonID", -1);

        SecondFragment secondFragment =
                (SecondFragment) getFragmentManager().findFragmentById(R.id.second_fragment);
        secondFragment.setInfo(buttonID);


    }
}
