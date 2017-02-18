package com.example.zhouli.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ListView;

public class BounceListView extends ListView {
    private static final int MAX_Y_OVERSCROLL_DISTANCE = 200;

    public BounceListView(Context context) {
        super(context);
    }

    public BounceListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BounceListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public BounceListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        Log.i("TAG","deltaX:"+deltaX);
        Log.i("TAG","dektay:"+deltaY);
        Log.i("TAG","scrollX:"+scrollX);
        Log.i("TAG","scrollY:"+scrollY);
        Log.i("TAG","scrollRangeX:"+scrollRangeX);
        Log.i("TAG","scrollRangeY:"+scrollRangeY);
        Log.i("TAG","maxOverScrollerX:"+maxOverScrollX);
        Log.i("TAG","maxOverScrollerY:"+maxOverScrollY);;
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, 500, 500, 500, isTouchEvent);
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
        scrollTo(scrollX,scrollY);
        Log.i("TAG_OverScrolled","scrollX:"+scrollX);
        Log.i("TAG_OverScrolled","scrollY:"+scrollY);
        Log.i("TAG_OverScrolled","clampedX:"+clampedX);
        Log.i("TAG_OverScrolled","clampedY:"+clampedY);
    }
}

