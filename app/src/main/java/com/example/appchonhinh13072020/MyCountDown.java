package com.example.appchonhinh13072020;

import android.os.CountDownTimer;

public class MyCountDown {
    public static CountDownTimer mCountDown = null;

    public static void startCountDown(final OnListenCountDown onListenCountDown){
        if (mCountDown != null){
            mCountDown.cancel();
        }
        mCountDown = new CountDownTimer(AppConstant.TOTAL_TIME,AppConstant.COUNT_DOWN) {
            @Override
            public void onTick(long millisUntilFinished) {
                onListenCountDown.countDown((millisUntilFinished / 1000) - 1);
            }

            @Override
            public void onFinish() {

            }
        };
        mCountDown.start();
    }

}
