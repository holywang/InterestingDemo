package com.holy.interestingdemo.funnywrite.database;

/**
 * Created by DR on 2018/2/9.
 */
public class DatabaseConstant {
    //数据库名
    public static final String DATABASE_NAME = "NovelDatabase";
    //数据库 表名
    public static final String NOVEL_INFO_TABLE = "NovelInfo";
    public static final String NOVEL_CONTEXT_TABLE = "NovelContext";

    //数据库 NovelInfo表 字段数组
    public static final String[] NOVEL_INFO_ARRAY = {"novel_id","novel_name","novel_author","novel_style","novel_description","novel_image"};
    //数据库 NovelInfo表 创建语句
    public static final String  NOVEL_INFO_CREATE = "CREATE TABLE "
            +NOVEL_INFO_TABLE+" (" +
            "novel_id int," +
            "novel_name varchar(255)," +
            "novel_author varchar(255)," +
            "novel_style varchar(255)," +
            "novel_description varchar(255)," +
            "novel_image varchar(255))";

    //数据库 NovelContext表 字段数组
    public static final String[] NOVEL_CONTEXT_ARRAY = {"novel_id","context_id","novel_session","novel_page","novel_context"};
    //数据库 NovelContext表 创建语句
    public static final String  NOVEL_CONTEXT_CREATE = "CREATE TABLE "
            +NOVEL_CONTEXT_TABLE+" (" +
            "novel_id int," +
            "context_id varchar(255)," +
            "novel_session varchar(255)," +
            "novel_page varchar(255)," +
            "novel_context varchar(255))";
}
