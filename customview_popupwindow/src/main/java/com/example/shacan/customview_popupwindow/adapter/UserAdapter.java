package com.example.shacan.customview_popupwindow.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shacan.customview_popupwindow.R;

import java.util.List;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class UserAdapter extends BaseAdapter {
    private List<String> data;
    private Context mContext;
    private LayoutInflater inflater;

    public UserAdapter(List<String> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return data != null ? data.size():0;
    }

    @Override
    public Object getItem(int position) {
        return data != null? data.get(position):null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler viewHodler = null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_popupwindow_content,parent,false);
            viewHodler = new ViewHodler();
            viewHodler.tv_phone = (TextView) convertView.findViewById(R.id.tv_phone);
            viewHodler.iv_del = (ImageView) convertView.findViewById(R.id.iv_del);
            convertView.setTag(viewHodler);
        }else {
            viewHodler = (ViewHodler) convertView.getTag();
        }

        viewHodler.tv_phone.setText(data.get(position));
        //设置删除事件
        final int position1 = position;
        viewHodler.iv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.remove(position1);
                //刷新适配器
                notifyDataSetChanged();
            }
        });
        return convertView;
    }
    public static class ViewHodler{
        ImageView imageView;
        TextView tv_phone;
        ImageView iv_del;
    }
}
