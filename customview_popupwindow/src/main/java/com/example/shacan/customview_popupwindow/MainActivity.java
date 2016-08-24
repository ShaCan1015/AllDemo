package com.example.shacan.customview_popupwindow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.example.shacan.customview_popupwindow.adapter.UserAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EditText editText;
    private ImageView iv_up;

    private List<String> data;
    private UserAdapter userAdapter;

    //弹出框
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        userAdapter = new UserAdapter(data,MainActivity.this);
        initListener();
    }
    private void initView() {
        editText = (EditText) findViewById(R.id.et_content);
        iv_up = (ImageView) findViewById(R.id.iv_up);
    }
    private void initData() {
        data = new ArrayList<>();
        for (int i = 1;i<20;i++){
            data.add("13036128404"+i);
        }
    }
    private void initListener() {
        iv_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建弹出框对象
                popupWindow = new PopupWindow(MainActivity.this);
                //获取焦点
                popupWindow.setFocusable(true);
                //设置弹出窗的宽和高
                popupWindow.setWidth(editText.getWidth());
                popupWindow.setHeight(300);
                //获取弹出框对象里面的布局
                ListView view = (ListView) getLayoutInflater().inflate(R.layout.popupwindow_view,null);
                //绑定适配器
                view.setAdapter(userAdapter);
                //点击周围 弹出框消失
                popupWindow.setOutsideTouchable(true);
                popupWindow.setContentView(view);
                //弹出框的位置
                popupWindow.showAsDropDown(editText);
                view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        editText.setText(data.get(position));
                        popupWindow.dismiss();
                    }
                });
            }
        });
    }

}
