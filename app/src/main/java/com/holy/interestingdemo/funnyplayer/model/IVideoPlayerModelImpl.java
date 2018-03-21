package com.holy.interestingdemo.funnyplayer.model;

/**
 * Created by DR on 2018/3/21.
 */

public class IVideoPlayerModelImpl implements IVideoPlayModel{

    private final static String TAG = "IVideoPlayerModelImpl";

    private static volatile IVideoPlayerModelImpl instance=null;

    private IVideoPlayerModelImpl(){}

    public static IVideoPlayerModelImpl getInstance(){
        if(instance==null){
            synchronized(PlayerListModelImpl .class){
                if(instance==null){
                    instance=new IVideoPlayerModelImpl();
                }
            }
        }
        return instance;
    }


}
