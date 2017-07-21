package com.example.nerd.midtownmma;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by nerd on 7/16/2017.
 */

public class MainFragment extends Fragment implements View.OnClickListener {

    boolean twoPaneLayout;                      //this will tell us the size of the screen
    private TextView mainEventPriceTextView;    //get references to my first frag UI elements
    private TextView coMainPriceTextView;
    private TextView logoPriceTextView;
    private TextView boothPriceTextView;
    private Button mainButton;
    private Button coMainButton;
    private Button logoButton;
    private Button boothButton;
    private Intent intent;                      //the intent is for single pane screens, passes info between activities
    MainActivity mainActivity;                  //get reference to the main activity so we can call its methods
    private int lastButtonClicked;              //this will hold the id of the last package button clicked for state persistence
    private String savedRadioButtonText;        //this will hold the text value of the last radio button clicked for state persistence
    private RadioGroup radioGroup;              //get a reference to the seasons radiogroup

    public int getLastPkgBtn(){                 //returns last package button selected for state persistence
        return lastButtonClicked;
    }

    public String getSavedRadioButtonText(){    //returns text of last radio button clicked for state persistence
        return savedRadioButtonText;
    }

    public void setLastPkgBtn(int lastClicked){ //called from main activity for state persistence
        lastButtonClicked = lastClicked;        //save the value for state persistence
        if(twoPaneLayout){                      //if there is room on the screen, show all three fragments
            mainActivity.setFragments(lastButtonClicked);
        }
    }

    public void setSelectedPrices(String season){                       //this method sets the price of each package
        if(season.equals("Winter")){                                    //according to which radio button is clicked
            mainEventPriceTextView.setText(R.string.main_price_winter);
            coMainPriceTextView.setText(R.string.co_main_price_winter);
            logoPriceTextView.setText(R.string.logo_price_winter);
            boothPriceTextView.setText(R.string.booth_price_winter);
        }else if(season.equals("Summer")){
            mainEventPriceTextView.setText(R.string.main_price_summer);
            coMainPriceTextView.setText(R.string.co_main_price_summer);
            logoPriceTextView.setText(R.string.logo_price_summer);
            boothPriceTextView.setText(R.string.booth_price_summer);
        }else if(season.equals("Spring")){
            mainEventPriceTextView.setText(R.string.main_price_spring);
            coMainPriceTextView.setText(R.string.co_main_price_spring);
            logoPriceTextView.setText(R.string.logo_price_spring);
            boothPriceTextView.setText(R.string.booth_price_spring);
        }else if(season.equals("Fall")){
            mainEventPriceTextView.setText(R.string.main_price_fall);
            coMainPriceTextView.setText(R.string.co_main_price_fall);
            logoPriceTextView.setText(R.string.logo_price_fall);
            boothPriceTextView.setText(R.string.booth_price_fall);
        }
    }

    public void saveIntentStartActivity(){                          //for single pane layouts
        intent = new Intent(getActivity(), SecondActivity.class);   //make intent for second activity
        intent.putExtra("buttonID", lastButtonClicked);             //include the package the user has selected
        startActivity(intent);                                      //start the second activity
    }

    public void setSavedRadioButton(String radioText){              //used to update system
        savedRadioButtonText = radioText;                           //according to saved state
        setSelectedPrices(savedRadioButtonText);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Add your menu entries here
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onClick(View v) {
        lastButtonClicked = v.getId();
        if(lastButtonClicked == R.id.mainButton){                       //if the user clickes the main event button
            if(twoPaneLayout){                                  //and it's a big screen
                mainActivity.setFragments(lastButtonClicked);
            }else{
                saveIntentStartActivity();
            }
        }else if(lastButtonClicked == R.id.coMainButton){
            if(twoPaneLayout){                                  //and it's a big screen
                mainActivity.setFragments(lastButtonClicked);
            }else{
                saveIntentStartActivity();
            }
        }else if(lastButtonClicked == R.id.logoButton){
            if(twoPaneLayout){                                  //and it's a big screen
                mainActivity.setFragments(lastButtonClicked);
            }else{
                saveIntentStartActivity();
            }
        }else if(lastButtonClicked == R.id.boothButton){
            if(twoPaneLayout){                                  //and it's a big screen
                mainActivity.setFragments(lastButtonClicked);
            }else{
                saveIntentStartActivity();
            }
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inflate the view for this fragment
        final  View view = inflater.inflate(R.layout.fragment_main, container, false);       //inflate the first fragments view

        mainActivity = (MainActivity)getActivity();

        radioGroup = (RadioGroup)view.findViewById(R.id.radioGroup);                       //assign my variables to actual UI elements
        mainButton = (Button)view.findViewById(R.id.mainButton);
        coMainButton = (Button)view.findViewById(R.id.coMainButton);
        logoButton = (Button)view.findViewById(R.id.logoButton);
        boothButton = (Button)view.findViewById(R.id.boothButton);
        mainButton.setOnClickListener(this);                            //set the listeners for our package buttons in this fragment
        coMainButton.setOnClickListener(this);
        logoButton.setOnClickListener(this);
        boothButton.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(
            new RadioGroup.OnCheckedChangeListener()
            {
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    // checkedId is the RadioButton selected
                    RadioButton rb=(RadioButton)mainActivity.findViewById(checkedId);
                    Toast.makeText(mainActivity, rb.getText(), Toast.LENGTH_SHORT).show();
                    savedRadioButtonText = ((RadioButton) mainActivity.findViewById(checkedId)).getText().toString();
                    setSelectedPrices(savedRadioButtonText);
                }
            });



        mainEventPriceTextView = (TextView) view.findViewById(R.id.mainEventCostTextView);
        coMainPriceTextView = (TextView) view.findViewById(R.id.coMainEventCostTextView);
        logoPriceTextView = (TextView) view.findViewById(R.id.logoCostTextView);
        boothPriceTextView = (TextView) view.findViewById(R.id.boothCostTextView);
        twoPaneLayout = view.findViewById(R.id.fragment_Second) != null;

        return view;
    }
}

