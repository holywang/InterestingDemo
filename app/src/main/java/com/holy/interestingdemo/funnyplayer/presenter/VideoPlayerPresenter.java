package com.holy.interestingdemo.funnyplayer.presenter;


import android.view.View;

import com.holy.interestingdemo.funnyplayer.model.IPlayerListModel;
import com.holy.interestingdemo.funnyplayer.model.IVideoPlayModel;
import com.holy.interestingdemo.funnyplayer.model.PlayerListModelImpl;
import com.holy.interestingdemo.funnyplayer.view.IVideoPlay;
import com.holy.interestingdemo.mainInfo.MainApplication;
import com.holy.interestingdemo.utils.L;

/**
 * Created by DR on 2018/3/21.
 */

public class VideoPlayerPresenter extends BasePresenter {

    private final static String TAG = MainApplication.APP_TAG + "VideoPlayerPresenter";

    private IVideoPlay iVideoPlay;
    private String playUrl;
    private IPlayerListModel playerListModel;
    private IVideoPlayModel videoPlayModel;


    public VideoPlayerPresenter(IVideoPlay iVideoPlay, String defaultUrl) {
        this.iVideoPlay = iVideoPlay;
        this.playUrl = defaultUrl;
        playerListModel = PlayerListModelImpl.getInstance();
    }

    /**
     * 设置播放Url
     *
     * @param playUrl
     */
    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    /**
     * 设置当前播放位置
     * @param currentPosition
     */
    public void setCurrentPosition(int currentPosition){
        ((PlayerListModelImpl) playerListModel).setCurrentPosition(currentPosition);
    }

    /**
     * 开始播放新的视频
     */
    public void startNewVideo() {
        if (playUrl == null) {
            return;
        }
        iVideoPlay.mediaPlay(playUrl);
    }

    /**
     * 下一曲
     *
     * @param view
     */
    public void next(View view) {
        int i = ((PlayerListModelImpl) playerListModel).getCurrentPosition();
        L.i(TAG, "current:::" + i);
        if (i > ((PlayerListModelImpl) playerListModel).getMediaList().size()) {
            iVideoPlay.showSnackBar(view, "当前已经是最后一个视频了");
            return;
        }
        i = i + 1;
        ((PlayerListModelImpl) playerListModel).setCurrentPosition(i);
        iVideoPlay.mediaRelease();
        setPlayUrl(
                ((PlayerListModelImpl) playerListModel)
                        .getMediaList()
                        .get(((PlayerListModelImpl) playerListModel).getCurrentPosition())
                        .getAbsolutePath()
        );
        startNewVideo();
    }

    /**
     * 上一曲
     *
     * @param view
     */
    public void last(View view) {
        int i = ((PlayerListModelImpl) playerListModel).getCurrentPosition();
        L.i(TAG, "current:::" + i);
        if (i <= 0) {
            iVideoPlay.showSnackBar(view, "当前已经是第一个视频了");
            return;
        }
        i = i - 1;
        ((PlayerListModelImpl) playerListModel).setCurrentPosition(i);
        iVideoPlay.mediaRelease();
        setPlayUrl(
                ((PlayerListModelImpl) playerListModel)
                        .getMediaList()
                        .get(((PlayerListModelImpl) playerListModel).getCurrentPosition())
                        .getAbsolutePath()
        );
        startNewVideo();
    }
}
