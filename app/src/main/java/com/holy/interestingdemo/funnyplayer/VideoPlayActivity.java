package com.holy.interestingdemo.funnyplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.holy.interestingdemo.R;

public class VideoPlayActivity extends PlayerBaseActivity {

    private Button backBtn;
    private Intent dataIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        setDefaultSetting();
        initView();
        setListener();

    }

    private void setDefaultSetting(){
        dataIntent = getIntent();
        getWindow()
                .getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_IMMERSIVE
                                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    private void initView(){
        backBtn = findViewById(R.id.video_player_back);
    }

    private void setListener(){
        backBtn.setOnClickListener(view -> {
            finish();
        });
    }
}
