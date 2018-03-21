package com.holy.interestingdemo.funnyplayer.presenter;


import android.media.MediaPlayer;
import android.view.View;

import com.holy.interestingdemo.funnyplayer.model.IPlayerListModel;
import com.holy.interestingdemo.funnyplayer.model.IVideoPlayModel;
import com.holy.interestingdemo.funnyplayer.model.PlayerListModelImpl;
import com.holy.interestingdemo.funnyplayer.view.IVideoPlay;

/**
 * Created by DR on 2018/3/21.
 */

public class VideoPlayerPresenter extends BasePresenter {

    private IVideoPlay iVideoPlay;
    private String playUrl;
    private IPlayerListModel playerListModel;
    private IVideoPlayModel videoPlayModel;


    public VideoPlayerPresenter(IVideoPlay iVideoPlay,String defaultUrl) {
        this.iVideoPlay = iVideoPlay;
        this.playUrl = defaultUrl;

        playerListModel = PlayerListModelImpl.getInstance();

    }

    /**
     * 设置播放Url
     * @param playUrl
     */
    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    /**
     * 开始播放新的视频
     */
    public void startNewVideo(){
        if (playUrl == null) {
            return;
        }
        iVideoPlay.mediaPlay(playUrl);
    }

    /**
     * 下一曲
     * @param view
     */
    public void next(View view){
        int i = ((PlayerListModelImpl)playerListModel).getCurrentPosition()+1;
        if (i > ((PlayerListModelImpl)playerListModel).getMediaList().size()) {
            iVideoPlay.showSnackBar(view,"当前已经是最后一个视频了");
            return;
        }
        ((PlayerListModelImpl)playerListModel).setCurrentPosition(i);
        iVideoPlay.mediaRelease();
        setPlayUrl(
                ((PlayerListModelImpl)playerListModel)
                        .getMediaList()
                        .get(((PlayerListModelImpl)playerListModel).getCurrentPosition())
                        .getAbsolutePath()
        );
        startNewVideo();
    }

    /**
     * 上一曲
     * @param view
     */
    public void last(View view){
        int i = ((PlayerListModelImpl)playerListModel).getCurrentPosition()-1;
        if (i < 0) {
            iVideoPlay.showSnackBar(view,"当前已经是第一个视频了");
            return;
        }
        ((PlayerListModelImpl)playerListModel).setCurrentPosition(i);
        iVideoPlay.mediaRelease();
        setPlayUrl(
                ((PlayerListModelImpl)playerListModel)
                        .getMediaList()
                        .get(((PlayerListModelImpl)playerListModel).getCurrentPosition())
                        .getAbsolutePath()
        );
        startNewVideo();
    }

    public void pause(){

    }
}
