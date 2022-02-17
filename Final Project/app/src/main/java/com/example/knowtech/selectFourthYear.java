package com.example.knowtech;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class selectFourthYear extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_fourth_year, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CardView RoomELEC4 = view.findViewById(R.id.RoomELEC4_Card);
        CardView RoomELEC5 = view.findViewById(R.id.RoomELEC5_Card);
        CardView RoomSDF105 = view.findViewById(R.id.RoomSDF105_Card);
        CardView RoomHCI102 = view.findViewById(R.id.RoomHCI102_Card);

        RoomELEC4.setOnClickListener(new selectFourthYear.Clik());
        RoomELEC5.setOnClickListener(new selectFourthYear.Clik());
        RoomSDF105.setOnClickListener(new selectFourthYear.Clik());
        RoomHCI102.setOnClickListener(new selectFourthYear.Clik());
    }

    public class Clik implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent i;

            switch (v.getId()) {
                case R.id.RoomELEC4_Card:
                    i = new Intent(v.getContext(), RoomELEC4.class);
                    startActivity(i);
                    break;
                case R.id.RoomELEC5_Card:
                    i = new Intent(v.getContext(), RoomELEC5.class);
                    startActivity(i);
                    break;
                case R.id.RoomSDF105_Card:
                    i = new Intent(v.getContext(), RoomSDF105.class);
                    startActivity(i);
                    break;
                case R.id.RoomHCI102_Card:
                    i = new Intent(v.getContext(), RoomHCI102.class);
                    startActivity(i);
                    break;
            }
        }
    }
}