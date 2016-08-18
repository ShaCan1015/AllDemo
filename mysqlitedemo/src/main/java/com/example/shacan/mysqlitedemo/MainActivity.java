package com.example.shacan.mysqlitedemo;

import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.shacan.mysqlitedemo.bean.User;
import com.example.shacan.mysqlitedemo.dao.UserDAO;
import com.example.shacan.mysqlitedemo.db.SQLiteHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editID;
    private EditText editNAME;
    private ListView lv_content;

    private UserDAO dao;

    private List<User> userList;
    private Useradapter useradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        dao = new UserDAO(this);
        userList = new ArrayList<>();
        useradapter = new Useradapter(this,userList);
        //绑定适配器
        lv_content.setAdapter(useradapter);

    }
    //初始化控件
    private void initView() {
        editID = (EditText) findViewById(R.id.edit_id);
        editNAME = (EditText) findViewById(R.id.edit_name);
        lv_content = (ListView) findViewById(R.id.lv_content);
    }
    //点击事件
    public void click(View view){
        switch (view.getId()){
            case R.id.but_add:
                add();
                break;
            case R.id.but_del:
                del();
                break;
            case R.id.but_update:
                update();
                break;
            case R.id.but_query:
                query();
                break;
        }
    }

    //全查询
    private void query() {
        List<User> users = dao.query();
        //清空适配器的集合
        userList.clear();
        //合并集合
        userList.addAll(users);
        //刷新适配器
        useradapter.notifyDataSetChanged();

    }

    private void update() {
        String name = editNAME.getText().toString();
        String id = editID.getText().toString();
        User user = new User(Integer.valueOf(id),name);
        dao.upDate(user);
        query();
    }

    private void del() {
        String id = editID.getText().toString();
        dao.delete(Integer.valueOf(id));
        query();
    }

    private void add() {
        String name = editNAME.getText().toString();
        User user = new User();
        user.setName(name);
        dao.add(user);
        query();
    }
}
