package com.holy.interestingdemo.newprogressplayer;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.newprogressplayer.model.MusicListModel;
import com.holy.interestingdemo.newprogressplayer.service.MyMediaService;
import com.holy.interestingdemo.utils.MediaUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MusicPlayerActivity extends AppCompatActivity {

    private MusicListModel musicListModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        musicListModel = new MusicListModel();

        if(checkIfHaveMusic()){
            Intent intent = new Intent(this,MyMediaService.class);
            intent.putExtra("url",musicListModel.getMp3List(this).get(0).getAbsolutePath());
            startService(intent);
        }

//        Notification notification = new Notification.Builder(this)
//                .setSmallIcon(R.mipmap.ic_launcher)//设置小图标
//                .setContentTitle("这是标题")
//                .setContentText("这是内容")
//                .setAutoCancel(true)
//                .build();
//        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        notificationManager.notify(0, notification);

    }

    /**
     * 检查是否有music
     * @return
     */
    private boolean checkIfHaveMusic(){
        List<File> list = MediaUtil.getAudioFromLocalStorage(this);
        List<File> mp3List = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().endsWith(".mp3")) {
                mp3List.add(list.get(i));
            }
        }
        if(mp3List.size() >0){
            return true;
        }
        return false;
    }
}
