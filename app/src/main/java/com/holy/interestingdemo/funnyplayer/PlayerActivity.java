package com.holy.interestingdemo.funnyplayer;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.funnyplayer.presenter.PlayerListPresenter;
import com.holy.interestingdemo.funnyplayer.view.IPlayerView;

public class PlayerActivity extends PlayerBaseActivity implements IPlayerView {

    private PlayerListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        presenter = new PlayerListPresenter(this);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制横
        // 屏

        getWindow().setStatusBarColor(getColor(R.color.colorAccent));
        getWindow().setNavigationBarColor(getColor(R.color.colorAccent));
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
        getWindow()
                .getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_IMMERSIVE
                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                );
    }

    @Override
    public void onInfoUpdate(String info) {

    }

    @Override
    public void showWaitingDialog() {

    }

    @Override
    public void dissmissWaitingDialog() {

    }
}
