package com.example.nerd.midtownmma;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private MainFragment mainFrag;                      //get a reference to the first fragment, so we can call its functions simply
    private SecondFragment secondFrag;                  //get a reference to the second fragment,...
    private ThirdFragment thirdFrag;                    //get a reference to the third fragment,...
    private SharedPreferences sharedPreferences;        //this will store our persistence variables

    public void setFragments(int buttonID){             //called from first frag if big screen, and from onResume in mainActivity
        secondFrag.setInfo(buttonID);                   //tell the second frag what to display
        thirdFrag.setImages(buttonID);                  //tell the third frag what to display
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sharedPreferences.edit();         //get a shared prefs editor which will enter the saved vals for state persistence
        editor.putString("saveRadio" , mainFrag.getSavedRadioButtonText()); //save the text of the last radio button clicked
        editor.putInt("saveBtnID" , mainFrag.getLastPkgBtn());              //save the id of the last button clicked
        editor.commit();                                                    //save the editor changes
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainFrag.setLastPkgBtn(sharedPreferences.getInt("saveBtnID",R.id.mainButton));          //retrieve saved values
        mainFrag.setSavedRadioButton(sharedPreferences.getString("saveRadio","Winter").toString());//call relevant methods to update UI etc

        if(secondFrag != null){                                                  //if there is a second (and third) frag
            setFragments(sharedPreferences.getInt("saveBtnID",R.id.mainButton)); //update them according to the saved package buttonID
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                                                     //set the content view for the layout
        mainFrag = (MainFragment) getFragmentManager().findFragmentById(R.id.fragment_main);        //get reference to each fragment
        secondFrag = (SecondFragment) getFragmentManager().findFragmentById(R.id.fragment_Second);  //even if they're null for a small screen
        thirdFrag = (ThirdFragment) getFragmentManager().findFragmentById(R.id.fragment_third);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);                    //define our sharedPrefs as the default on for this activity
    }
}