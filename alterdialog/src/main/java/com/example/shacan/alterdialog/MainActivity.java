package com.example.shacan.alterdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //设置列表
    String[] item = {"阿森纳","曼城","切尔西","皇马","巴萨","利物浦","拜仁","多特","尤文图斯",
            "米兰"};
    boolean[] checkeditems = {true,true,true,true,true,true,true,true,true,true};
    private ArrayAdapter<String> adapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void click(View view){
        switch (view.getId()){
            case R.id.btn_button01:
                btn_button01();
                break;
            case R.id.btn_button02:
                btn_button02();
                break;
            case R.id.btn_button03:
                btn_button03();
                break;
            case R.id.btn_button04:
                btn_button04();
                break;
            case R.id.btn_button05:
                btn_button05();
                break;
            case R.id.btn_button06:
                btn_button06();
                break;
        }
    }

    /**
     * 自定view的弹出框
     */
    private void btn_button06() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("我是标题");
        builder.setIcon(R.mipmap.ic_launcher);
        //添加自定义布局
        View view = getLayoutInflater().inflate(R.layout.customview,null);
        final EditText username = (EditText) view.findViewById(R.id.edt_userName);
        final EditText psw = (EditText) view.findViewById(R.id.edt_mima);
        builder.setView(view);
        //添加确定按钮
        builder.setPositiveButton("确定",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,username.getText(),Toast.LENGTH_LONG).show();

            }
        });
        builder.show();
    }

    /**
     * 多选按钮弹出框
     */
    private void btn_button05() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("我是标题");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMultiChoiceItems(item,checkeditems,null);
        //增加确定按钮
        builder.setPositiveButton("确定",null);
        builder.show();
    }

    /**
     * 弹出框——arrayAdapter
     */
    private void btn_button04() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("我是标题");
        builder.setIcon(R.mipmap.ic_launcher);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,item);
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,item[which],Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    /**
     * 单选按钮的弹出框
     *
     */
    private void btn_button03() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("带有列表的对话框");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setSingleChoiceItems(item,0, new DialogInterface.OnClickListener() {
            //参数2：表示默认选中
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,item[which],Toast.LENGTH_SHORT).show();
            }
        });
        //增加确定按钮
        builder.setPositiveButton("确定",null);
        builder.show();
    }

    /**
     * 带有列表的对话框
     *
     */

    private void btn_button02() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("带有列表的对话框");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setItems(item, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,item[which],Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    private void btn_button01() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog alertDialog = builder.create();
        alertDialog.setTitle("设置标题");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setMessage("这是一个对话框");
        //设置点击周围不能取消
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"中立",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE,"取消",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        //显示对话框
        alertDialog.show();
    }
}
