package com.example.knowtech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Signin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        Button signin;
        EditText signin_username, signin_password;

        signin_username = (EditText) findViewById(R.id.signin_username);
        signin_password = (EditText) findViewById(R.id.signin_password);
        signin = (Button) findViewById(R.id.signin);



    }
}