package com.example.zhouli.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.handmark.pulltorefresh.library.PullToRefreshListView;

/**
 * Created by zhouli on 16/11/6.
 */
public class MyCustomListView extends PullToRefreshListView{

    private View button;
    private View head;
    public MyCustomListView(Context context, Mode mode) {
        super(context, mode);
    }

    public MyCustomListView(Context context) {
        super(context);
    }

    public MyCustomListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setButton(View button) {
        this.button=button;
    }



    @Override
    protected boolean isReadyForPullStart() {
        View child=getRefreshableView().getChildAt(0);
        Log.i("TAG","Y:"+child.getY());
        return super.isReadyForPullStart()&&child.getY()==button.getHeight();
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        head=getHeaderLayout();
        super.onScrollChanged(l, t, oldl, oldt);
        Log.i("TAG","setTrantionY:"+button.getHeight());
        head.setTranslationY(button.getHeight());
    }
}
