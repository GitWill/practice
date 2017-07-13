package com.example.nerd.piggame;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by nerd on 7/10/2017.
 */

public class SecondFragment extends Fragment implements View.OnClickListener {
    public static final String WILLS = "WILLS";

    private TextView p1NameTextView;       //display player ones score
    private TextView p2NameTextView;       //display player twos score
    private String p1NameString;           //used for toasting
    private String p2NameString;           //used for toasting
    private TextView p1ScoreTextView;       //display player twos score
    private TextView p2ScoreTextView;       //display player twos score
    private TextView whoTurn;       //displays whose turn it is
    private TextView turnPts;       //displays accumulated points for one turn
    private ImageView dieImg;       //displays image for die
    private int myRandom;           //for the dice roll
    private Context passed;         //holds the first acctivity's context
    //PigGame myGame;

    //public void startGame() {
    PigGame myGame = new PigGame(passed, p1NameString, p2NameString);//create a piggame object
    //}

    public void setContext(Context in){//first activities context
        passed = in;
    }

    public void setNames(String playerOneName, String playerTwoName){//set names
        if (playerOneName.equals("")){
            playerOneName = "Playa 1";
        }if (playerTwoName.equals("")){
            playerTwoName = "Playa 2";
        }
        p1NameString = playerOneName;
        p2NameString = playerTwoName;
        defineLocals();                     //this will get references to UI elements
    }


    public void defineLocals(){ //create references to the UI elements
        Activity activity = getActivity();
        p1NameTextView = (TextView) activity.findViewById(R.id.playerOneTextView);
        p2NameTextView = (TextView) activity.findViewById(R.id.playerTwoTextView);
        p1NameTextView.setText(p1NameString);
        p2NameTextView.setText(p2NameString);
        turnPts = (TextView) activity.findViewById(R.id.textView11);
        whoTurn = (TextView) activity.findViewById(R.id.textView9);
        p1NameTextView.setText(p1NameString);
        p2NameTextView.setText(p2NameString);
        p1ScoreTextView = (TextView) activity.findViewById(R.id.textView5);
        p2ScoreTextView = (TextView) activity.findViewById(R.id.textView6);
        dieImg =  (ImageView) activity.findViewById(R.id.imageView);
        updateUI();                                                     //show the new names
    }

    public void endTurn() {                         //handles the click listener for the end turn button
        myGame.endSingleTurn();                     //end the turn for the back end
        updateUI();                                 //update UI by backend info
        dieImg.setImageResource(R.drawable.blank);//display blank die
    }

    public void updateUI() {         //this function updates the ui elements

        if(PigPlayer.getIsTurn() == 1){
            turnPts.setText(String.valueOf(myGame.player1.getTurnPoints()));              //show player 2's single turn accumulated points
            whoTurn.setText(p1NameString + ", it is your turn");
        }else{
            turnPts.setText(String.valueOf(myGame.player2.getTurnPoints()));              //show player 2's single turn accumulated points
            whoTurn.setText(p2NameString + ", it is your turn");
        }
        p1ScoreTextView.setText(String.valueOf(myGame.player1.getTotScore()));          //show the players total scores
        p2ScoreTextView.setText(String.valueOf(myGame.player2.getTotScore()));
    }

    public void rollDie() {                         //handles the roll die button
        Random rand = new Random();                 // generate a random 1-6 for the die
        myRandom = rand.nextInt(6);                 // Gives n such that 0 <= n < 6
        myRandom = myRandom + 1;
        showDice(myRandom);                                //display the outcome of the roll in the UI
        myGame.handleRoll(myRandom);                       //handle the roll for the backend
        updateUI();                                 //show the roll outcome in the UI
    }

    public void showDice(int n) {//shows dice in UI
        if (n == 1) {
            dieImg.setImageResource(R.drawable.die1);//display die
        } else if (n == 2)
            dieImg.setImageResource(R.drawable.die2);//display die
        else if (n == 3)
            dieImg.setImageResource(R.drawable.die3);//display die
        else if (n == 4)
            dieImg.setImageResource(R.drawable.die4);//display die
        else if (n == 5)
            dieImg.setImageResource(R.drawable.die5);//display die
        else if (n == 6)
            dieImg.setImageResource(R.drawable.die6);//display die
        else if (n == 7)
            dieImg.setImageResource(R.drawable.die7);//display die
        else if (n == 8)
            dieImg.setImageResource(R.drawable.die8);//display die
        else if (n == 9)
            dieImg.setImageResource(R.drawable.die9);//display die
    }

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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public void onClick(View v) {           //handle the click listener
        if(v.getId() == R.id.rollButton){   //if the user clicked the roll die button
            rollDie();                      //handle their selection
        }else{                              //else they clicked the new game button
            endTurn();
        }
    }
}
