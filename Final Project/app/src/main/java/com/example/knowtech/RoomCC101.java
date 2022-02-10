package com.example.knowtech;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.androidgamesdk.gametextinput.Listener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.security.AccessController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class RoomCC101 extends AppCompatActivity {
    Dialog popAddPost;
    ImageView popup_addpost;
    TextView popupTitle, popupDescription, popupLink;
    ProgressBar popup_progressBar;

    private SessionManagement sessionManagement;
    private Admin admin;
    private Tool TOOL;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_cc101);

        RelativeLayout noDataContainer = findViewById(R.id.noDataContainer);
        ConstraintLayout loadingContainer = findViewById(R.id.loadingContainer);
        CardView announcementBtn = findViewById(R.id.mainAddAnnouncementBtn);
        RecyclerView recyclerView = findViewById(R.id.mainAnnouncementRecycleView);

        List<Announcement> announcements  = new ArrayList<>();
        String getAnnouncementURL = "https://e2019cc107grouptwo.000webhostapp.com/API/getAnnouncements.php";


        announcementBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(RoomCC101.this,Post.class);
                    startActivity(intent);
                    finish();
                }
            });

        if (TOOL.isInternetConnectionAvailable()) {
            HashMap<String, String> params = new HashMap<String, String>();
            params.put("id", "" + admin.id);
            params.put("email", admin.email);

            loadingContainer.setVisibility(View.VISIBLE);

            TOOL.Ajax(getAnnouncementURL, Request.Method.POST, params, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    loadingContainer.setVisibility(View.GONE);
                    try {
                        JSONObject obj = new JSONObject(response);

                        if (obj.getBoolean("success")) {
                            JSONArray EVENTS = obj.getJSONArray("object");

                            if (EVENTS.length() != 0) {
                                for (int i =0; i < EVENTS.length(); i++) {
                                    Announcement announcement = TOOL.createAnnouncementFromJSONOBJ(EVENTS.getJSONObject(i));
                                    announcements.add(announcement);
                                }


                            } else {
                                noDataContainer.setVisibility(View.VISIBLE);
                            }
                        } else {
                            noDataContainer.setVisibility(View.VISIBLE);
                        }
                    } catch (Exception error) {
                        TOOL.ToastText(error.getMessage());
                    }
                }
            });
        } else {
            TOOL.ToastText("Error, Please check your internet connection!");
        }
    }
}