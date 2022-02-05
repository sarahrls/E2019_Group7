package com.example.knowtech;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import android.os.Bundle;
import android.widget.AdapterView.OnItemSelectedListener;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class customize_profile extends AppCompatActivity {

    TextInputEditText Lastname, Firstname,Middlename, Age,Gender, Contact;
    EditText Birthday;
    Button Customize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_profile);

        Lastname = findViewById(R.id.edit_Lastname);
        Firstname = findViewById(R.id.edit_Firstname);
        Middlename = findViewById(R.id.edit_Middlename);
        Age = findViewById(R.id.edit_Age);
        Gender = findViewById(R.id.edit_Gender);
        Contact = findViewById(R.id.edit_Contact);
        Birthday = findViewById(R.id.edit_Birthday);
        Customize = findViewById(R.id.btn_customize);

        Customize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Lastname.getText().toString().equals("")) {
                    Toast.makeText(customize_profile.this, "Enter your lastname", Toast.LENGTH_SHORT).show();
                } else if (Firstname.getText().toString().equals("")) {
                    Toast.makeText(customize_profile.this, "Enter your firstname", Toast.LENGTH_SHORT).show();
                } else if (Middlename.getText().toString().equals("")) {
                    Toast.makeText(customize_profile.this, "Enter your middlename", Toast.LENGTH_SHORT).show();
                } else if (Age.getText().toString().equals("")) {
                    Toast.makeText(customize_profile.this, "Enter your age", Toast.LENGTH_SHORT).show();
                } else if (Birthday.getText().toString().equals("")) {
                    Toast.makeText(customize_profile.this, "Enter your birthday", Toast.LENGTH_SHORT).show();
                } else if (Gender.getText().toString().equals("")) {
                        Toast.makeText(customize_profile.this, "Enter your gender", Toast.LENGTH_SHORT).show();
                } else if (Contact.getText().toString().equals("")) {
                    Toast.makeText(customize_profile.this, "Enter your contact number", Toast.LENGTH_SHORT).show();
                } else {

                    HashMap<String, String> params = new HashMap<>();
                    params.put("lastname", Lastname.getText().toString());
                    params.put("firstname", Firstname.getText().toString());
                    params.put("middlename", Middlename.getText().toString());
                    params.put("age", Age.getText().toString());
                    params.put("birthday", Birthday.getText().toString());
                    params.put("gender", Gender.getText().toString());
                    params.put("contact", Contact.getText().toString());
                    profile(params);
                }
            }
        });

    }


    private void profile (HashMap<String,String>params){

        final ProgressDialog progressDialog = new ProgressDialog(customize_profile.this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("Registering...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        NetworkService networkService = NetworkClient.getClient().create(NetworkService.class);
        Call<RegistrationResponseModel> registerCall = networkService.profile(params);
        registerCall.enqueue(new Callback<RegistrationResponseModel>() {
            @Override
            public void onResponse(@NonNull Call<RegistrationResponseModel> call, @NonNull Response<RegistrationResponseModel> response) {
                RegistrationResponseModel responseBody = response.body();
                if (responseBody != null) {
                    if (responseBody.getSuccess().equals("1")) {
                        Toast.makeText(customize_profile.this, responseBody.getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(customize_profile.this, Signin.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(customize_profile.this, responseBody.getMessage(), Toast.LENGTH_SHORT).show();
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


