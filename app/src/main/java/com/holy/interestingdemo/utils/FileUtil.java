package com.holy.interestingdemo.utils;

import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by DR on 2018/4/20.
 */

public class FileUtil {
    public static final String TAG = "FileUtil";
    public static final String NOVEL_DIR = "novels";

    /**
     * 新建一个小说
     * @param novelName 小说名
     * @param fileName 章节名称（文件名）
     * @return 文件File
     */
    public static File createNovelFile(String novelName,String fileName) {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()
                + NOVEL_DIR
                + File.separator
                + novelName
                + File.separator;
        File tocPath = new File(path);
        if (!tocPath.exists()) {
            tocPath.mkdir();
        }

        String filePath = tocPath.getAbsolutePath()+fileName+".txt";
        return new File(filePath);
    }

    /**
     *把文字写入文件
     * @param file 被写入的文件
     * @param info 文字
     * @return 是否成功
     */
    public static boolean writeInfoIntoFile(File file , String info){
        try {
            PrintStream ps = new PrintStream(new FileOutputStream(file));
            ps.println(info);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
