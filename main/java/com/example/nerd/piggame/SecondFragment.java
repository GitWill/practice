package com.example.nerd.piggame;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by nerd on 7/10/2017.
 */

public class SecondFragment extends Fragment implements View.OnClickListener {
    public static final String WILLS = "willsComments";
    TextView Player1Name;
    TextView Player2Name;
    String p1n;
    String p2n;
    public Activity act;

    public void setNames(String playerOneName, String playerTwoName){//NEW
        act = getActivity();
        p1n = playerOneName;
        p2n = playerTwoName;
        Player1Name = (TextView) act.findViewById(R.id.playerOneTextView);
        Player2Name = (TextView) act.findViewById(R.id.playerTwoTextView);
        Player1Name.setText(p1n);
        Player2Name.setText(p2n);
        //NEW PUT THEM INTO THE TEXT VIEW
    }
    Activity activity = getActivity();
    PigGame myGame = new PigGame(activity, p1n,p2n);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.second_fragment, container, false);

        Button rollButton = (Button)view.findViewById(R.id.rollButton);
        rollButton.setOnClickListener(this);  // this class implements the listener
        Button endButton = (Button)view.findViewById(R.id.endButton);
        endButton.setOnClickListener(this);  // this class implements the listener
        // Log.d(WILLS, "in oncreatview second fragment");

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.rollButton){
            Toast.makeText(act, " roll button clicked", Toast.LENGTH_SHORT).show();
            Toast.makeText(act, " end button clicked", Toast.LENGTH_SHORT).show();
        }
    }
}
