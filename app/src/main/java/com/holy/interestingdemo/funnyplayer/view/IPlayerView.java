package com.holy.interestingdemo.funnyplayer.view;

/**
 * Created by DR on 2018/3/5.
 */

public interface IPlayerView {
    public void onInfoUpdate(String info);

    public void showWaitingDialog();

    public void dissmissWaitingDialog();
}
