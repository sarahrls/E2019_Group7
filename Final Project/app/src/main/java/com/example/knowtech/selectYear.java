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


public class selectYear extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_select_year, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //First Year 1st Sem
        CardView RoomCC101 = view.findViewById(R.id.RoomCC101_Card);
        CardView RoomCC102 = view.findViewById(R.id.RoomCC102_Card);
        CardView RoomDS101 = view.findViewById(R.id.RoomDS101_Card);
        CardView RoomAL101 = view.findViewById(R.id.RoomAL101_Card);
        //First Year 2nd Sem
        CardView RoomCC103 = view.findViewById(R.id.RoomCC103_Card);
        CardView RoomCC104 = view.findViewById(R.id.RoomCC104_Card);
        CardView RoomCC105 = view.findViewById(R.id.RoomCC105_Card);
        CardView RoomDS102 = view.findViewById(R.id.RoomDS102_Card);
        //Second Year 1st Sem
        CardView RoomCC106 = view.findViewById(R.id.RoomCC106_Card);
        CardView RoomSDF104 = view.findViewById(R.id.RoomSDF104_Card);
        CardView RoomAL102 = view.findViewById(R.id.RoomAL102_Card);
        CardView RoomNC101 = view.findViewById(R.id.RoomNC101_Card);
        //Second Year 2nd Sem
        CardView RoomAR101 = view.findViewById(R.id.RoomAR101_Card);
        CardView RoomOS101 = view.findViewById(R.id.RoomOS101_Card);
        CardView RoomPL101 = view.findViewById(R.id.RoomPL101_Card);
        CardView RoomHCI101 = view.findViewById(R.id.RoomHCI101_Card);
        CardView RoomAL103 = view.findViewById(R.id.RoomAL103_Card);
        //Third Year 1st Sem
        CardView RoomIAS101 = view.findViewById(R.id.RoomIAS101_Card);
        CardView RoomSE101 = view.findViewById(R.id.RoomSE101_Card);
        CardView RoomELEC1 = view.findViewById(R.id.RoomELEC1_Card);
        CardView RoomCC107 = view.findViewById(R.id.RoomCC107_Card);
        CardView RoomIT101 = view.findViewById(R.id.RoomIT101_Card);
        //Third Year 2nd Sem
        CardView RoomELEC2 = view.findViewById(R.id.RoomELEC2_Card);
        CardView RoomSE102 = view.findViewById(R.id.RoomSE102_Card);
        CardView RoomELEC3 = view.findViewById(R.id.RoomELEC3_Card);
        CardView RoomCC108 = view.findViewById(R.id.RoomCC108_Card);
        CardView RoomOS102 = view.findViewById(R.id.RoomOS102_Card);
        CardView RoomIT102 = view.findViewById(R.id.RoomIT102_Card);
        //Fourth Year 1st Sem
        CardView RoomELEC4 = view.findViewById(R.id.RoomELEC4_Card);
        CardView RoomELEC5 = view.findViewById(R.id.RoomELEC5_Card);
        CardView RoomSDF105 = view.findViewById(R.id.RoomSDF105_Card);
        CardView RoomHCI102 = view.findViewById(R.id.RoomHCI102_Card);


        RoomCC101.setOnClickListener(new Clik());
        RoomCC102.setOnClickListener(new Clik());
        RoomDS101.setOnClickListener(new Clik());
        RoomAL101.setOnClickListener(new Clik());

        RoomCC103.setOnClickListener(new Clik());
        RoomCC104.setOnClickListener(new Clik());
        RoomCC105.setOnClickListener(new Clik());
        RoomDS102.setOnClickListener(new Clik());

        RoomCC106.setOnClickListener(new Clik());
        RoomSDF104.setOnClickListener(new Clik());
        RoomAL102.setOnClickListener(new Clik());
        RoomNC101.setOnClickListener(new Clik());

        RoomAR101.setOnClickListener(new Clik());
        RoomOS101.setOnClickListener(new Clik());
        RoomPL101.setOnClickListener(new Clik());
        RoomHCI101.setOnClickListener(new Clik());
        RoomAL103.setOnClickListener(new Clik());

        RoomIAS101.setOnClickListener(new Clik());
        RoomSE101.setOnClickListener(new Clik());
        RoomELEC1.setOnClickListener(new Clik());
        RoomCC107.setOnClickListener(new Clik());
        RoomIT101.setOnClickListener(new Clik());

        RoomELEC2.setOnClickListener(new Clik());
        RoomSE102.setOnClickListener(new Clik());
        RoomELEC3.setOnClickListener(new Clik());
        RoomCC108.setOnClickListener(new Clik());
        RoomOS102.setOnClickListener(new Clik());

        RoomELEC4.setOnClickListener(new Clik());
        RoomELEC5.setOnClickListener(new Clik());
        RoomSDF105.setOnClickListener(new Clik());
        RoomHCI102.setOnClickListener(new Clik());
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
                case R.id.RoomCC106_Card:
                    i = new Intent(v.getContext(), RoomCC106.class);
                    startActivity(i);
                    break;
                case R.id.RoomSDF104_Card:
                i = new Intent(v.getContext(), RoomSDF104.class);
                    startActivity(i);
                    break;
                case R.id.RoomAL102_Card:
                i = new Intent(v.getContext(), RoomAL102.class);
                    startActivity(i);
                    break;
                case R.id.RoomNC101_Card:
                i = new Intent(v.getContext(), RoomNC101.class);
                    startActivity(i);
                    break;
                case R.id.RoomAR101_Card:
                i = new Intent(v.getContext(), RoomAR101.class);
                    startActivity(i);
                    break;
                case R.id.RoomOS101_Card:
                i = new Intent(v.getContext(), RoomOS101.class);
                    startActivity(i);
                    break;
                case R.id.RoomPL101_Card:
                i = new Intent(v.getContext(), RoomPL101.class);
                    startActivity(i);
                    break;
                case R.id.RoomHCI101_Card:
                    i = new Intent(v.getContext(), RoomHCI101.class);
                    startActivity(i);
                    break;
                case R.id.RoomAL103_Card:_Card:
                    i = new Intent(v.getContext(), RoomAL103.class);
                    startActivity(i);
                    break;

                case R.id.RoomIAS101_Card:_Card:
                i = new Intent(v.getContext(), RoomIAS101.class);
                    startActivity(i);
                    break;
                case R.id.RoomSE101_Card:_Card:
                i = new Intent(v.getContext(), RoomSE101.class);
                    startActivity(i);
                    break;
                case R.id.RoomELEC1_Card:_Card:
                i = new Intent(v.getContext(), RoomELEC1.class);
                    startActivity(i);
                    break;
                case R.id.RoomCC107_Card:_Card:
                i = new Intent(v.getContext(), RoomCC107.class);
                    startActivity(i);
                    break;
                case R.id.RoomIT101_Card:_Card:
                i = new Intent(v.getContext(), RoomIT101.class);
                    startActivity(i);
                    break;

                case R.id.RoomELEC2_Card:_Card:
                i = new Intent(v.getContext(), RoomELEC2.class);
                    startActivity(i);
                    break;
                case R.id.RoomSE102_Card:_Card:
                i = new Intent(v.getContext(), RoomSE102.class);
                    startActivity(i);
                    break;
                case R.id.RoomELEC3_Card:_Card:
                i = new Intent(v.getContext(), RoomELEC3.class);
                    startActivity(i);
                    break;
                case R.id.RoomCC108_Card:_Card:
                i = new Intent(v.getContext(), RoomCC108.class);
                    startActivity(i);
                    break;
                case R.id.RoomOS102_Card:_Card:
                i = new Intent(v.getContext(), RoomOS102.class);
                    startActivity(i);
                    break;
                case R.id.RoomIT102_Card:_Card:
                i = new Intent(v.getContext(), RoomIT102.class);
                    startActivity(i);
                    break;

                case R.id.RoomELEC4_Card:_Card:
                i = new Intent(v.getContext(), RoomELEC4.class);
                    startActivity(i);
                    break;
                case R.id.RoomELEC5_Card:_Card:
                i = new Intent(v.getContext(), RoomELEC5.class);
                    startActivity(i);
                    break;
                case R.id.RoomSDF105_Card:_Card:
                i = new Intent(v.getContext(), RoomSDF105.class);
                    startActivity(i);
                    break;
                case R.id.RoomHCI102_Card:_Card:
                i = new Intent(v.getContext(), RoomHCI102.class);
                    startActivity(i);
                    break;
            }
        }
    }
}

