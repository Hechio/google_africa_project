package com.stevehechio.apps.gads2020leaderboard.utils;

import android.util.Log;

import com.stevehechio.apps.gads2020leaderboard.BuildConfig;


public class DebugUtils {
    public static void doLog(Object theClass, Object theLogMessage){
        if(BuildConfig.DEBUG) {
            Log.d(AppConstants.LOG_TAG, String.format("%s: %s", theClass.toString(), theLogMessage.toString()));
        }
    }
}
