package com.holy.interestingdemo.funnyplayer.model;

import android.content.Context;

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

}
