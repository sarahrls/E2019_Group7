package com.example.knowtech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.app.ProgressDialog;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.Map;

import java.util.ArrayList;


public class Signup extends AppCompatActivity {

    TextView reg_register;
    TextInputEditText Username, Email, Password;
    String str_username, str_email, str_password;
    Button register;

    String URL = "https://knowtech-study-room.000webhostapp.com/register.php";
    JSONParser jsonParser = new JSONParser();

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getSupportActionBar().hide();

        Username = findViewById(R.id.edit_username);
        Email = findViewById(R.id.edit_email);
        Password = findViewById(R.id.edit_password);

        reg_register = (TextView) findViewById(R.id.reg_signin);
        reg_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent text = new Intent(Signup.this, Signin.class);
                startActivity(text);
                finish();
            }
        });


        register = (Button) findViewById(R.id.btn_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Username.getText().toString().equals("")) {
                    Toast.makeText(Signup.this, "Enter username", Toast.LENGTH_SHORT).show();
                } else if (Email.getText().toString().equals("")) {
                    Toast.makeText(Signup.this, "Enter email", Toast.LENGTH_SHORT).show();
                } else if (Password.getText().toString().equals("")) {
                    Toast.makeText(Signup.this, "Enter password", Toast.LENGTH_SHORT).show();
                } else {

                    HashMap<String, String> params = new HashMap<>();
                    params.put("username", Username.getText().toString());
                    params.put("email", Email.getText().toString());
                    params.put("password", Password.getText().toString());
                    register(params);
                }

            }

        });

    }

    private void register(HashMap<String, String> params) {

        final ProgressDialog progressDialog = new ProgressDialog(Signup.this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("Registering...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        NetworkService networkService = NetworkClient.getClient().create(NetworkService.class);
        Call<RegistrationResponseModel> registerCall = networkService.register(params);
        registerCall.enqueue(new Callback<RegistrationResponseModel>() {
            @Override
            public void onResponse(@NonNull Call<RegistrationResponseModel> call, @NonNull Response<RegistrationResponseModel> response) {
                RegistrationResponseModel responseBody = response.body();
                if (responseBody != null) {
                    if (responseBody.getSuccess().equals("1")) {
                        Toast.makeText(Signup.this, responseBody.getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Signup.this, Signin.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(Signup.this, responseBody.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(@NonNull Call<RegistrationResponseModel> call, @NonNull Throwable t) {
                progressDialog.dismiss();
            }
        });
            }

    }



