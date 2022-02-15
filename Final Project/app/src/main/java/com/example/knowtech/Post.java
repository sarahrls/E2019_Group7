package com.example.knowtech;

import android.content.Context;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.List;

public class Post {
    SessionManagement sessionManagement;
    public User session;
    public User user;
    public String title, description, dateCreated, PostID;
    public List<Comment> comments;
    private Context context;
    private Tool TOOL;

    public Post(Context context, User user, Bundle postObj, List<Comment> comments) {
        this.context = context;
        this.user = user;
        this.title = postObj.getString("title");
        this.description = postObj.getString("description");
        this.dateCreated = postObj.getString("dateCreated");
        this.PostID = postObj.getString("post_id");
        this.comments = comments;

        TOOL = new Tool(context);
        sessionManagement = new SessionManagement(context);
        session = sessionManagement.getSession();
    }


    public void Comment(String comment, Response.Listener listener, Response.ErrorListener errorListener) {
        String commentURL = "https://knowtech-study.000webhostapp.com/insertComment.php";

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("post_id", PostID);
        params.put("id", "" + session.id);
        params.put("email", session.email);
        params.put("comment", comment);

        TOOL.Ajax(commentURL, Request.Method.POST, params, listener, errorListener);
    }

    public void Comment(String comment, Response.Listener listener) {
        Comment(comment, listener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                TOOL.ToastText(error.getMessage());
            }
        });
    }
}