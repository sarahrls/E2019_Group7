package com.example.knowtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class getStarted extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
        Button btn_getStarted = findViewById(R.id.btn_getStarted);
        btn_getStarted.setOnClickListener(v -> {
            Intent int1 =new Intent(getStarted.this,Signin.class);
            startActivity(int1);
        });
        getSupportActionBar().hide();
    }
}