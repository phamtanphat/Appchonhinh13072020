package com.example.appchonhinh13072020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;

import com.example.appchonhinh13072020.databinding.ActivityRandomBinding;

public class RandomActivity extends AppCompatActivity {

    ActivityRandomBinding mBinding;
    CountDownTimer mTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityRandomBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        init();
        startTime();
        // Task 1 : Thoi gian choi game
        // Task 2 : Random hinh anh
        // Task 3 : Chon hinh
    }

    private void init() {
    }

    private void startTime() {
        if (mTimer != null){
            mTimer.cancel();
            mTimer = new CountDownTimer() {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {

                }
            };
        }
    }
}