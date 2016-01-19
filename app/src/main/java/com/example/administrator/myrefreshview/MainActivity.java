package com.example.administrator.myrefreshview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现上拉刷新
 * 获取listView最后一个条目 判断最后一条是否在滑动中并且完全出来，
 * 也就是判断listview最后一条的getBottom()是否小于listview的高度
 */
public class MainActivity extends AppCompatActivity implements AbsListView.OnScrollListener {


    private ListView listView;
    private boolean isLoading;
    private boolean is;
    private List<String> datas;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datas=new ArrayList<>();
        listView = ((ListView) findViewById(R.id.listView));
        adapter = new MyAdapter(this,datas);
        listView.setAdapter(adapter);
        listView.setOnScrollListener(this);
        initDatas();
    }

    private void initDatas() {
        for (int i = 0; i < 20; i++) {
            datas.add("==="+i);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState==SCROLL_STATE_IDLE&&is){

            Log.i("fenye","分页了");
            isLoading=true;
            is=false;
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
       if (firstVisibleItem+visibleItemCount==totalItemCount){
           View childAt = view.getChildAt(visibleItemCount - 1);//得到最后一个条目

           if (childAt!=null&&childAt.getBottom()<=view.getHeight()&&!isLoading){

                is=true;
               isLoading=true;
           }else{
               is=false;
               isLoading=false;
           }
       }
    }
}
