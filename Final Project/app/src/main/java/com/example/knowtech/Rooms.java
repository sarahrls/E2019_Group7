package com.example.knowtech;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.cardview.widget.CardView;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

public class Rooms extends AppCompatActivity  {
    private DrawerLayout drawer;
    private CardView RoomCC101;


    DrawerLayout drawerLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);


            RoomCC101 = findViewById(R.id.RoomCC101_Card);
            RoomCC101.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent i;

                    switch (v.getId()) {
                        case R.id.RoomCC101_Card:
                            i = new Intent(v.getContext(), RoomCC101.class);
                            startActivity(i);
                        default:
                            break;

                    }
                }
            });
        }


}