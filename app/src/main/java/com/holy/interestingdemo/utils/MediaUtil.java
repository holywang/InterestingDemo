package com.holy.interestingdemo.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;

import com.holy.interestingdemo.funnyplayer.model.bean.PlayerBean;

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

    /**
     * 获取一个媒体文件的PlayerBean的列表
     * @param context
     * @return
     */
    public static List<PlayerBean> getVideoToPlayerBean(Context context){
        List<PlayerBean> list = new ArrayList<>();
        Cursor cursor = context.getContentResolver().query(
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                new String[] { MediaStore.Video.Media._ID, MediaStore.Video.Media.DISPLAY_NAME, MediaStore.Video.Media.TITLE,
                        MediaStore.Video.Media.DURATION,MediaStore.Video.Media.MIME_TYPE, MediaStore.Video.Media.SIZE,
                        MediaStore.Video.Media.DATA }, null, new String[] {}, null);
        cursor.moveToFirst();

        do{
            PlayerBean pb = new PlayerBean();
            pb.setId(cursor.getLong(cursor.getColumnIndex(MediaStore.Video.Media._ID)));
            pb.setName(cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DISPLAY_NAME)));
            pb.setTitle(cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.TITLE)));
            pb.setSize(cursor.getFloat(cursor.getColumnIndex(MediaStore.Video.Media.SIZE)));
            pb.setType(cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.MIME_TYPE)));
            pb.setUrl(cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA)));
            pb.setDuration(cursor.getLong(cursor.getColumnIndex(MediaStore.Video.Media.DURATION)));
            list.add(pb);
        } while (cursor.moveToNext());

        return list;
    }

    /**
     * 字节切换成MB
     * @param inputByte
     * @return
     */
    public static float changeToMB(long inputByte){
        float output = (inputByte / 1000)/1024;
        return (float)(Math.round(output*100))/100;
    }

    /**
     * 通过ID获取视频缩略图
     * @param id
     * @return
     */
    public static Bitmap getMiniPicById(Long id,Context context){
        ContentResolver cr = context.getContentResolver();
        BitmapFactory.Options options = new BitmapFactory.Options();
        return MediaStore.Video.Thumbnails.getThumbnail(cr, id, MediaStore.Video.Thumbnails.MINI_KIND, options);
    }
}
