package com.holy.interestingdemo.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.holy.interestingdemo.BuildConfig;

/**
 * Created by DR on 2018/3/6.
 */

public class L {

    public static void e(@NonNull String TAG, @NonNull String msg, @Nullable Throwable throwable) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, msg, throwable);
        }
    }

    public static void i(String TAG, String msg) {
        if (BuildConfig.DEBUG) {
            Log.i(TAG, msg);
        }
    }

    public static void w(String TAG, String msg) {
        if (BuildConfig.DEBUG) {
            Log.w(TAG, msg);
        }
    }
}
