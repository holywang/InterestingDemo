package com.holy.interestingdemo.funnyplayer.presenter;

import android.content.Context;
import android.util.Log;

import com.holy.interestingdemo.funnyplayer.model.IPlayerListModel;
import com.holy.interestingdemo.funnyplayer.model.PlayerListModelImpl;
import com.holy.interestingdemo.funnyplayer.view.IPlayerView;
import com.holy.interestingdemo.utils.MediaUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DR on 2018/3/5.
 */

public class PlayerListPresenter extends BasePresenter {
    private final static String TAG= "PlayerListPresenter";

    private IPlayerListModel iPlayerListModel;
    private IPlayerView iPlayerView;

    public PlayerListPresenter(IPlayerView iPlayerView) {
        this.iPlayerView = iPlayerView;
        iPlayerListModel = new PlayerListModelImpl();
    }

    public void getPlayerList(){
        iPlayerListModel.getPlayerList();
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

    /**
     * 从本地获取mp3文件
     * @param context
     * @return
     */
    public List<File> getMp3FileList (Context context){
        List<File> list = MediaUtil.getAudioFromLocalStorage(context);
        List<File> mp3List = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Log.i(TAG, list.get(i).getName());
            if (list.get(i).getName().endsWith(".mp3")) {
                mp3List.add(list.get(i));
            }
        }
        return mp3List;
    }

    /**
     * 从本地获取mp4文件
     * @param context
     * @return
     */
    public List<File> getMp4FileList (Context context){
        List<File> list = MediaUtil.getVideoFromLocalStorage(context);
        List<File> mp4List = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Log.i(TAG, list.get(i).getName());
            if (list.get(i).getName().endsWith(".mp4")) {
                mp4List.add(list.get(i));
            }
        }
        return mp4List;
    }

}
