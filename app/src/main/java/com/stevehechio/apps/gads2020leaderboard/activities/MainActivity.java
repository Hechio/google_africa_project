package com.stevehechio.apps.gads2020leaderboard.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.stevehechio.apps.gads2020leaderboard.R;
import com.stevehechio.apps.gads2020leaderboard.adapters.SectionsPagerAdapter;
import com.stevehechio.apps.gads2020leaderboard.fragments.LearningLeadersFrag;
import com.stevehechio.apps.gads2020leaderboard.fragments.SkillIQLeadersFrag;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        collectIds();
        setUpViews();

    }
    private void collectIds() {
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.view_pager);
    }

    private void setUpViews() {
        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager(), 1);
        adapter.addFragment(new LearningLeadersFrag(), getString(R.string.learning_leader));
        adapter.addFragment(new SkillIQLeadersFrag(), getString(R.string.skill_iq_leaders));
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
    }

    public void toSubmitActivity(View view) {
        startActivity(new Intent(getApplicationContext(),SubmitActivity.class));
    }
}