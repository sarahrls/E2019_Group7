package com.example.knowtech;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class CheckUp extends AppCompatActivity {

    private Tool TOOL = new Tool(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_up);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        final Handler handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                if (TOOL.checkSession()) {
                    TOOL.checkSessionAndRedirect();
                } else  {
                    TOOL.startNewActivity(Rooms.class);
                }
                finish();
            }
        };

        handler.postDelayed(r, 3000);
    }
}