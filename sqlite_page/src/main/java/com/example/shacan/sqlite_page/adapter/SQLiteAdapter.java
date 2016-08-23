package com.example.shacan.sqlite_page.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shacan.sqlite_page.R;
import com.example.shacan.sqlite_page.bean.User;

import java.util.List;

/**
 * Created by Administrator on 2016/8/23 0023.
 */
public class SQLiteAdapter extends BaseAdapter {
    private List<User> userList;
    private Context mContext;
    private LayoutInflater inflater;

    public SQLiteAdapter(List<User> userList, Context mContext) {
        this.userList = userList;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return userList != null ? userList.size():0;
    }

    @Override
    public Object getItem(int position) {
        return userList != null ? userList.get(position) : null;
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
            convertView = inflater.inflate(R.layout.item_page,parent,false);
            viewHolder.text_id = (TextView) convertView.findViewById(R.id.text_id);
            viewHolder.text_name = (TextView) convertView.findViewById(R.id.text_name);
            viewHolder.text_age= (TextView) convertView.findViewById(R.id.text_age);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.text_id.setText(String.valueOf(userList.get(position).getId()));
        viewHolder.text_name.setText(userList.get(position).getName());
        viewHolder.text_age.setText(String.valueOf(userList.get(position).getAge()));
        return convertView;
    }
    public static class ViewHolder{
        public TextView text_id;
        public TextView text_name;
        public TextView text_age;
    }
}
