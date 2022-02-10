package com.example.knowtech;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;
import java.util.HashMap;

public class customize_profile extends AppCompatActivity {

    private Button continueSignUp;
    private EditText firstname, lastname,date;
    private RadioButton maleGender, femaleGender;
    private RadioGroup gender;
    private CheckBox checkBox;
    private String signUpUrl = "https://knowtech-study.000webhostapp.com/SignUp.php";
    private RequestQueue reqQueue;
    private String EMAIL, PASSWORD;

    private Tool TOOL = new Tool(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_customize_profile);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Bundle bundle = getIntent().getExtras();
        String email = bundle.getString("email");
        String password = bundle.getString("password");

        EMAIL = email;
        PASSWORD = password;

        continueSignUp = findViewById(R.id.csupSignUpBtn);
        firstname = findViewById(R.id.csupFirstName);
        lastname = findViewById(R.id.csupLastName);
        date = findViewById(R.id.csupBirthDate);
        gender = findViewById(R.id.csupGender);
        maleGender = findViewById(R.id.csMale);
        femaleGender = findViewById(R.id.csFemale);
        checkBox = findViewById(R.id.csupCheckBox);

        reqQueue = Volley.newRequestQueue(getApplicationContext());

        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                disableEnableButton();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                disableEnableButton();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                disableEnableButton();
            }
        };

        firstname.addTextChangedListener(watcher);
        lastname.addTextChangedListener(watcher);
        date.addTextChangedListener(watcher);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                disableEnableButton();
            }
        });

        continueSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (verifyForm()) {
                    goSignUp();
                }
            }
        });

        disableEnableButton();
    }

    public void disableEnableButton() {
        boolean status = true;
        String _firstname = firstname.getText().toString();
        String _lastname = lastname.getText().toString();
        String _date = date.getText().toString();
        boolean _checkbox = checkBox.isChecked();

        if (_firstname.length() == 0) {
            status = false;
        }

        if (_lastname.length() == 0) {
            status = false;
        }

        if (_date.length() == 0) {
            status = false;
        }

        if (!_checkbox) {
            status = false;
        }

        if (!TOOL.validateJavaDate(_date)) {
            status = false;
        }

        if (!maleGender.isChecked() && !femaleGender.isChecked()) {
            status = false;
        }

        continueSignUp.setEnabled(status);
    }

    public boolean verifyForm() {
        boolean status = true;
        String _firstname = firstname.getText().toString();
        String _lastname = lastname.getText().toString();
        String _date = date.getText().toString();
        boolean _checkbox = checkBox.isChecked();

        if (_firstname.length() == 0) {
            firstname.setError("Firstname is required");
            firstname.requestFocus();
            status = false;
        }

        if (_lastname.length() == 0) {
            lastname.setError("Firstname is required");
            lastname.requestFocus();
            status = false;
        }

        if (_date.length() == 0) {
            date.setError("Birthdate is required");
            date.requestFocus();
            status = false;
        }

        if (!_checkbox) {
            checkBox.setError("Please accept terms and conditions!");
            checkBox.requestFocus();
            status = false;
        }

        if (!TOOL.validateJavaDate(_date)) {
            date.setError("Invalid format: mm/dd/yy");
            date.requestFocus();
            status = false;
        }

        return status;
    }

    private void goSignUp() {
        HashMap<String, String> params = new HashMap<String, String>();
        RadioButton button = findViewById(gender.getCheckedRadioButtonId());
        params.put("email", EMAIL);
        params.put("password", PASSWORD);
        params.put("firstname", firstname.getText().toString());
        params.put("lastname", lastname.getText().toString());
        params.put("birthdate", date.getText().toString());
        params.put("gender", button.getText().toString());

        TOOL.Ajax(signUpUrl, Request.Method.POST, params, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);

                    TOOL.ToastText(obj.getString("message"));
                    TOOL.startNewActivity(CheckUp.class);

                } catch (Exception e) {
                    TOOL.ToastText(e.getMessage().toString());
                }
            }
        });

    }
}