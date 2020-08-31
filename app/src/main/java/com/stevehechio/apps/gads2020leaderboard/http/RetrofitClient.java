package com.stevehechio.apps.gads2020leaderboard.http;

import com.stevehechio.apps.gads2020leaderboard.utils.AppConstants;

import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit instance;
    private static Retrofit retrofit;

    public RetrofitClient() {
    }

    public static Retrofit getInstance() {
        if (instance==null){
            instance = new Retrofit.Builder()
                    .baseUrl("https://gadsapi.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return instance;
    }
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(AppConstants.SUBMIT_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
