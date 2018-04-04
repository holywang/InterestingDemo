package com.holy.interestingdemo.newprogressplayer.model.interfaces;

import android.content.Context;

import java.io.File;
import java.util.List;

/**
 * Created by DR on 2018/4/4.
 */

public interface MusicInterface {
    List<File> getMp3List(Context context);
}
