package com.holy.interestingdemo.funnywrite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.holy.interestingdemo.funnywrite.database.DatabaseConstant.DATABASE_NAME;
import static com.holy.interestingdemo.funnywrite.database.DatabaseConstant.NOVEL_CONTEXT_CREATE;
import static com.holy.interestingdemo.funnywrite.database.DatabaseConstant.NOVEL_INFO_CREATE;

/**
 * Created by DR on 2018/2/9.
 */

public class DatabaseOpenHelper extends SQLiteOpenHelper {


    private static int TABLE_VERSION=1;

    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, TABLE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(NOVEL_INFO_CREATE);
        sqLiteDatabase.execSQL(NOVEL_CONTEXT_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
