package com.holy.interestingdemo.utils;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DR on 2018/3/6.
 */

public class MediaUtil {

    /**
     * 获取音频文件列表
     * @param context
     * @return
     */
    public static List<File> getAudioFromLocalStorage(Context context) {
        List<File> list = new ArrayList<>();
        Cursor cursor = context.getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                new String[] { MediaStore.Audio.Media._ID, MediaStore.Audio.Media.DISPLAY_NAME, MediaStore.Audio.Media.TITLE,
                        MediaStore.Audio.Media.DURATION, MediaStore.Audio.Media.ARTIST, MediaStore.Audio.Media.ALBUM,
                        MediaStore.Audio.Media.YEAR, MediaStore.Audio.Media.MIME_TYPE, MediaStore.Audio.Media.SIZE,
                        MediaStore.Audio.Media.DATA }, null, new String[] {}, null);
        while (cursor.moveToNext()) {
            String filePath = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
//            Logger.i(TAG, "filePath==" + filePath);
//            String fileName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
//            Logger.i(TAG, "fileName==" + fileName);
            File file = new File(filePath);
            list.add(file);
        }
        return list;
    }

    /**
     * 获取所有视频文件
     * @param context
     * @return
     */
    public static List<File> getVideoFromLocalStorage(Context context) {
        List<File> list = new ArrayList<>();
        Cursor cursor = context.getContentResolver().query(
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                new String[] { MediaStore.Video.Media._ID, MediaStore.Video.Media.DISPLAY_NAME, MediaStore.Video.Media.TITLE,
                        MediaStore.Video.Media.DURATION,MediaStore.Video.Media.MIME_TYPE, MediaStore.Video.Media.SIZE,
                        MediaStore.Video.Media.DATA }, null, new String[] {}, null);
        while (cursor.moveToNext()) {
            String filePath = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA));
//            Logger.i(TAG, "filePath==" + filePath);
//            String fileName = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME));
//            Logger.i(TAG, "fileName==" + fileName);
            File file = new File(filePath);
            list.add(file);
        }
        return list;
    }

    public static float changeToMB(long inputByte){
        float output = (inputByte / 1000)/1024;
        return (float)(Math.round(output*100))/100;
    }
}
