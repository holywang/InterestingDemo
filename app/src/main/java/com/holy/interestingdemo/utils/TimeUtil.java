package com.holy.interestingdemo.utils;

import android.annotation.SuppressLint;

import com.holy.interestingdemo.mainInfo.MainApplication;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by DR on 2018/3/15.
 */
@SuppressLint("NewApi")
public class TimeUtil {

    private final static String TAG = MainApplication.APP_TAG + "TimeUtil";

    public static String changeToString(int time) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String timeStr = sdf.format(new Date(time));
        L.i(TAG, timeStr);
        return timeStr;
    }

//    public static String changeToString(int time) {
//        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());
//        return dateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
//    }
}
