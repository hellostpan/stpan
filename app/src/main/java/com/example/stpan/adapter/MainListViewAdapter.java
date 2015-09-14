package com.example.stpan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.stpan.activity.R;

/**
 * 功能：
 * 创建时间:2015/9/11 16:32
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class MainListViewAdapter extends BaseAdapter {
    private String[] strings;
    private Context context;

    public MainListViewAdapter(Context context,String[] strings) {
        this.context = context;
        this.strings = strings;
    }

    @Override
    public int getCount() {
        return strings==null?0:strings.length;
    }

    @Override
    public Object getItem(int position) {
        return strings[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder myHolder;
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_main,null);
            myHolder = new MyHolder();
            myHolder.textView = (TextView) convertView.findViewById(R.id.tv_item_list_main);
            convertView.setTag(myHolder);
        }else {
            myHolder = (MyHolder) convertView.getTag();
        }
        myHolder.textView.setText(strings[position]);
        return convertView;
    }

    private class MyHolder{
        private TextView textView;
    }
}
