package com.example.nerd.piggame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    public static final String WILLS = "dEfAuLt";
    private PigGame myGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_activity);
        //Log.d(WILLS, "in second activity OnCreate");

        //get the names that the first fragment's button handler sent
        String p1n = getIntent().getStringExtra("p1Name");
        String p2n = getIntent().getStringExtra("p2Name");
        // The toast is just for testing
        //Toast.makeText(this, "SecondActivity: with " + p1n + "and " + p2n, Toast.LENGTH_SHORT).show();
        //myGame = new PigGame(this, p1n, p2n);

        // Send the message to the fragment
        SecondFragment gpf =
                (SecondFragment) getFragmentManager().findFragmentById(R.id.second_fragment);
        gpf.setNames(p1n,p2n);


    }
}









