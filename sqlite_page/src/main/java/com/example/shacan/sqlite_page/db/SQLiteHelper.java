package com.example.shacan.sqlite_page.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.shacan.sqlite_page.constant.Table;

/**
 * Created by Administrator on 2016/8/23 0023.
 */
public class SQLiteHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "user.db";
    public static final int VERSION = 1;

    private static final String TAG ="SQLiteHelper" ;

    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表
        String sql = "CREATE TABLE "+ Table.USER.TABLE_NAME+" ("+Table.USER.ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+Table.USER.NAME+" TEXT,"
                +Table.USER.AGE+" INTEGER )";
        Log.i(TAG,"sql===="+sql);
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
