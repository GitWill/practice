package com.example.nerd.midtownmma;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by nerd on 7/16/2017.
 */

public class SecondFragment extends Fragment {
    private ImageView eventImg;
    private TextView venuDeets;
    private TextView ticketDeets;
    private TextView outsideDeets;
    private TextView disclaimerDeets;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);

        eventImg = (ImageView) view.findViewById(R.id.imageViewEvent);
        ticketDeets = (TextView) view.findViewById(R.id.textViewTicketDeets);
        outsideDeets = (TextView) view.findViewById(R.id.textViewOutsideDeets);
        venuDeets = (TextView) view.findViewById(R.id.textViewVenueDeets);
        disclaimerDeets = (TextView) view.findViewById(R.id.textViewDisclaimerDeets);
        eventImg.setImageResource(R.drawable.main);
        return view;
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

    public void setInfo(int buttonID){                 //this is only called for small screen, or from the second activity
        switch (buttonID) {
            case R.id.mainButton:
                eventImg.setImageResource(R.drawable.main);
                venuDeets.setText(R.string.main_venu_deets);
                ticketDeets.setText(R.string.main_ticket_deets);
                outsideDeets.setText(R.string.main_outside_deets);
                disclaimerDeets.setText(R.string.disclaimer_deets);
                break;
            case R.id.coMainButton:
                eventImg.setImageResource(R.drawable.comain);
                venuDeets.setText(R.string.co_main_venu_deets);
                ticketDeets.setText(R.string.co_main_ticket_deets);
                outsideDeets.setText(R.string.co_main_outside_deets);
                disclaimerDeets.setText(R.string.disclaimer_deets);
                break;
            case R.id.logoButton:
                eventImg.setImageResource(R.drawable.logo);
                venuDeets.setText(R.string.logo_venu_deets);
                ticketDeets.setText(R.string.logo_ticket_deets);
                outsideDeets.setText(R.string.logo_outside_deets);
                disclaimerDeets.setText(R.string.disclaimer_deets);
                break;
            case R.id.boothButton:
                eventImg.setImageResource(R.drawable.booth);
                venuDeets.setText(R.string.booth_venu_deets);
                ticketDeets.setText(R.string.booth_ticket_deets);
                outsideDeets.setText(R.string.booth_outside_deets);
                disclaimerDeets.setText(R.string.bring_booth_deets);//else if the booth button was selected
                break;


        }/*
        if(buttonID == R.id.mainButton){                            //if the main event button was selected
            eventImg.setImageResource(R.drawable.main);
            venuDeets.setText(R.string.main_venu_deets);
            ticketDeets.setText(R.string.main_ticket_deets);
            outsideDeets.setText(R.string.main_outside_deets);
            disclaimerDeets.setText(R.string.disclaimer_deets);
        }else if (buttonID == R.id.coMainButton){                   //else if the co-main event button was selected
            eventImg.setImageResource(R.drawable.comain);
            venuDeets.setText(R.string.co_main_venu_deets);
            ticketDeets.setText(R.string.co_main_ticket_deets);
            outsideDeets.setText(R.string.co_main_outside_deets);
            disclaimerDeets.setText(R.string.disclaimer_deets);
        }else if (buttonID == R.id.logoButton){                     //else if the logo button was selected
            eventImg.setImageResource(R.drawable.logo);
            venuDeets.setText(R.string.logo_venu_deets);
            ticketDeets.setText(R.string.logo_ticket_deets);
            outsideDeets.setText(R.string.logo_outside_deets);
            disclaimerDeets.setText(R.string.disclaimer_deets);
        }else if (buttonID == R.id.boothButton){
            eventImg.setImageResource(R.drawable.booth);
            venuDeets.setText(R.string.booth_venu_deets);
            ticketDeets.setText(R.string.booth_ticket_deets);
            outsideDeets.setText(R.string.booth_outside_deets);
            disclaimerDeets.setText(R.string.bring_booth_deets);//else if the booth button was selected

        }*/
    }
}