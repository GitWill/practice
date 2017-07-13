package com.example.nerd.piggame;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by nerd on 7/10/2017.
 */

public class FirstActivity extends AppCompatActivity {

    public void newPigBig(String first, String second){     //this is called when the screen is big enough for both fragments
        SecondFragment gpf =                                //it creates an instance of the second fragment in the first activity
                (SecondFragment) getFragmentManager().findFragmentById(R.id.second_fragment);
        gpf.setContext(this);
        gpf.setNames(first,second);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set the view layout for the activity using XML
        setContentView(R.layout.first_activity);
    }


}




