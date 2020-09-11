package com.example.appchonhinh13072020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.example.appchonhinh13072020.databinding.ActivityListAnimalBinding;

import java.util.Arrays;
import java.util.Collections;

public class ListAnimalActivity extends AppCompatActivity {
    String[] mArrayNameAnimals;
    ActivityListAnimalBinding mBinding;
    int idHinh = 0 ;
    int vitri = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityListAnimalBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        init();
        drawImageAnimals();
    }
    private void drawImageAnimals() {
        for (int soDong = 1; soDong <= Math.ceil((double) mArrayNameAnimals.length / 3); soDong++) {
            TableRow tableRow = new TableRow(this);
            for (int soCot = 1; soCot <= 3; soCot++) {
                vitri = 3 * (soDong - 1) + soCot - 1;
                if (mArrayNameAnimals.length == vitri){
                    break;
                }else{
                    final ImageView imageView = new ImageView(this);
                    idHinh = getResources().getIdentifier(
                            mArrayNameAnimals[vitri],
                            "drawable",
                            getPackageName());
                    imageView.setImageResource(idHinh);
                    imageView.setTag(idHinh);
//                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams();
//                    layoutParams.setMargins(20,0,0,0);
//                    imageView.setLayoutParams(layoutParams);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent();
                            intent.putExtra("idHinh",Integer.parseInt(imageView.getTag().toString()));
                            setResult(RESULT_OK , intent);
                            finish();
                        }
                    });
                    tableRow.addView(imageView);
                }
            }
            mBinding.tableLayoutList.addView(tableRow);
        }
    }

    private void init() {
        mArrayNameAnimals = getResources().getStringArray(R.array.array_animals);
        Collections.shuffle(Arrays.asList(mArrayNameAnimals));
    }
}