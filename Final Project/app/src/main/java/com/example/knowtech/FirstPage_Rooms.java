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

public class FirstPage_Rooms extends Fragment {
    private CardView RoomCC101;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_firstpage_rooms, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RoomCC101 = view.findViewById(R.id.RoomCC101_Card);
        RoomCC101.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i;

                switch(v.getId()){
                    case R.id.RoomCC101_Card:i=new Intent (v.getContext(), RoomCC101.class);startActivity(i);
                    default:break;

                }
            }
        });
    }

}