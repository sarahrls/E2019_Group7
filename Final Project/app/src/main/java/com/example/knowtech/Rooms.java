package com.example.knowtech;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;



import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;


public class Rooms extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    selectYear YearAction;
    selectFirstYear FirstYearAction;
    selectSecondYear SecondYearAction;
    selectThirdYear ThirdYearAction;
    selectFourthYear FourthYearAction;
    Spinner spinner;
    List<String> names;
    private MenuItem item;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);

        spinner=findViewById(R.id.Spinner);
        YearAction=new selectYear();
        FirstYearAction=new selectFirstYear();
        SecondYearAction=new selectSecondYear();
        ThirdYearAction=new selectThirdYear();
        FourthYearAction=new selectFourthYear();

        names=new ArrayList<>();
        names.add("Select Year");
        names.add("First Year");
        names.add("Second Year");
        names.add("Third Year");
        names.add("Fourth Year");

        //NAVIGATION
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.purple_500)));

        drawerLayout = findViewById(R.id.drawableLayout);
        navigationView = findViewById(R.id.navigationview);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.navigation_open,R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(this);

        //SPINNER
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(Rooms.this, R.layout.item, names);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        selectFragment(YearAction);
                        break;
                    case 1:
                        selectFragment(FirstYearAction);
                        break;
                    case 2:
                        selectFragment(SecondYearAction);
                        break;
                    case 3:
                        selectFragment(ThirdYearAction);
                        break;
                    case 4:
                        selectFragment(FourthYearAction);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

            private void selectFragment(Fragment fragment) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.RoomsFrameLayout, fragment);
                fragmentTransaction.commit();
            }
            });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(toggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_rooms:
                        Toast.makeText(this, "Rooms", Toast.LENGTH_SHORT).show();
                        int rooms = item.getItemId();

                        if (rooms == R.id.nav_rooms) {

                            Intent intent = new Intent(Rooms.this, Rooms.class);
                            startActivity(intent);

                            return true;
                        }
                        break;
                    case R.id.nav_profile:
                        Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                        int profile = item.getItemId();

                        if (profile == R.id.nav_profile) {

                            Intent intent = new Intent(Rooms.this, Activity_Profile.class);
                            startActivity(intent);

                            return true;
                        }
                        break;
                    case R.id.nav_aboutus:
                        Toast.makeText(this, "About Us", Toast.LENGTH_SHORT).show();
                        int AboutUs = item.getItemId();

                        if (AboutUs == R.id.nav_aboutus) {

                            Intent intent = new Intent(Rooms.this, AboutUs.class);
                            startActivity(intent);

                            return true;
                        }
                        break;
                    case R.id.nav_settings:
                        Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                        int Settings = item.getItemId();

                        if (Settings == R.id.nav_settings) {

                            Intent intent = new Intent(Rooms.this, settings.class);
                            startActivity(intent);

                            return true;
                        }
                        break;
                    case R.id.nav_logout:
                        Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                        int Logout = item.getItemId();

                        if (Logout == R.id.nav_logout) {

                            Intent intent = new Intent(Rooms.this, Signin.class);
                            startActivity(intent);

                            return true;
                        }
                        break;


                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }

                return true;
            }

        }
    
