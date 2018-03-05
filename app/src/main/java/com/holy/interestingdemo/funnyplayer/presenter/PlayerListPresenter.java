package com.holy.interestingdemo.funnyplayer.presenter;

import com.holy.interestingdemo.funnyplayer.model.IPlayerListModel;
import com.holy.interestingdemo.funnyplayer.view.IPlayerView;

/**
 * Created by DR on 2018/3/5.
 */

public class PlayerListPresenter extends BasePresenter {
    private IPlayerListModel iPlayerListModel;
    private IPlayerView iPlayerView;

    public PlayerListPresenter(IPlayerView iPlayerView) {
        this.iPlayerView = iPlayerView;
    }

    public void setPlayerList(){

    }

    public void showWaitingDialog(){
        if (iPlayerView != null){
            iPlayerView.showWaitingDialog();
        }
    }

    public void dissmissWaitingDialog(){
        if (iPlayerView != null){
            iPlayerView.dissmissWaitingDialog();
        }
    }

}
