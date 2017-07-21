package com.example.nerd.midtownmma;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by nerd on 7/18/2017.
 */

public class ThirdFragment extends Fragment {
    private ImageView left;
    private ImageView middle;
    private ImageView right;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_third, container, false);

        left = (ImageView) view.findViewById(R.id.imageViewLeft);
        right = (ImageView) view.findViewById(R.id.imageViewRight);
        middle = (ImageView) view.findViewById(R.id.imageViewMiddle);
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

    public void setImages(int pkg){
        switch (pkg){
            case R.id.mainButton:
                //set imgs for main event pkg
                left.setImageResource(R.drawable.mainleft);
                middle.setImageResource(R.drawable.mainmiddle);
                right.setImageResource(R.drawable.mainright);
                break;
            case R.id.coMainButton:
                //set imgs for co-main event pkg
                left.setImageResource(R.drawable.mainleft);     //main and co-main show same imgs
                middle.setImageResource(R.drawable.mainmiddle);
                right.setImageResource(R.drawable.mainright);
                break;
            case R.id.logoButton:
                //set imgs for logo pkg
                left.setImageResource(R.drawable.logoleft);
                middle.setImageResource(R.drawable.logomiddle);
                right.setImageResource(R.drawable.logoright);
                break;
            case R.id.boothButton:
                //set imgs for main event pkg
                left.setImageResource(R.drawable.boothleft);
                middle.setImageResource(R.drawable.boothmiddle);
                right.setImageResource(R.drawable.boothright);
                break;
        }
    }

}