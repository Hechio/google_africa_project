package com.stevehechio.apps.gads2020leaderboard.http;

import com.stevehechio.apps.gads2020leaderboard.models.HoursObject;
import com.stevehechio.apps.gads2020leaderboard.models.SkillsObject;

import org.json.JSONObject;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LeadersAPI {
    @GET("api/hours")
   Observable<List<HoursObject>> getHourLeader();

    @GET("api/skilliq")
    Observable<List<SkillsObject>> getSkillLeader();

    @FormUrlEncoded

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    void submitProject(
            @Field("entry.1877115667") String firstName,
            @Field("entry.2006916086") String lastName,
            @Field("entry.1824927963") String emailAddress,
            @Field("entry.284483984") String link,
            Callback<JSONObject> callback
    );
}
