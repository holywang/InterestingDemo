package com.holy.interestingdemo.utils;


import com.holy.interestingdemo.mainInfo.MainActivity;

/**
 * Created by holywang on 2018/7/25.
 */

public class DisplayUtils {

    public static int getScreenWidth()  {
        if (MainActivity.PhoneWidth != 0) {
            return MainActivity.PhoneWidth;
        }else{
          return 0;
        }
    }

    public static int getScreenHeight()  {
        if (MainActivity.PhoneHeight != 0) {
            return MainActivity.PhoneHeight;
        }else{
            return 0;
        }
    }
}
