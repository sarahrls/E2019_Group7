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


public class selectSecondYear extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_second_year, container, false);
    }
    /*
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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

        RoomCC106.setOnClickListener(new selectSecondYear.Clik());
        RoomSDF104.setOnClickListener(new selectSecondYear.Clik());
        RoomAL102.setOnClickListener(new selectSecondYear.Clik());
        RoomNC101.setOnClickListener(new selectSecondYear.Clik());

        RoomAR101.setOnClickListener(new selectSecondYear.Clik());
        RoomOS101.setOnClickListener(new selectSecondYear.Clik());
        RoomPL101.setOnClickListener(new selectSecondYear.Clik());
        RoomHCI101.setOnClickListener(new selectSecondYear.Clik());
        RoomAL103.setOnClickListener(new selectSecondYear.Clik());
    }

    public class Clik implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent i;

            switch (v.getId()) {
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
            }
        }
    }*/
}