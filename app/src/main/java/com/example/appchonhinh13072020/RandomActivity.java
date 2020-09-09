package com.example.appchonhinh13072020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;

import com.example.appchonhinh13072020.databinding.ActivityRandomBinding;

import java.util.Random;

public class RandomActivity extends AppCompatActivity {

    ActivityRandomBinding mBinding;
    CountDownTimer mTimer;
    Random mRandom;
    String[] mArrayNameAnimals;
    int mIdHinhRandom = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityRandomBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        init();
        randomImage();
        // Task 1 : Thoi gian choi game
        // Task 2 : Random hinh anh
        // Task 3 : Chon hinh
    }

    private void init() {
        mRandom = new Random();
        mArrayNameAnimals = getResources().getStringArray(R.array.array_animals);
    }
    private void randomImage() {
        int index = mRandom.nextInt(mArrayNameAnimals.length);
        mIdHinhRandom = getResources().getIdentifier(
                mArrayNameAnimals[index],
                "drawable",
                getPackageName());
        mBinding.imgRandom.setImageResource(mIdHinhRandom);
        MyCountDown.getInstance().startCountDown();
        MyCountDown.getInstance().onListenTime(new OnListenCountDown() {
            @Override
            public void countDown(long time) {
                mBinding.tvTime.setText(String.format("Time : %ds",time));
            }

            @Override
            public void onFinish() {

            }
        });
    }


}