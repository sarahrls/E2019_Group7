package com.example.knowtech;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Signup extends AppCompatActivity {

    private Button signUpBtn;
    private TextView reg_signin;
    private EditText email, password,confirmPassword;
    private String emailExistUrl = "https://knowtech-study.000webhostapp.com/isEmailExist.php";
    private Tool TOOL = new Tool(this);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        signUpBtn = findViewById(R.id.SignUp);
        email = findViewById(R.id.reg_email);
        password = findViewById(R.id.reg_password);
        confirmPassword = findViewById(R.id.reg_confirmpassword);
        reg_signin = findViewById(R.id.reg_signin);

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
        confirmPassword.addTextChangedListener(watcher);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verifyForm()) {
                    checkIfEmailExist();
                }
            }
        });

        reg_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TOOL.startNewActivity(Signin.class);
            }
        });


        disableEnableButton();
    }


    public void disableEnableButton() {
        boolean status = true;
        String _email = TOOL.getValueFromInput(email);
        String _password = TOOL.getValueFromInput(password);
        String _confirm = TOOL.getValueFromInput(confirmPassword);

        if (_email.length() == 0) {
            status = false;
        }

        if (_password.length() == 0) {
            status = false;
        }

        if (_password.length() < 8) {
            status = false;
        }

        if (_confirm.length() == 0) {
            status = false;
        }

        if (!_password.equals(_confirm)) {
            status = false;
        }

        signUpBtn.setEnabled(status);
    }

    public boolean verifyForm() {
        boolean status = true;
        String _email = TOOL.getValueFromInput(email);
        String _password = TOOL.getValueFromInput(password);
        String _confirm = TOOL.getValueFromInput(confirmPassword);

        if (_email.length() == 0) {
            email.setError("Email is Required");
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

        if (_password.length() < 8) {
            password.setError("Password should be at-least of 8 characters");
            password.requestFocus();
            status = false;
        }else {
            password.setError(null);
        }

        if (_confirm.length() == 0) {
            confirmPassword.setError("Please confirm your password!");
            confirmPassword.requestFocus();
            status = false;
        }else {
            confirmPassword.setError(null);
        }

        if (!_password.equals(_confirm)) {
            confirmPassword.setError("Password did not matched");
            confirmPassword.requestFocus();
            status = false;
        }else {
            confirmPassword.setError(null);
        }

        return status;
    }

    private void checkIfEmailExist() {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("email", email.getText().toString());

        if (TOOL.isInternetConnectionAvailable()) {
            TOOL.Ajax(emailExistUrl, Request.Method.POST, params, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject obj = new JSONObject(response);

                        TOOL.ToastText(obj.getString("message"));

                        if (obj.getInt("status") == 202) {
                            Bundle bundle = new Bundle();
                            bundle.putString("email", TOOL.getValueFromInput(email));
                            bundle.putString("password", TOOL.getValueFromInput(password));
                            TOOL.startNewActivityWBundle(customize_profile.class, bundle);
                        }

                    } catch (Exception e) {
                        Toast.makeText(Signup.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Signup.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            TOOL.ToastText("No Internet, Please check your internet connection!");
        }

    }
}