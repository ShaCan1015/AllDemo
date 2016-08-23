package com.example.shacan.sqlite_page;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shacan.sqlite_page.adapter.SQLiteAdapter;
import com.example.shacan.sqlite_page.bean.User;
import com.example.shacan.sqlite_page.dao.UserDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView text_page;
    private ListView lv_page;

    private List<User> userList;
    private SQLiteAdapter sqLiteAdapter;

    private UserDao dao;

    //分页
    private int currentPage = 1;
    private int pageSize = 50;
    private int totalPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化视图
        initView();
        userList = new ArrayList<>();
        //初始化适配器
        sqLiteAdapter = new SQLiteAdapter(userList, this);
        lv_page.setAdapter(sqLiteAdapter);
        dao = new UserDao(this);

        List<User> user = dao.query(currentPage, pageSize);
        userList.addAll(user);
        setNumPage();

    }

    private void initView() {
        text_page = (TextView) findViewById(R.id.text_page);
        lv_page = (ListView) findViewById(R.id.lv_page);

    }

    private void setNumPage() {
        //获得总行数
        int count = dao.queryPage();
        //总页数
        totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
        sqLiteAdapter.notifyDataSetChanged();
        text_page.setText(currentPage + "/" + totalPage);
    }

    //点击事件
    public void click(View view) {
        switch (view.getId()) {
            case R.id.but_init:
                init();
                break;
            case R.id.but_up:
                if (currentPage == 1) {
                    Toast.makeText(MainActivity.this, "已经是第一页了", Toast.LENGTH_SHORT).show();
                } else {
                    currentPage--;
                    List<User> users = dao.query(currentPage, pageSize);
                    userList.clear();//清空适配器
                    userList.addAll(users);
                    setNumPage();
                }
                break;
            case R.id.but_down:
                if (currentPage == totalPage) {
                    Toast.makeText(MainActivity.this, "已经是最后一页了", Toast.LENGTH_SHORT).show();
                } else {
                    currentPage++;
                    List<User> users = dao.query(currentPage, pageSize);
                    userList.clear();//清空适配器
                    userList.addAll(users);
                    setNumPage();
                }
                break;
        }
    }

    private void init() {
        for (int i = 1000; i < 1020; i++) {
            dao.add(new User("小明" + i, i));
        }
    }

}
