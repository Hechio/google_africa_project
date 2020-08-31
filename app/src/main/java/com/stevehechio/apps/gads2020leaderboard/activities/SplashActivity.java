package com.stevehechio.apps.gads2020leaderboard.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.stevehechio.apps.gads2020leaderboard.R;

public class SplashActivity extends AppCompatActivity implements Animation.AnimationListener {
    private ImageView mImageView;
    private Animation mAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        collectIds();
        setViewAnimation();

    }

    private void setViewAnimation() {
        mAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_zoom_in);
        mAnimation.setAnimationListener(this);
        mImageView.startAnimation(mAnimation);
    }

    private void collectIds() {
        mImageView = findViewById(R.id.iv_splash);
    }


    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == mAnimation) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}