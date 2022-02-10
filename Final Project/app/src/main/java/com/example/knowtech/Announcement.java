package com.example.knowtech;

import android.content.Context;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.List;

public class Announcement {
    SessionManagement sessionManagement;
    public Admin session;
    public Admin admin;
    public String title, description, dateCreated, announcementID;
    public Boolean isHearted;
    public List<Comment> comments;
    private Context context;
    private Tool TOOL;

    public Announcement(Context context, Admin admin, Bundle announcementObj, List<Comment> comments, JSONArray totalHearts) {
        this.context = context;
        this.admin = admin;
        this.title = announcementObj.getString("title");
        this.description = announcementObj.getString("description");
        this.dateCreated = announcementObj.getString("dateCreated");
        this.announcementID = announcementObj.getString("announcement_id");
        this.isHearted = announcementObj.getBoolean("isHearted");
        this.comments = comments;

        TOOL = new Tool(context);
        sessionManagement = new SessionManagement(context);
        session = sessionManagement.getSession();
    }

    public void Heart(String addOrRemove, Response.Listener listener, Response.ErrorListener errorListener) {
        String heartURL = "https://e2019cc107grouptwo.000webhostapp.com/API/announcementHeart.php";

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("announcement_id", announcementID);
        params.put("adminID", "" + session.id);
        params.put("adminEmail", session.email);
        params.put("addOrRemove", addOrRemove);
        this.isHearted = !this.isHearted;
        TOOL.Ajax(heartURL, Request.Method.POST,params, listener,errorListener);
    }


    public void Comment(String comment, Response.Listener listener, Response.ErrorListener errorListener) {
        String commentURL = "https://e2019cc107grouptwo.000webhostapp.com/API/insertComment.php";

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("announcement_id", announcementID);
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