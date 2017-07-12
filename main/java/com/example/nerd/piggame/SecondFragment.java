package com.example.nerd.piggame;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by nerd on 7/10/2017.
 */

public class SecondFragment extends Fragment {
    public static final String WILLS = "willsComments";
    TextView Player1Name;
    TextView Player2Name;
    String p1n;
    String p2n;

    public void setNames(String playerOneName, String playerTwoName){//NEW
        Activity activity = getActivity();
        p1n = playerOneName;
        p2n = playerTwoName;
        Player1Name = (TextView) activity.findViewById(R.id.playerOneTextView);
        Player2Name = (TextView) activity.findViewById(R.id.playerTwoTextView);
        Player1Name.setText(p1n);
        Player2Name.setText(p2n);
        //NEW PUT THEM INTO THE TEXT VIEW
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.second_fragment, container, false);

        Log.d(WILLS, "in oncreatview asdfgsadfgserfgeasecond fragment");

        return view;
    }





}
