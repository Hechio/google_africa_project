package com.stevehechio.apps.gads2020leaderboard.utils;

import com.stevehechio.apps.gads2020leaderboard.BuildConfig;

public class AppConstants {
    public static final String LEARNING_LEADERS_ENDPOINT= "https://gadsapi.herokuapp.com/api/hours";
    public static final String SKILL_IQ_ENDPOINT = "https://gadsapi.herokuapp.com/api/skilliq";
    public static final String SUBMIT_BASE_URL = "https://docs.google.com/forms/d/e/";
    public static final String LOG_TAG = String.format("%s.default_debug", BuildConfig.APPLICATION_ID);
}
