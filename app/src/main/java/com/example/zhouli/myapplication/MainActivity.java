package com.example.zhouli.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyCustomListView mPullToRefreshListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button=(Button)findViewById(R.id.img);



        ArrayAdapter<String> arrayAdapter =
                new MyBaseAdapter(this,android.R.layout.simple_list_item_1,mockData());
        final PullToRefreshListView listView=(PullToRefreshListView) findViewById(R.id.listview);
        listView.setAdapter(arrayAdapter);
        mPullToRefreshListView=(MyCustomListView) listView;
        mPullToRefreshListView.setButton(button);
         listView.setOnScrollListener(new AbsListView.OnScrollListener() {
             @Override
             public void onScrollStateChanged(AbsListView view, int scrollState) {

             }

             @Override
             public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                 View child=view.getChildAt(0);
                 if(child!=null) {
                     Log.i("TAG", "listViewTOP:" + child.getY());
                     //button.setTranslationY();
                     button.setTranslationY(-(button.getHeight()-child.getY()));
                 }
             }
         });
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                startMockData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });


    }

    private List mockData() {
        List<String>list=new LinkedList<>();
        for(int i=0;i<100;i++) {
            list.add("回弹效果:"+i);
        }
        return list;
    }

    private void startMockData() {
       new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   Thread.sleep(1000);
                   runOnUiThread(new Runnable() {
                       @Override
                       public void run() {
                           HeaderViewListAdapter headerViewListAdapter=(HeaderViewListAdapter) mPullToRefreshListView.getRefreshableView().getAdapter();
                           ArrayAdapter arrayAdapter =(ArrayAdapter) headerViewListAdapter.getWrappedAdapter();
                           arrayAdapter.addAll(mockData());
                           arrayAdapter.notifyDataSetChanged();
                           mPullToRefreshListView.onRefreshComplete();
                       }
                   });
               }catch (InterruptedException e) {

               }
           }
       }).start();
    }
}
