package com.example.knowtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Signup extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getSupportActionBar();

        TextView reg_register = (TextView) findViewById(R.id.reg_signin);
        reg_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent text = new Intent(Signup.this,Signin.class);
                startActivity(text);

                finish();
            }
        });

        Button register = (Button) findViewById(R.id.btn_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signup.this,Homepage.class);
                startActivity(intent);

                finish();
            }
        });
    }
}