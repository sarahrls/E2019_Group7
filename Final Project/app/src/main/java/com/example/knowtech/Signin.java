package com.example.knowtech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Signin extends AppCompatActivity {

    TextInputEditText Email, Pass;
    TextView signup;
    Button signin;


    JSONParser jsonParser = new JSONParser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        Email = findViewById(R.id.edit_email);
        Pass = findViewById(R.id.edit_password);

        getSupportActionBar().hide();

        signup = (TextView) findViewById(R.id.reg_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signin.this,Signup.class);
                startActivity(intent);

                finish();
            }
        });

        signin = (Button) findViewById(R.id.Log_Signin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Email.getText().toString().equals("")) {
                    Toast.makeText(Signin.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                } /*else if (!emailValidator(inputEmail.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Please Field Valid Email", Toast.LENGTH_SHORT).show();
                }*/ else if (Pass.getText().toString().equals("")) {
                    Toast.makeText(Signin.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                } else {
                    login();
                }
            }
        });
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }


    private void login() {

        final ProgressDialog progressDialog = new ProgressDialog(Signin.this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("Logging in...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        NetworkService networkService = NetworkClient.getClient().create(NetworkService.class);
        Call<LoginResponseModel> login = networkService.login(Email.getText().toString(), Pass.getText().toString());
        login.enqueue(new Callback<LoginResponseModel>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponseModel> call, @NonNull Response<LoginResponseModel> response) {
                LoginResponseModel responseBody = response.body();
                if (responseBody != null) {
                    if (responseBody.getSuccess().equals("1")) {
                        SharedPreferences preferences = getSharedPreferences(Constants.PREFERENCE_NAME, MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putBoolean(Constants.KEY_ISE_LOGGED_IN, true);
                        editor.putString(Constants.KEY_USERNAME, responseBody.getUserDetailObject().getUserDetails().get(0).getUsername() + " " + responseBody.getUserDetailObject().getUserDetails().get(0).getPassword());
                        /*editor.putString(Constants.KEY_LASTNAME, responseBody.getUserDetailObject().getUserDetails().get(0).getLastName());*/
                        editor.putString(Constants.KEY_EMAIL, responseBody.getUserDetailObject().getUserDetails().get(0).getEmail());
                        editor.apply();
                        Toast.makeText(Signin.this, responseBody.getMessage(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),Homepage.class));
                        finish();
                    } else {
                        Toast.makeText(Signin.this, responseBody.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponseModel> call, @NonNull Throwable t) {
                progressDialog.dismiss();
            }
        });
    }

    public boolean emailValidator(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}









