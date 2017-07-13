package com.example.nerd.piggame;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by nerd on 7/10/2017.
 */

public class FirstActivity extends AppCompatActivity {
    public static final String WILLS = "willsComments";

    //private PigGame game;

    public Context getContext(){ return this; }

    public void newPigBig(String first, String second){
        SecondFragment gpf =
                (SecondFragment) getFragmentManager().findFragmentById(R.id.second_fragment);
        gpf.setNames(first,second);
    }

    //public PigGame getGame(){ return game; }

    //public void setGame(PigGame in){ this.game = in; }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.d(WILLS, "in oncreatview in second fragment");

        // set the view layout for the activity using XML
        setContentView(R.layout.first_activity);
    }


}




