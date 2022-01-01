package com.example.knowtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Signin extends AppCompatActivity {

    TextView textView;
    Button signin_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        getSupportActionBar();

        TextView textview = findViewById(R.id.reg_signin);
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signin.this,Signup.class);
                startActivity(intent);

                finish();
            }
        });

        signin_button = findViewById(R.id.btn_signin);
        signin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent int1 = new Intent(Signin.this,Homepage.class);
                startActivity(int1);

                finish();
            }
        });



    }
}