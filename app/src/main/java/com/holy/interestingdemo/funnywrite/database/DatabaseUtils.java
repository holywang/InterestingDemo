package com.holy.interestingdemo.funnywrite.database;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DR on 2018/2/9.
 */

public class DatabaseUtils {

    /**
     * 将传入数组填进ContentValues
     * @param keys 键数组
     * @param values 值数组
     * @return 生成的ContentValues对象
     */
    public static ContentValues putValue(String[] keys, String[] values){
        if(keys.length != values.length)
            return null;
        ContentValues cv = new ContentValues();
        for (int i = 0; i < keys.length; i++) {
            cv.put(keys[i],values[i]);
        }
        return cv;
    }

    /**
     * 区分表名 处理查询的Cursor
     * @param cs 查询到的Cursor
     * @param table 表名
     * @return
     */
    public static List<Map<String ,String>> getList (Cursor cs, String table){
        switch (table){
            case DatabaseConstant.NOVEL_INFO_TABLE:
                return dealCursor(cs,DatabaseConstant.NOVEL_INFO_ARRAY);
            case DatabaseConstant.NOVEL_CONTEXT_TABLE:
                return dealCursor(cs,DatabaseConstant.NOVEL_CONTEXT_ARRAY);
            default:
                return null;
        }
    }

    /**
     * 将Cursor处理成List
     * @param cs 传进来的Cursor
     * @param tableArr 表的字段名数组
     * @return 处理后的List
     */
    private static List<Map<String ,String>> dealCursor(Cursor cs,String[] tableArr){
        List<Map<String ,String>> list = new ArrayList<>();

        if (cs != null && cs.moveToFirst()) {
            do {
                Map<String ,String> map = new HashMap<>();
                for (int i = 0; i < tableArr.length; i++) {
                    map.put(tableArr[i],cs.getString(cs.getColumnIndex(tableArr[i])));
                }
                list.add(map);
            } while (cs.moveToNext());
        }
        return list;
    }
}
