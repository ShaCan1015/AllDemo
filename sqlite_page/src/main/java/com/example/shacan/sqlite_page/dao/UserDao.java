package com.example.shacan.sqlite_page.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.shacan.sqlite_page.bean.User;
import com.example.shacan.sqlite_page.constant.Table;
import com.example.shacan.sqlite_page.db.SQLiteHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/23 0023.
 */
public class UserDao {
    private SQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase db;

    public UserDao(Context context) {
        sqLiteOpenHelper = new SQLiteHelper(context);
    }

    /**
     * 添加数据
     *
     * @param user
     */
    public void add(User user) {
        //得到数据库的操作对象
        db = sqLiteOpenHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(Table.USER.NAME, user.getName());
        values.put(Table.USER.AGE, user.getAge());
        db.insert(Table.USER.TABLE_NAME, null, values);
        //关闭数据库
        db.close();
    }

    /**
     * 查询数据
     *
     * @return
     */
    public List<User> query(int currentPage, int pageSize) {
        List<User> userList = new ArrayList<>();
        db = sqLiteOpenHelper.getReadableDatabase();
        String limit = (currentPage - 1) * pageSize + "," + pageSize;
        Cursor cursor = db.query(Table.USER.TABLE_NAME, null, null, null, null, null,null, limit);
        while (cursor.moveToNext()) {
            User user = new User(cursor.getInt(cursor.getColumnIndex(Table.USER.ID)), cursor.getString(cursor.getColumnIndex(Table.USER.NAME)),
                    cursor.getInt(cursor.getColumnIndex(Table.USER.AGE)));
            userList.add(user);
        }
        db.close();
        return userList;
    }
    public int queryPage(){
        int num = 0;
        db = sqLiteOpenHelper.getReadableDatabase();
        String sql = "SELECT COUNT(1) counts FROM "+Table.USER.TABLE_NAME;//统计一列的总行数
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor.moveToNext()){
            num = cursor.getInt(cursor.getColumnIndex("counts"));
        }
        db.close();
        return num;
    }
}
