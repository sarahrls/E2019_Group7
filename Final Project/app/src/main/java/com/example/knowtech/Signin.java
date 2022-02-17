package com.example.knowtech;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.HashMap;

public class Signin extends AppCompatActivity {
    private Button signinBtn;
    private EditText email, password;
    private TextView forgot, createAnAccount;
    private String signInUrl = "https://knowtech-study.000webhostapp.com/SignIn.php";
    private Tool TOOL = new Tool(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        signinBtn = findViewById(R.id.Log_Signin);
        email = findViewById(R.id.edit_email);
        password = findViewById(R.id.edit_password);
        createAnAccount = findViewById(R.id.reg_signup);

        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                disableEnableButton();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                disableEnableButton();
            }
        };

        email.addTextChangedListener(watcher);
        password.addTextChangedListener(watcher);
        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verifyForm()) {
                    goSignIn();
                }
            }
        });

        createAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TOOL.startNewActivity(Signup.class);
            }
        });

        disableEnableButton();
    }



    public void disableEnableButton() {
        boolean status = true;
        String _email = TOOL.getValueFromInput(email);
        String _password = TOOL.getValueFromInput(password);

        if (_email.length() == 0) {
            status = false;
        }

        if (_password.length() == 0) {
            status = false;
        }

        signinBtn.setEnabled(status);
    }

    public boolean verifyForm() {
        boolean status = true;
        String _email = TOOL.getValueFromInput(email);
        String _password = TOOL.getValueFromInput(password);

        if (_email.length() == 0) {
            email.setError("Email is Required");
            email.requestFocus();
            status = false;
        } else {
            email.setError(null);
        }

        if (!TOOL.isValidEmailAddress(_email)) {
            email.setError("Please enter a valid Email Address");
            email.requestFocus();
            status = false;
        } else {
            email.setError(null);
        }

        if (_password.length() == 0) {
            password.setError("Password is Required");
            password.requestFocus();
            status = false;
        }else {
            password.setError(null);
        }

        return status;
    }

    private void enableForm(Boolean bool) {
        signinBtn.setEnabled(bool);
        email.setEnabled(bool);
        password.setEnabled(bool);
    }

    private void goSignIn() {
        enableForm(false);
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("email", TOOL.getValueFromInput(email));
        params.put("password", TOOL.getValueFromInput(password));

        if (TOOL.isInternetConnectionAvailable()) {
            TOOL.Ajax(signInUrl, Request.Method.POST, params, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject obj = new JSONObject(response);

                        TOOL.ToastText(obj.getString("message"));

                        if (obj.getBoolean("success")) {
                            TOOL.createSession(obj.getJSONObject("object"));
                        } else {
                            enableForm(true);
                            verifyForm();
                        }
                    } catch (Exception error) {
                        TOOL.ToastText(error.getMessage());
                        enableForm(true);
                        verifyForm();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    TOOL.ToastText(error.getMessage());
                    enableForm(true);
                }
            });
        } else {
            TOOL.ToastText("No Internet, Please check your internet connection!");
        }
    }
}


