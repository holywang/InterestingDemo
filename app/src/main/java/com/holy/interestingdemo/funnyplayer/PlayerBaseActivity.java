package com.holy.interestingdemo.funnyplayer;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by DR on 2018/3/5.
 */

public class PlayerBaseActivity extends Activity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制横屏
//
//        getWindow().setStatusBarColor(getColor(R.color.colorAccent));
//        getWindow().setNavigationBarColor(getColor(R.color.colorAccent));
//        getWindow()
//                .getDecorView()
//                .setSystemUiVisibility(
//                        View.SYSTEM_UI_FLAG_IMMERSIVE
//                                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                                | View.SYSTEM_UI_FLAG_FULLSCREEN
//                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//         getWindow()
//                .getDecorView()
//                .setSystemUiVisibility(
//                        View.SYSTEM_UI_FLAG_IMMERSIVE
//                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                );

    }



}
