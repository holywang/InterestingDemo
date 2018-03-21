package com.holy.interestingdemo.funnyplayer.model;

import android.content.Context;

import com.holy.interestingdemo.utils.L;
import com.holy.interestingdemo.utils.MediaUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DR on 2018/3/5.
 */

public class PlayerListModelImpl implements IPlayerListModel{

    private final static String TAG = "PlayerListModelImpl";

    private static volatile PlayerListModelImpl instance=null;

    private List<File> mediaList;

    private int currentPosition;

    private PlayerListModelImpl(){

    }

    public static PlayerListModelImpl getInstance(){
        if(instance==null){
            synchronized(PlayerListModelImpl .class){
                if(instance==null){
                    instance=new PlayerListModelImpl();
                }
            }
        }
        return instance;
    }

    public List<File> getMediaList() {
        if (mediaList == null){
            return new ArrayList<>();
        }
        return mediaList;
    }

    public void setMediaList(List<File> mediaList) {
        this.mediaList = mediaList;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    @Override
    public List<File> getMp4List(Context context) {
        List<File> list = MediaUtil.getVideoFromLocalStorage(context);
        List<File> mp4List = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            L.i(TAG, list.get(i).getName());
            if (list.get(i).getName().endsWith(".mp4")) {
                mp4List.add(list.get(i));
            }
        }
        return mp4List;
    }

    @Override
    public List<File> getMp3List(Context context) {
        List<File> list = MediaUtil.getAudioFromLocalStorage(context);
        List<File> mp3List = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            L.i(TAG, list.get(i).getName());
            if (list.get(i).getName().endsWith(".mp3")) {
                mp3List.add(list.get(i));
            }
        }
        return mp3List;
    }
}
