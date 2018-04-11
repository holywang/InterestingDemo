package com.holy.interestingdemo.mp3player.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.holy.interestingdemo.mp3player.service.MyMediaService;
import com.holy.interestingdemo.mp3player.view.MediaInterface;

/**
 * Created by DR on 2018/4/8.
 */

public class NPMp3Receiver extends BroadcastReceiver {

    private MediaInterface mediaInterface;

    @Override
    public void onReceive(Context context, Intent intent) {
        mediaInterface = new MyMediaService();
        String action = intent.getAction();
        switch (action){
            case "music_play":
                if (MyMediaService.isStop){
                    mediaInterface.play();
                }else{
                    mediaInterface.pause();
                }
                break;
            case "music_last":


                break;
            case "music_next":

                break;
            case "music_finish":

                break;
        }
    }
}
