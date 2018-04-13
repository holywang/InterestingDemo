package com.holy.interestingdemo.mp3player.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.eventbusdemo.MessageEvent;
import com.holy.interestingdemo.mp3player.MusicPlayerActivity;
import com.holy.interestingdemo.mp3player.events.Mp3Event;
import com.holy.interestingdemo.mp3player.presenter.MediaPresenter;
import com.holy.interestingdemo.mp3player.view.MediaInterface;
import com.holy.interestingdemo.utils.L;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;

public class MyMediaService extends Service implements MediaInterface, MediaPlayer.OnPreparedListener {

    private final static String TAG = "media_service";
    private static MediaPlayer mediaPlayer;
    private MediaPresenter mediaPresenter;
    private boolean onPauseFlag = false;
    public static boolean isStop = false;
    private int pauseProgress = 0;
    private String url;

    @Override
    public void onCreate() {
        L.i(TAG, "progress on create a service");
        mediaPresenter = new MediaPresenter(this);
        mediaPresenter.initMedia();
        EventBus.getDefault().register(this);

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        url = intent.getStringExtra("url");
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

    private void startMediaPlayer() {
        try {
            mediaPresenter.initMedia();
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();
            mediaPresenter.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
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

    @Subscribe(sticky = true)
    public void onMessageEvent(MessageEvent event){
        if (event.getMessage().equals("stop")){
            stop();
            EventBus.getDefault().removeStickyEvent(event);
            stopSelf();
        }

    }

    @Subscribe(sticky = true)
    public void onMessageEvent(Mp3Event event) {
        switch (event.getFlag()) {
            case 1:
                play();
                EventBus.getDefault().removeStickyEvent(event);
                EventBus.getDefault().postSticky(new Mp3Event(6));
                break;
            case 2:
                pause();
                EventBus.getDefault().removeStickyEvent(event);
                break;
            case 3:
                String currentUrl1 = MusicPlayerActivity.musicPosition == 0 ? "" : MusicPlayerActivity.musicList.get(MusicPlayerActivity.musicPosition - 1).getAbsolutePath();
                if (currentUrl1.equals("")) {
                    Toast.makeText(this, "到头啦", Toast.LENGTH_SHORT).show();
                } else {
                    url = currentUrl1;
                    MusicPlayerActivity.musicPosition = MusicPlayerActivity.musicPosition-1;
                    stop();
                    startMediaPlayer();
                }

                EventBus.getDefault().removeStickyEvent(event);
                EventBus.getDefault().postSticky(new Mp3Event(6));
                break;
            case 4:
                String currentUrl2 = MusicPlayerActivity.musicPosition == MusicPlayerActivity.musicList.size() - 1 ? "" : MusicPlayerActivity.musicList.get(MusicPlayerActivity.musicPosition + 1).getAbsolutePath();
                if (currentUrl2.equals("")) {
                    Toast.makeText(this, "到头啦", Toast.LENGTH_SHORT).show();
                } else {
                    url = currentUrl2;
                    MusicPlayerActivity.musicPosition = MusicPlayerActivity.musicPosition+1;
                    stop();
                    startMediaPlayer();
                }
                EventBus.getDefault().removeStickyEvent(event);
                EventBus.getDefault().postSticky(new Mp3Event(6));
                break;
            case 5:
                stop();
                EventBus.getDefault().removeStickyEvent(event);
                break;
            default:
        }
    }
}
