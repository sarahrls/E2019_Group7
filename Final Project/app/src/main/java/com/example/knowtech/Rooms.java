package com.example.knowtech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;



import java.util.ArrayList;
import java.util.List;

public class Rooms extends AppCompatActivity {
    selectYear YearAction;
    selectFirstYear FirstYearAction;
    selectSecondYear SecondYearAction;
    selectThirdYear ThirdYearAction;
    selectFourthYear FourthYearAction;
    Spinner spinner;
    List<String> names;

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


        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(Rooms.this, R.layout.item, names);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
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
        });



    }

    private void selectFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.RoomsFrameLayout,fragment);
        fragmentTransaction.commit();
    }
}