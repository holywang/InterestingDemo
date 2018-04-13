package com.holy.interestingdemo.mp3player;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.eventbusdemo.MessageEvent;
import com.holy.interestingdemo.mp3player.events.Mp3Event;
import com.holy.interestingdemo.mp3player.model.MusicListModel;
import com.holy.interestingdemo.mp3player.service.MyMediaService;
import com.holy.interestingdemo.mp3player.view.MediaInterface;
import com.holy.interestingdemo.utils.MediaUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MusicPlayerActivity extends AppCompatActivity implements MediaInterface {

    private MusicListModel musicListModel;
    private Notification notification;
    private RemoteViews views;
    private ImageView last, next, playOrPause, headImage;
    private TextView notification_music_name,notification_music_info;
    private Button stop;

    public static int musicPosition = 0;
    public static List<File> musicList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        EventBus.getDefault().register(this);
        musicListModel = new MusicListModel();
        musicList =musicListModel.getMp3List(this);

        last = findViewById(R.id.notification_music_last);
        next = findViewById(R.id.notification_music_next);
        playOrPause = findViewById(R.id.notification_music_play);
        headImage = findViewById(R.id.notification_head_image);
        notification_music_name = findViewById(R.id.notification_music_name);
        notification_music_info = findViewById(R.id.notification_music_info);
        stop =findViewById(R.id.mp3_player_stop);
        last.setOnClickListener(clickListener);
        next.setOnClickListener(clickListener);
        playOrPause.setOnClickListener(clickListener);
        headImage.setOnClickListener(clickListener);
        stop.setOnClickListener(clickListener);

        if (checkIfHaveMusic()) {
            setMusicInfo();
            Intent intent = new Intent(this, MyMediaService.class);
            intent.putExtra("url",musicList.get(musicPosition).getAbsolutePath());
            startService(intent);
        }
    }

    private View.OnClickListener clickListener = view -> {
        switch (view.getId()) {
            case R.id.notification_music_last:
                EventBus.getDefault().postSticky(new Mp3Event(3));
                break;
            case R.id.notification_music_next:
                EventBus.getDefault().postSticky(new Mp3Event(4));
                break;
            case R.id.notification_music_play:
                EventBus.getDefault().postSticky(new Mp3Event(2));
                break;
            case R.id.notification_head_image:
                EventBus.getDefault().postSticky(new Mp3Event(5));
                break;
            case R.id.mp3_player_stop:
                EventBus.getDefault().postSticky(new MessageEvent("stop"));
                break;
        }
    };

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
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


    @Override
    public void initMedia() {

    }

    @Override
    public void play() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void pause() {

    }

    @Subscribe(sticky = true)
    public void onMessageEvent(Mp3Event event) {
        switch (event.getFlag()) {
            case 6:
                setMusicInfo();
                EventBus.getDefault().removeStickyEvent(event);
                break;
        }
    }

    private void setMusicInfo(){
        headImage.setImageResource(R.mipmap.ic_launcher_round);
        notification_music_name.setText(musicList.get(musicPosition).getName());
        notification_music_info.setText(musicList.get(musicPosition).getPath());
    }
}
