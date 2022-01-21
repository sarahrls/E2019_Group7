package com.example.knowtech;


import com.google.gson.annotations.SerializedName;

public class LoginResponseModel {

    @SerializedName("success")
    private String success;

    @SerializedName("message")
    private String message;

    @SerializedName("user_details")
    private UserDetailModel userDetailObject;

    public UserDetailModel getUserDetailObject() {
        return userDetailObject;
    }

    public String getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
