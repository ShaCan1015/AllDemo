package com.example.shacan.mysqlitedemo.dao;

import android.content.ContentValues;
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
public class UserDAO {
    private SQLiteHelper sqLiteHelper;
    private SQLiteDatabase db;

    public UserDAO(Context context) {
        sqLiteHelper = new SQLiteHelper(context);
    }

    public void add(User user) {
        //得到数据库操作对象
        db = sqLiteHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(Table.USER.NAME,user.getName());
        db.insert(Table.USER.TABLE_NAME,null,values);
        //关闭数据库
        db.close();
    }

    public void delete(int id) {
        //得到数据库操作对象
        db = sqLiteHelper.getReadableDatabase();
        //查询条件
        String whereClause = Table.USER.ID + "=?";
        //查询条件所对应的占位符
        String[] whereArgs = {id+""};
        db.delete(Table.USER.TABLE_NAME,whereClause,whereArgs);
        //关闭数据库
        db.close();

    }

    public void upDate(User user) {
        //得到数据库操作对象
        db = sqLiteHelper.getReadableDatabase();

        //更新的内容
        ContentValues values = new ContentValues();
        values.put(Table.USER.NAME,user.getName());

        //更新的位置
        String whereClause = Table.USER.ID +"=?";
        String[] whereArgs ={user.getId()+""};
        db.update(Table.USER.TABLE_NAME,values,whereClause,whereArgs);
        //关闭数据库
        db.close();

    }

    public List<User> query() {
        List<User> users = new ArrayList<>();
        //得到数据库操作对象
        db = sqLiteHelper.getReadableDatabase();
        Cursor cursor = db.query(Table.USER.TABLE_NAME,null,null,null,null,null,null);
        while (cursor.moveToNext()) {
            User user = new User(cursor.getInt(cursor.getColumnIndex(Table.USER.ID)), cursor.getString(cursor.getColumnIndex(Table.USER.NAME)));
            users.add(user);
        }
        db.close();
        return users;
    }
}
