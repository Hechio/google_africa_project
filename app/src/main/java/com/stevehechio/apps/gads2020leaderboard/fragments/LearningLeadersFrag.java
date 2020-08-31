package com.stevehechio.apps.gads2020leaderboard.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.stevehechio.apps.gads2020leaderboard.R;
import com.stevehechio.apps.gads2020leaderboard.adapters.LearningAdapter;
import com.stevehechio.apps.gads2020leaderboard.http.LeadersAPI;
import com.stevehechio.apps.gads2020leaderboard.http.RetrofitClient;
import com.stevehechio.apps.gads2020leaderboard.models.HoursObject;

import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class LearningLeadersFrag extends Fragment {
    private RecyclerView mRecyclerView;
    private LearningAdapter adapter;
    private ProgressBar progressBar;
    private LeadersAPI leadersAPI;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);
        collectIds(view);
        Retrofit retrofit = RetrofitClient.getInstance();
        leadersAPI = retrofit.create(LeadersAPI.class);
        fetchLeaders();
        return view;
    }

    private void collectIds(View root) {
        mRecyclerView = root.findViewById(R.id.rv_learning);
        progressBar = root.findViewById(R.id.pb);
    }

    private void fetchLeaders() {
    compositeDisposable.add(leadersAPI.getHourLeader()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this::setUpAdapter));
    }

    private void setUpAdapter(List<HoursObject> hoursObjects) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        adapter = new LearningAdapter(requireContext());
        adapter.setHoursObjects(hoursObjects);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(adapter);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onStop() {
        super.onStop();
        compositeDisposable.clear();
    }
}
