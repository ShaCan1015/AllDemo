package com.example.shacan.mysqlitedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shacan.mysqlitedemo.bean.User;

import java.util.List;

/**
 * Created by Administrator on 2016/8/19 0019.
 */
public class Useradapter extends BaseAdapter {
    private List<User> userList;
    private Context mContext;
    private LayoutInflater inflater;

    public Useradapter(Context mContext, List<User> userList) {
        this.mContext = mContext;
        this.userList = userList;
        this.inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return userList != null? userList.size():0;
    }

    @Override
    public Object getItem(int position) {
        return userList != null? userList.get(position):null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_listview_user,null);
            viewHolder.text_id = (TextView) convertView.findViewById(R.id.text_id);
            viewHolder.text_name = (TextView) convertView.findViewById(R.id.text_name);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.text_id.setText(userList.get(position).getId()+"");
        viewHolder.text_name.setText(userList.get(position).getName());
        return convertView;
    }
    public static class ViewHolder{
        private TextView text_id;
        private TextView text_name;
    }
}
