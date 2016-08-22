package com.example.shacan.mysqlitedemo.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.shacan.mysqlitedemo.bean.User;
import com.example.shacan.mysqlitedemo.constant.Table;
import com.example.shacan.mysqlitedemo.db.SQLiteHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/18 0018.
 */
public class UserDAO2 {
    private SQLiteHelper sqLiteHelper;
    private SQLiteDatabase db;

    public UserDAO2(Context context) {
        sqLiteHelper = new SQLiteHelper(context);
    }

    public void add(User user) {
        //得到数据库操作对象
        db = sqLiteHelper.getReadableDatabase();
        String sql = "INSERT INTO " + Table.USER.TABLE_NAME + "(" + Table.USER.NAME + ") VALUES ('" + user.getName() + "')";
        db.execSQL(sql);
        //关闭数据库
        db.close();
    }

    public void delete(int id) {
        //得到数据库操作对象
        db = sqLiteHelper.getReadableDatabase();
        String sql = "DELETE FROM " + Table.USER.TABLE_NAME + " WHERE " + Table.USER.ID + "=" + id;
        db.execSQL(sql);
        //关闭数据库
        db.close();

    }

    public void upDate(User user) {
        //得到数据库操作对象
        db = sqLiteHelper.getReadableDatabase();
        String sql = "UPDATE " + Table.USER.TABLE_NAME + " SET " + Table.USER.NAME + "='" + user.getName() + "' WHERE " + Table.USER.ID + "=" + user.getId();
        db.execSQL(sql);
        //关闭数据库
        db.close();

    }

    public List<User> query() {
        List<User> users = new ArrayList<>();
        //得到数据库操作对象
        db = sqLiteHelper.getReadableDatabase();
        String sql = "select * from " + Table.USER.TABLE_NAME;
        String[] selectionArgs = {};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            User user = new User(cursor.getInt(cursor.getColumnIndex(Table.USER.ID)), cursor.getString(cursor.getColumnIndex(Table.USER.NAME)));
            users.add(user);
        }
        db.close();
        return users;
    }
}
