package com.example.knowtech;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.android.volley.Request;
import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RoomCC101F extends Fragment {


    private SessionManagement sessionManagement;
    private User user;
    private Tool TOOL;

    public RoomCC101F(SessionManagement sess, Context ctx) {
        this.sessionManagement = sess;
        this.user = sess.getSession();
        TOOL = new Tool(ctx);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle fragmentContents = new Bundle();

        fragmentContents.putInt("Rooms", R.layout.activity_room_cc101_f);
        fragmentContents.putInt("Search", R.layout.activity_room_cc101_search);


        String title = getArguments().getString("title");
        View view = inflater.inflate(fragmentContents.getInt(title), container, false);

        goToView(title, view);


        return view;
    }

    private void goToView(String title, View view) {
        switch (title) {
            case "Room":
                goToRoom(view);
                break;
            case "Account":
                goToSearch(view);
                break;
        }

    }


    private void goToRoom(View view) {

        RelativeLayout noDataContainer = view.findViewById(R.id.noDataContainer);
        ConstraintLayout loadingContainer = view.findViewById(R.id.loadingContainer);
        CardView announcementBtn = view.findViewById(R.id.mainAddAnnouncementBtn);
        RecyclerView recyclerView = view.findViewById(R.id.mainAnnouncementRecycleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        List<Post> posts  = new ArrayList<>();
        String getPostURL = "https://knowtech-study.000webhostapp.com/getPost.php";

        announcementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go(AddPost.class);
            }
        });


        if (TOOL.isInternetConnectionAvailable()) {
            HashMap<String, String> params = new HashMap<String, String>();
            params.put("id", "" + user.id);
            params.put("email", user.email);

            loadingContainer.setVisibility(View.VISIBLE);

            TOOL.Ajax(getPostURL, Request.Method.POST, params, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    loadingContainer.setVisibility(View.GONE);
                    try {
                        JSONObject obj = new JSONObject(response);

                        if (obj.getBoolean("success")) {
                            JSONArray EVENTS = obj.getJSONArray("object");

                            if (EVENTS.length() != 0) {
                                for (int i =0; i < EVENTS.length(); i++) {
                                    Post post = TOOL.createPostFromJSONOBJ(EVENTS.getJSONObject(i));
                                    posts.add(post);
                                }

                                RVAdapterPost adapter = new RVAdapterPost(posts, view.getContext());
                                recyclerView.setLayoutManager(linearLayoutManager);
                                recyclerView.setAdapter(adapter);

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

    private void goToSearch(View view) {

    }
    private void go(Class classPackage) {
        Intent intent = new Intent(getActivity(), classPackage);
        startActivity(intent);
    }

}