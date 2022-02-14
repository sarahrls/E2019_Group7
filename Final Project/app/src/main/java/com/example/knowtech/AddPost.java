package com.example.knowtech;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;

import java.util.HashMap;

public class AddPost extends AppCompatActivity {

    private CardView backBtn, saveBtn;
    private EditText title, description;
    private String insertPostURL = "https://knowtech-study.000webhostapp.com/insertPost.php";
    private Tool TOOL = new Tool(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_post);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        backBtn = findViewById(R.id.aaaBackBtn);
        saveBtn = findViewById(R.id.aaaSaveBtn);
        title = findViewById(R.id.aaaaTitle);
        description = findViewById(R.id.aaaDescription);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPost();
            }
        });
    }

    private void addPost() {
        HashMap<String, String> params = new HashMap<String, String>();
        SessionManagement sessionManagement = new SessionManagement(this);
        User user = sessionManagement.getSession();

        params.put("userID", "" + user.id);
        params.put("userEmail", user.email);
        params.put("title", TOOL.getValueFromInput(title));
        params.put("description", TOOL.getValueFromInput(description));

        AlertDialog dialog =  previewProgressLoader();

        TOOL.Ajax(insertPostURL, Request.Method.POST, params, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dialog.hide();
                TOOL.ToastText("Post Successfully Added!");
                TOOL.startNewActivity(RoomCC101.class);
            }
        });
    }

    private AlertDialog previewProgressLoader() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        final View view = getLayoutInflater().inflate(R.layout.layout_loading, null);
        dialogBuilder.setView(view);
        AlertDialog dialog = dialogBuilder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
        return dialog;
    }
}

