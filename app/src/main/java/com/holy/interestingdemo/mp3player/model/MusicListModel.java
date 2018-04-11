package com.holy.interestingdemo.mp3player.model;

import android.content.Context;

import com.holy.interestingdemo.mp3player.model.interfaces.MusicInterface;
import com.holy.interestingdemo.utils.MediaUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DR on 2018/4/4.
 */

public class MusicListModel implements MusicInterface{

    @Override
    public List<File> getMp3List(Context context) {
        List<File> list = MediaUtil.getAudioFromLocalStorage(context);
        List<File> mp3List = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getName().endsWith(".mp3")) {
                mp3List.add(list.get(i));
            }
        }
        return mp3List;
    }
}
