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


public class selectFirstYear extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_select_first_year, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CardView RoomCC101 = view.findViewById(R.id.RoomCC101_Card);
        CardView RoomCC102 = view.findViewById(R.id.RoomCC102_Card);
        CardView RoomDS101 = view.findViewById(R.id.RoomDS101_Card);
        CardView RoomAL101 = view.findViewById(R.id.RoomAL101_Card);

        CardView RoomCC103 = view.findViewById(R.id.RoomCC103_Card);
        CardView RoomCC104 = view.findViewById(R.id.RoomCC104_Card);
        CardView RoomCC105 = view.findViewById(R.id.RoomCC105_Card);
        CardView RoomDS102 = view.findViewById(R.id.RoomDS102_Card);


        RoomCC101.setOnClickListener(new selectFirstYear.Clik());
        RoomCC102.setOnClickListener(new selectFirstYear.Clik());
        RoomDS101.setOnClickListener(new selectFirstYear.Clik());
        RoomAL101.setOnClickListener(new selectFirstYear.Clik());

        RoomCC103.setOnClickListener(new selectFirstYear.Clik());
        RoomCC104.setOnClickListener(new selectFirstYear.Clik());
        RoomCC105.setOnClickListener(new selectFirstYear.Clik());
        RoomDS102.setOnClickListener(new selectFirstYear.Clik());
    }

    public class Clik implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent i;

            switch (v.getId()) {
                case R.id.RoomCC101_Card:
                    i = new Intent(v.getContext(), RoomCC101.class);
                    startActivity(i);
                    break;
                case R.id.RoomCC102_Card:
                    i = new Intent(v.getContext(), RoomCC102.class);
                    startActivity(i);
                    break;
                case R.id.RoomDS101_Card:
                    i = new Intent(v.getContext(), RoomDS101.class);
                    startActivity(i);
                    break;
                case R.id.RoomAL101_Card:
                    i = new Intent(v.getContext(), RoomAL101.class);
                    startActivity(i);
                    break;
                case R.id.RoomCC103_Card:
                    i = new Intent(v.getContext(), RoomCC103.class);
                    startActivity(i);
                    break;
                case R.id.RoomCC104_Card:
                    i = new Intent(v.getContext(), RoomCC104.class);
                    startActivity(i);
                    break;
                case R.id.RoomCC105_Card:
                    i = new Intent(v.getContext(), RoomCC105.class);
                    startActivity(i);
                    break;
                case R.id.RoomDS102_Card:
                    i = new Intent(v.getContext(), RoomDS102.class);
                    startActivity(i);
                    break;
            }
        }
    }
}