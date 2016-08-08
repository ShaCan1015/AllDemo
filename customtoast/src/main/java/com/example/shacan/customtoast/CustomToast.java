package com.example.shacan.customtoast;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Administrator on 2016/8/7 0007.
 *   自定的toast  ，封装
 */
public class CustomToast {

    private Toast toast;
    private Context context;
    private static CustomToast customToast;
    //    静态工厂
    public  static  CustomToast newIntance(){
        if(customToast==null){
            customToast=new CustomToast();
        }
        return customToast;
    }

    /**
     *   显示toast 内容的
     * @param context
     * @param tvContent   toast 的内容
     */
    public void showToast(Context context,String tvContent){
        View view = LayoutInflater.from(context).inflate(R.layout.item_toast,null);
        TextView textView= (TextView) view.findViewById(R.id.tv_content);
        textView.setText(tvContent);
        toast=new Toast(context);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

}
