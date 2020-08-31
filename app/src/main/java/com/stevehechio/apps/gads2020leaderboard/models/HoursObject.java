package com.stevehechio.apps.gads2020leaderboard.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HoursObject {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("hours")
    @Expose
    private int hours;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("badgeUrl")
    @Expose
    private String badgeUrl;

    public String getName() {
        return name;
    }

    public int getHour() {
        return hours;
    }

    public String getCountry() {
        return country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }
}
