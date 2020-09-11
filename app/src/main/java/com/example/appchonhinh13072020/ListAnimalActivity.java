package com.example.appchonhinh13072020;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TableRow;

import com.example.appchonhinh13072020.databinding.ActivityListAnimalBinding;

public class ListAnimalActivity extends AppCompatActivity {
    String[] mArrayNameAnimals;
    ActivityListAnimalBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityListAnimalBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        init();
        drawImageAnimals();
    }

    private void drawImageAnimals() {
        for (int soDong = 1 ; soDong <= 6 ; soDong++){
            TableRow tableRow = new TableRow(this);
            for (int soCot = 1 ; soCot <= 3 ; soCot++){
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(R.drawable.bocanhcung);
                tableRow.addView(imageView);
            }
            mBinding.tableLayoutList.addView(tableRow);
        }

    }

    private void init() {
        mArrayNameAnimals = getResources().getStringArray(R.array.array_animals);
    }
}