package com.example.shacan.mysqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2016/8/18 0018.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    public static final String DB_FILE_NAME = "user.db";
    public static final int VERSION = 1;
    private static final String TAG = "MySQLiteOpenHelper" ;

    /**
     * @param context 上下文
     */
    public MySQLiteOpenHelper(Context context) {
        super(context, DB_FILE_NAME, null, VERSION);
    }

    /**
     * 每一次打开数据库是都会调用
     * @param db
     */
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        Log.i(TAG,"--------open----");
    }


    /**
     * 第一打开数据库是在onOpen()之后调用
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表
        String sql = "CREATE TABLE USER(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,AGE INTEGER)";
        Log.i(TAG,"sql="+sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
