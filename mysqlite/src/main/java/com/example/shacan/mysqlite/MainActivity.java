package com.example.shacan.mysqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MySQLiteOpenHelper mySQLiteOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view){
        switch (view.getId()){
            case R.id.but_init:
                init();
                break;
            case R.id.but_create:
                createtable();
                break;
            case R.id.but_add:
                add();
                break;
            case R.id.but_del:
                delete();
                break;
            case R.id.but_update:
                update();
                break;
            case R.id.but_sel:
                query();
                break;
        }
    }

    //查询数据
    private void query() {
        List<User> users = new ArrayList<>();
        //得到操作数据库文件的对象
        sqLiteDatabase = mySQLiteOpenHelper.getReadableDatabase();
        String sql = "select * from user";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        while (cursor.moveToNext()){
            User user = new User();
            user.setId(cursor.getInt(cursor.getColumnIndex("ID")));
            user.setName(cursor.getString(cursor.getColumnIndex("NAME")));
            user.setAge(cursor.getInt(cursor.getColumnIndex("AGE")));
            users.add(user);
        }
        Toast.makeText(MainActivity.this,users.toString(),Toast.LENGTH_SHORT).show();
        sqLiteDatabase.close();

    }

    //修改数据
    private void update() {
        //得到操作数据库文件的对象
        sqLiteDatabase = mySQLiteOpenHelper.getReadableDatabase();
        String sql = "UPDATE USER SET NAME ='shacan',AGE = 100 WHERE ID = 3";
        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.close();
    }

    //删除数据
    private void delete() {
        //得到操作数据库文件的对象
        sqLiteDatabase = mySQLiteOpenHelper.getReadableDatabase();
        String sql = "DELETE FROM USER WHERE ID = 1";
        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.close();
    }

    //添加数据
    private void add() {
        //得到操作数据库文件的对象
        sqLiteDatabase = mySQLiteOpenHelper.getReadableDatabase();
        String sql = "INSERT INTO USER (NAME,AGE) VALUES('CAN',23)";
        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.close();
    }

    //创建表
    private void createtable() {
        //得到操作数据库文件的对象
        sqLiteDatabase = mySQLiteOpenHelper.getReadableDatabase();
        String sql = "CREATE TABLE USER(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,AGE INTEGER)";
        //使用数据库操作对象发送SQL操作数据库
        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.close();
    }

    //初始化数据库
    private void init() {
        mySQLiteOpenHelper = new MySQLiteOpenHelper(this);
    }
}
