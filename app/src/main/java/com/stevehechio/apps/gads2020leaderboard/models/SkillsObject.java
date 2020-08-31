package com.stevehechio.apps.gads2020leaderboard.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkillsObject {
    @SerializedName("score")
    @Expose
    private int score;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("badgeUrl")
    @Expose
    private String badgeUrl;

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }
}
