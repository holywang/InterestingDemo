package com.holy.interestingdemo.mp3player;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RemoteViews;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.mp3player.model.MusicListModel;
import com.holy.interestingdemo.mp3player.service.MyMediaService;
import com.holy.interestingdemo.utils.MediaUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MusicPlayerActivity extends AppCompatActivity {

    private MusicListModel musicListModel;
    private Notification notification;
    private RemoteViews views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        buildMusicNotification();
        musicListModel = new MusicListModel();
        if (checkIfHaveMusic()) {
            Intent intent = new Intent(this, MyMediaService.class);
            intent.putExtra("url", musicListModel.getMp3List(this).get(0).getAbsolutePath());
            startService(intent);
        }
    }

    /**
     * 检查是否有music
     *
     * @return
     */
    private boolean checkIfHaveMusic() {
        List<File> list = MediaUtil.getAudioFromLocalStorage(this);
        List<File> mp3List = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().endsWith(".mp3")) {
                mp3List.add(list.get(i));
            }
        }
        if (mp3List.size() > 0) {
            return true;
        }
        return false;
    }

    private void buildMusicNotification() {
        views = new RemoteViews(getPackageName(), R.layout.music_notification);

        notification = new Notification();
        notification.icon = R.mipmap.ic_launcher_round;
        notification.contentView = views;

        Intent intentFinish = new Intent("music_finish");
        PendingIntent pIntentFinish = PendingIntent.getBroadcast(this, 0, intentFinish, 0);
        views.setOnClickPendingIntent(R.id.notification_finish, pIntentFinish);

        Intent intentPlay = new Intent("music_play");
        PendingIntent pIntentPlay = PendingIntent.getBroadcast(this, 0, intentPlay, 0);
        views.setOnClickPendingIntent(R.id.notification_music_play, pIntentPlay);

        Intent intentLast = new Intent("music_last");
        PendingIntent pIntentLast = PendingIntent.getBroadcast(this, 0, intentLast, 0);
        views.setOnClickPendingIntent(R.id.notification_music_play, pIntentLast);

        Intent intentNext = new Intent("music_next");
        PendingIntent pIntentNext = PendingIntent.getBroadcast(this, 0, intentNext, 0);
        views.setOnClickPendingIntent(R.id.notification_music_play, pIntentNext);

        notification.flags = notification.FLAG_NO_CLEAR;//设置通知点击或滑动时不被清除
//        application.notManager.notify(Const.NOTI_CTRL_ID, notification);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1,notification);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
