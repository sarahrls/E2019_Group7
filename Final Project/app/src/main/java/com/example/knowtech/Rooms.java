package com.example.knowtech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.knowtech.databinding.ActivityRoomsBinding;

public class Rooms extends AppCompatActivity {
    private CardView RoomCC101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);

        RoomCC101 = findViewById(R.id.RoomCC101_Card);
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