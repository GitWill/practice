package com.example.nerd.piggame;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class FirstActivity extends AppCompatActivity {

    public void newPigBig(String first, String second){     //this is called when the screen is big enough for both fragments
        SecondFragment secondFragment =                                //it creates an instance of the second fragment in the first activity
                (SecondFragment) getFragmentManager().findFragmentById(R.id.second_fragment);
        secondFragment.setContext(this);
        secondFragment.setNames(first,second);
        secondFragment.clearData();
        //gpf.startGame();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set the view layout for the activity using XML
        setContentView(R.layout.first_activity);
    }


}




