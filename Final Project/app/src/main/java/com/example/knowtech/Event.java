package com.example.knowtech;

import android.os.Bundle;
import android.text.TextUtils;

public class Event {
    public Admin admin;
    public String title, description, location, defaultColor;
    public String fromDate, toDate, fromTime, toTime;
    public String[] peoples;

    public Event(Admin admin, Bundle eventInfo) {
        this.admin = admin;
        this.title = eventInfo.getString("title");
        this.description = eventInfo.getString("description");
        this.location = eventInfo.getString("location");
        this.defaultColor = eventInfo.getString("color");
        this.fromDate = eventInfo.getString("fromDate");
        this.toDate = eventInfo.getString("toDate");
        this.fromTime = eventInfo.getString("fromTime");
        this.toTime = eventInfo.getString("toTime");
        this.peoples = eventInfo.getStringArray("peoples");
    }

    public Bundle getBundle() {
        Bundle eventInfo = new Bundle();
        eventInfo.putString("adminID", "" + admin.id);
        eventInfo.putString("adminEmail", admin.email);
        eventInfo.putString("title", title);
        eventInfo.putString("description", description);
        eventInfo.putString("fromDate", fromDate);
        eventInfo.putString("toDate", toDate);
        eventInfo.putString("fromTime", fromTime);
        eventInfo.putString("toTime", toTime);
        eventInfo.putString("location", location);
        eventInfo.putString("color", defaultColor);
        eventInfo.putString("peoples", TextUtils.join(",", peoples));
        return eventInfo;
    }
}