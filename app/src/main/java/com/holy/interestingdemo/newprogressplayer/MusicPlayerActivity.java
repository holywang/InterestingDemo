package com.holy.interestingdemo.newprogressplayer;

import android.content.Intent;
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
    }

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
