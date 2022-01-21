package com.example.knowtech;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserDetailModel {
    @SerializedName("user_details")
    private List<UserModel> userDetails;

    public List<UserModel> getUserDetails() {
        return userDetails;
    }
}
