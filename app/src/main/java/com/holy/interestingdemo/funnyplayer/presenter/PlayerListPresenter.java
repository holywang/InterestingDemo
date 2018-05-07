package com.holy.interestingdemo.funnyplayer.presenter;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;

import com.holy.interestingdemo.funnyplayer.model.IPlayerListModel;
import com.holy.interestingdemo.funnyplayer.model.PlayerListModelImpl;
import com.holy.interestingdemo.funnyplayer.view.IPlayerView;
import com.holy.interestingdemo.utils.L;
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
        iPlayerListModel = PlayerListModelImpl.getInstance();
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
        List<File> mp3List = iPlayerListModel.getMp3List(context);
        return mp3List;
    }

    /**
     * 从本地获取mp4文件
     * @param context
     * @return
     */
    public List<File> getMp4FileList (Context context){
        List<File> mp4List = iPlayerListModel.getMp4List(context);
        return mp4List;
    }

    /**
     * 给Model里的List赋值
     * @param filesList
     */
    public void setList(List<File> filesList){
        ((PlayerListModelImpl) iPlayerListModel).setMediaList(filesList);
    }

    /**
     * 获取当前MediaList
     * @return
     */
    public List<File> getMediaList(){
        return ((PlayerListModelImpl) iPlayerListModel).getMediaList();
    }

    @Override
    public boolean showLoading(ViewGroup rootView) {
        return false;
    }
}
