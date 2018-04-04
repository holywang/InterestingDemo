package com.holy.interestingdemo.newprogressplayer.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.newprogressplayer.presenter.MediaPresenter;
import com.holy.interestingdemo.newprogressplayer.view.MediaInterface;
import com.holy.interestingdemo.utils.L;

import java.io.IOException;

public class MyMediaService extends Service implements MediaInterface, MediaPlayer.OnPreparedListener {

    private final static String TAG = "media_service";

    private static MediaPlayer mediaPlayer;
    private static Notification notification;

    private MediaPresenter mediaPresenter;

    private boolean onPauseFlag = false;
    private boolean isStop = false;
    private int pauseProgress = 0;

    @Override
    public void onCreate() {
        L.i(TAG, "progress on create a service");
        mediaPresenter = new MediaPresenter(this);
        mediaPresenter.initMedia();

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String url = intent.getStringExtra("url");
        try {
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.setDataSource(url);
                mediaPlayer.prepareAsync();
                mediaPresenter.play();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void initMedia() {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setLooping(true);
    }

    @Override
    public void play() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            isStop = false;
        }
    }

    @Override
    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public void pause() {
        if (onPauseFlag == false) {
            mediaPlayer.pause();
            onPauseFlag = true;
            pauseProgress = mediaPlayer.getCurrentPosition();
            isStop = true;
        } else {
            mediaPlayer.seekTo(pauseProgress + 1);
            mediaPlayer.start();
            onPauseFlag = false;
            isStop = false;
        }
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.play();
    }
}
