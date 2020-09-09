package com.example.appchonhinh13072020;

import android.os.CountDownTimer;

public class MyCountDown {
    private static MyCountDown myCountDown = null;
    private CountDownTimer mCountDown = null;
    private OnListenCountDown mOnListenCountDown = null;

    private MyCountDown(){

    }
    public static MyCountDown getInstance(){
        if (myCountDown == null){
            myCountDown = new MyCountDown();
        }
        return myCountDown;
    }

    public  void startCountDown(){
        if (mCountDown != null){
            mCountDown.cancel();
        }
        mCountDown = new CountDownTimer(AppConstant.TOTAL_TIME,AppConstant.COUNT_DOWN) {
            @Override
            public void onTick(long millisUntilFinished) {
                mOnListenCountDown.countDown((millisUntilFinished / 1000) - 1);
            }

            @Override
            public void onFinish() {
                mOnListenCountDown.onFinish();
            }
        };
        mCountDown.start();
    }
    public void onListenTime(OnListenCountDown mOnListenCountDown){
        this.mOnListenCountDown = mOnListenCountDown;
    }
}
