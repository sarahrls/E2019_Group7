package com.example.knowtech;

import android.content.Context;
import android.content.Intent;

import android.net.ConnectivityManager;

import android.os.Bundle;

import android.widget.EditText;

import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Tool extends AppCompatActivity {
    Context context;


    public Tool(Context ctx){
        this.context = ctx;
    }


    public void startNewActivity(Class classPackage) {
        Intent intent = new Intent(this.context, classPackage);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        this.context.startActivity(intent);
    }

    public void startNewActivityWBundle(Class classPackage, Bundle bundle) {
        Intent intent = new Intent(this.context, classPackage);
        intent.putExtras(bundle);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        this.context.startActivity(intent);
    }

    public void ToastText(String text) {
        Toast.makeText(this.context, text, Toast.LENGTH_SHORT).show();
    }

    public String getValueFromInput(EditText input) {
        return input.getText().toString();
    }

    public static boolean validateJavaDate(String strDate)
    {
        /* Check if date is 'null' */
        if (!strDate.trim().equals("")) {
            /*
             * Set preferred date format,
             * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
            SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
            sdfrmt.setLenient(false);
            /* Create Date object
             * parse the string into date
             */
            try {
                Date javaDate = sdfrmt.parse(strDate);
                System.out.println(strDate + " is valid date format");
            }
            /* Date format is invalid */ catch (ParseException e) {
                System.out.println(strDate + " is Invalid Date format");
                return false;
            }
            /* Return true if date format is valid */
        }
        return true;
    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }


    public boolean equalBundles(Bundle one, Bundle two) {
        if(one.size() != two.size())
            return false;

        Set<String> setOne = new HashSet<>(one.keySet());
        setOne.addAll(two.keySet());
        Object valueOne;
        Object valueTwo;

        for(String key : setOne) {
            if (!one.containsKey(key) || !two.containsKey(key))
                return false;

            valueOne = one.get(key);
            valueTwo = two.get(key);
            if(valueOne instanceof Bundle && valueTwo instanceof Bundle &&
                    !equalBundles((Bundle) valueOne, (Bundle) valueTwo)) {
                return false;
            }
            else if(valueOne == null) {
                if(valueTwo != null)
                    return false;
            }
            else if(!valueOne.equals(valueTwo))
                return false;
        }

        return true;
    }

    public User createUserFromJSONOBJECT(JSONObject obj) throws JSONException {
        int id = obj.getInt("id");
        int age = obj.getInt("age");
        String email = obj.getString("email"),
                firstname = obj.getString("firstname"),
                lastname = obj.getString("lastname"),
                gender = obj.getString("gender"),
                bday = obj.getString("birthdate");

        User user = new User(id, email, firstname, lastname, gender, bday, age);

        return user;
    }

    public void createSession(JSONObject userObj) throws JSONException {
        int id = userObj.getInt("id");
        int age = userObj.getInt("age");
        String email = userObj.getString("email");
        String firstname = userObj.getString("firstname");
        String lastname = userObj.getString("lastname");
        String birthdate = userObj.getString("birthdate");
        String gender = userObj.getString("gender");

        User user = new User(id, email, firstname, lastname, gender, birthdate, age);

        SessionManagement sessionManagement = new SessionManagement(this.context);
        sessionManagement.saveSession(user);

        startNewActivity(Rooms.class);
    }

    public boolean checkSession() {
        SessionManagement sessionManagement = new SessionManagement(this.context);
        int userID = sessionManagement.getSessionID();

        return userID != -1;
    }

    public void checkSessionAndRedirect() {
        if (checkSession()) {
            startNewActivity(Signin.class);
        }
    }


    public Post createPostFromJSONOBJ(JSONObject jsonObject) throws JSONException {

        List<Comment> comments = createCommentByJSONOBJECT(jsonObject.getJSONArray("comments"));
        User author = createUserFromJSONOBJECT(jsonObject.getJSONObject("user"));
        Bundle aInfo = new Bundle();
        aInfo.putString("title", jsonObject.getString("title"));
        aInfo.putString("description", jsonObject.getString("description"));
        aInfo.putString("dateCreated", jsonObject.getString("dateCreated"));
        aInfo.putString("post_id", jsonObject.getString("post_id"));
        //aInfo.putBoolean("isHearted", jsonObject.getBoolean("hearted"));
        return new Post(this.context, author, aInfo, comments);
    }

    private List<Comment> createCommentByJSONOBJECT(JSONArray comments) {
        List<Comment> comms = new ArrayList<>();

        for (int i = 0; i < comments.length(); i++) {
            try {
                JSONObject obj = comments.getJSONObject(i);
                User author = createUserFromJSONOBJECT(obj.getJSONObject("user"));
                String commentID = obj.getString("comment_id"),
                        PostID = obj.getString("post_id"),
                        comment = obj.getString("comment"),
                        id = obj.getString("id"),
                        email = obj.getString("email"),
                        dateCreated = obj.getString("date_created");

                Comment com = new Comment(author, id, email, commentID, PostID, comment, dateCreated);
                comms.add(com);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return comms;
    }


    public void Ajax(String url, int method, HashMap<String, String> params, Response.Listener responseListener, Response.ErrorListener errorListener) {
        RequestQueue reqQueue = Volley.newRequestQueue(this.context);
        StringRequest request = new StringRequest(method, url, responseListener, errorListener) {
            public Map<String, String> getParams() {
                return params;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(10000, 1, 1.0f));
        reqQueue.add(request);
    }

    public void Ajax(String url, int method, HashMap<String, String> params, Response.Listener responseListener) {
        Ajax(url, method, params, responseListener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ToastText(error.getMessage());
            }
        });
    }

    public boolean isInternetConnectionAvailable() {
        ConnectivityManager cm = (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    public Tool() {

    }
}