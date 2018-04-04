package com.holy.interestingdemo.mainInfo;

import android.app.Application;

import com.holy.interestingdemo.utils.L;

/**
 * Created by DR on 2018/2/5.
 */

public class MainApplication extends Application {

    public final static String APP_TAG = "HolyWangInterestingDemo---";

    @Override
    public void onCreate() {
        super.onCreate();

        int pid = android.os.Process.myPid();

        L.i(APP_TAG,"on create progress ID = "+pid);

    }
}
