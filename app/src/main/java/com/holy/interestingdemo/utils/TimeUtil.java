package com.holy.interestingdemo.utils;

import android.annotation.SuppressLint;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Created by DR on 2018/3/15.
 */
@SuppressLint("NewApi")
public class TimeUtil {

//    public static String changeToString(long time) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        return sdf.format(new Date(time));
//    }

    public static String changeToString(int time) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());
//        LocalDateTime dateTime = LocalDateTime.now().withNano(time);
        return dateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
