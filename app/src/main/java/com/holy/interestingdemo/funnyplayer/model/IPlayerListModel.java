package com.holy.interestingdemo.funnyplayer.model;

import android.content.Context;

import com.holy.interestingdemo.funnyplayer.model.bean.PlayerBean;

import java.io.File;
import java.util.List;

/**
 * Created by DR on 2018/3/5.
 */

public interface IPlayerListModel {

    /**
     * 获取所有Mp4文件
     * @param context
     * @return
     */
    List<File> getMp4List(Context context);

    /**
     * 获取所有Mp3文件
     * @param context
     * @return
     */
    List<File> getMp3List(Context context);


    /**
     * 获取一个媒体文件的PlayerBean的列表
     * @param context
     * @return
     */
    List<PlayerBean> getPlayerList(Context context);

}
