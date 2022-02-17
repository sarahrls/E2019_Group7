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

public class selectThirdYear extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_third_year, container, false);
    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CardView RoomIAS101 = view.findViewById(R.id.RoomIAS101_Card);
        CardView RoomSE101 = view.findViewById(R.id.RoomSE101_Card);
        CardView RoomELEC1 = view.findViewById(R.id.RoomELEC1_Card);
        CardView RoomCC107 = view.findViewById(R.id.RoomCC107_Card);
        CardView RoomIT101 = view.findViewById(R.id.RoomIT101_Card);
        CardView RoomELEC2 = view.findViewById(R.id.RoomELEC2_Card);
        CardView RoomSE102 = view.findViewById(R.id.RoomSE102_Card);
        CardView RoomELEC3 = view.findViewById(R.id.RoomELEC3_Card);
        CardView RoomCC108 = view.findViewById(R.id.RoomCC108_Card);
        CardView RoomOS102 = view.findViewById(R.id.RoomOS102_Card);
        CardView RoomIT102 = view.findViewById(R.id.RoomIT102_Card);

        RoomIAS101.setOnClickListener(new selectThirdYear.Clik());
        RoomSE101.setOnClickListener(new selectThirdYear.Clik());
        RoomELEC1.setOnClickListener(new selectThirdYear.Clik());
        RoomCC107.setOnClickListener(new selectThirdYear.Clik());
        RoomIT101.setOnClickListener(new selectThirdYear.Clik());
        RoomELEC2.setOnClickListener(new selectThirdYear.Clik());
        RoomSE102.setOnClickListener(new selectThirdYear.Clik());
        RoomELEC3.setOnClickListener(new selectThirdYear.Clik());
        RoomCC108.setOnClickListener(new selectThirdYear.Clik());
        RoomOS102.setOnClickListener(new selectThirdYear.Clik());
        RoomIT102.setOnClickListener(new selectThirdYear.Clik());
    }

    public class Clik implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent i;

            switch (v.getId()) {
                case R.id.RoomIAS101_Card:
                    i = new Intent(v.getContext(), RoomIAS101.class);
                    startActivity(i);
                    break;
                case R.id.RoomSE101_Card:
                    i = new Intent(v.getContext(), RoomSE101.class);
                    startActivity(i);
                    break;
                case R.id.RoomELEC1_Card:
                    i = new Intent(v.getContext(), RoomELEC1.class);
                    startActivity(i);
                    break;
                case R.id.RoomCC107_Card:
                    i = new Intent(v.getContext(), RoomCC107.class);
                    startActivity(i);
                    break;
                case R.id.RoomIT101_Card:
                    i = new Intent(v.getContext(), RoomIT101.class);
                    startActivity(i);
                    break;
                case R.id.RoomELEC2_Card:
                    i = new Intent(v.getContext(), RoomELEC2.class);
                    startActivity(i);
                    break;
                case R.id.RoomSE102_Card:
                    i = new Intent(v.getContext(), RoomSE102.class);
                    startActivity(i);
                    break;
                case R.id.RoomELEC3_Card:
                    i = new Intent(v.getContext(), RoomELEC3.class);
                    startActivity(i);
                    break;
                case R.id.RoomCC108_Card:
                    i = new Intent(v.getContext(), RoomCC108.class);
                    startActivity(i);
                    break;
                case R.id.RoomOS102_Card:
                    i = new Intent(v.getContext(), RoomOS102.class);
                    startActivity(i);
                    break;
                case R.id.RoomIT102_Card:
                    i = new Intent(v.getContext(), RoomIT102.class);
                    startActivity(i);
                    break;
            }
        }
    }
}

