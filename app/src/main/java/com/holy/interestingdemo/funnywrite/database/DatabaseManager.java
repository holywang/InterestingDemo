package com.holy.interestingdemo.funnywrite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by DR on 2018/2/9.
 */

public class DatabaseManager {

    private Context context;

    DatabaseOpenHelper openHelper;
    private SQLiteDatabase database;

    public DatabaseManager(Context context){
        this.context = context;
        openHelper = new DatabaseOpenHelper(context);
        database = openHelper.getWritableDatabase();
    }

    /**
     * 插入一条数据
     * @param table
     * @param values
     * @return 失败返回-1
     */
    public long insert(String table,ContentValues values){
        return database.insert(table,null,values);
    }

    /**
     * 根 根据条件查询
     * @param table 数据库表名
     * @param columns 要查询的列名 （静态变量）
     * @param where_what 选择条件  （静态变量）
     * @param where_args_what 选择条件实参
     * @param orderBy 排序字符串
     * @return 以传入表名为键的 ArrayList<HashMap<String,Object>>
     */
    public Cursor query(String table,String[] columns,String where_what,String[] where_args_what,String orderBy){
        Cursor cs = database.query(table,columns,where_what,where_args_what,null,null,orderBy);
        return cs;
    }

    /**
     * 查询表中所有数据
     * @param table 表名
     * @return
     */
    public Cursor queryAll(String table){
        Cursor cs = database.rawQuery("select * from "+table,new String[]{});
        return cs;
    }

    /**
     * 删除方法
     * @param table 表名
     * @param where 索引字段
     * @param whereArg 字段内容
     * @return
     */
    public int delete(String table,String where,String[] whereArg){
        return database.delete(table,where,whereArg);
    }


}
