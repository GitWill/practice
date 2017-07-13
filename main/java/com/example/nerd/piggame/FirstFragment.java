package com.example.nerd.piggame;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by nerd on 7/10/2017.
 */

public class FirstFragment extends Fragment  implements View.OnClickListener {

    //public static final String WILLS = "dEfAuLt";
    //private PigGame game;
    private boolean twoPaneLayout;

    private Context myContext;
    private EditText p1nEditText;
    private EditText p2nEditText;
    private FirstActivity firstActivity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inflate the view for this fragment
        View view = inflater.inflate(R.layout.first_fragment, container, false);

        //set this fragment to listen to the new game button
        Button newGameButton = (Button)view.findViewById(R.id.playButton);
        newGameButton.setOnClickListener(this);  // this class implements the listener
        //Log.d(WILLS, "in onActivityCreated in first frag");

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Log.d(WILLS, "in onActivityCreated in first frag");

        // Get a references from the host activity
        firstActivity = (FirstActivity)getActivity();
        p1nEditText = (EditText) firstActivity.findViewById(R.id.playerOneEditText);
        p2nEditText = (EditText) firstActivity.findViewById(R.id.playerTwoEditText);

        // Make a new game object, use saved state if it exists
        if(savedInstanceState != null) {
            // Restore saved state
            //rpsEditText.setText(humanHand.toString());
            //Hand computerHand = Hand.values()[savedInstanceState.getInt("computerHand", 0)];
            //game = new RpsGame(computerHand, humanHand);
        }
        //else {
            //myContext = firstActivity.getContext();
            //game = new PigGame(myContext,firstName,secondName);
        //}
        // Give the host activity a reference to the game object
        //firstActivity.setGame(game);

        // Check to see if FirstActivity has loaded a single or dual pane layout
        twoPaneLayout = firstActivity.findViewById(R.id.second_fragment) != null;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.playButton){                       //if the user clickes the new game button
            String p1Name = p1nEditText.getText().toString();   //display the players names
            String p2Name = p2nEditText.getText().toString();

            if(twoPaneLayout){                          //if the device has a screen
                firstActivity.newPigBig(p1Name,p2Name); //display both fragments in one activity
            }else{                                      //else create an intent to start a new activity for the second fragment
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                intent.putExtra("p1Name", p1Name);  // send state to 2nd activity
                intent.putExtra("p2Name", p2Name);  // send state to 2nd activity
                startActivity(intent);
            }
        }
    }
}





