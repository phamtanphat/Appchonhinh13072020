package com.example.appchonhinh13072020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;

import com.example.appchonhinh13072020.databinding.ActivityRandomBinding;

import java.util.List;
import java.util.Random;

public class RandomActivity extends AppCompatActivity {

    ActivityRandomBinding mBinding;
    Random mRandom;
    String[] mArrayNameAnimals;
    int mIdHinhRandom = -1;
    boolean mIsActive = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityRandomBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        init();
        randomImage();
        pickImage();
        // Task 1 : Thoi gian choi game
        // Task 2 : Random hinh anh
        // Task 3 : Chon hinh
    }

    private void pickImage() {
        mBinding.imgPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RandomActivity.this, ListAnimalActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        mRandom = new Random();
        mArrayNameAnimals = getResources().getStringArray(R.array.array_animals);
        mIsActive = true;
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
                if (mIsActive){
                    Log.d("BBB","Activity running");
                }else{
                    Log.d("BBB","Activity onstop");
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        mIsActive = false;
    }
}