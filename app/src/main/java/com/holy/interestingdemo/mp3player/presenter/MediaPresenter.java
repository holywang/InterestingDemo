package com.holy.interestingdemo.mp3player.presenter;

import com.holy.interestingdemo.mp3player.view.MediaInterface;

/**
 * Created by DR on 2018/4/4.
 */

public class MediaPresenter {

    private MediaInterface mediaController;

    public MediaPresenter(MediaInterface mediaController){
        this.mediaController = mediaController;
    }

    public void initMedia(){
        mediaController.initMedia();
    }

    public void play(){
        mediaController.play();
    }

    public void stop(){
        mediaController.stop();
    }

    public void pause(){
        mediaController.pause();
    }

    public void last(){

    }

    public void next(){

    }
}
