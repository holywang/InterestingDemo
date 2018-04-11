package com.holy.interestingdemo.mp3player.receiver;

import android.app.Service;
import android.bluetooth.BluetoothClass;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.holy.interestingdemo.mp3player.service.MyMediaService;
import com.holy.interestingdemo.mp3player.view.MediaInterface;

/**
 * Created by DR on 2018/4/8.
 */

public class NPMp3Receiver extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        switch (action){
            case "music_play":

                break;
            case "music_last":


                break;
            case "music_next":

                break;
            case "music_finish":
                context.stopService(new Intent(context,MyMediaService.class));
                break;
        }
    }
}
