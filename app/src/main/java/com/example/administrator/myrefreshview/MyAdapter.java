package com.example.administrator.myrefreshview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/1/19.
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<String> datas;

    public MyAdapter(Context context,List<String> datas) {
        this.context = context;
        this.datas=datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item,null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        textView.setText(datas.get(position));
        return convertView;
    }
}
