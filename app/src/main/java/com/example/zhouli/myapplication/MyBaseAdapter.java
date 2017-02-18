package com.example.zhouli.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by zhouli on 17/1/12.
 */
public class MyBaseAdapter extends ArrayAdapter<String>{
    private View preView;
    public MyBaseAdapter(Context context, int resource) {
        super(context, resource);
    }

    public MyBaseAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public MyBaseAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
    }

    public MyBaseAdapter(Context context, int resource, int textViewResourceId, String[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public MyBaseAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    public MyBaseAdapter(Context context, int resource, int textViewResourceId, List<String> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         Log.i("TAG_MyBaseAdapter","position:"+position);
        if(convertView!=null) {
            Log.i("TAG_MyBaseAdapter","getChildCount:"+parent.getChildCount());
            Log.i("TAG_MyBaseAdapter","positon："+position+"converView==preView"+(convertView==preView));
            preView = convertView;
        }
        return super.getView(position, convertView, parent);
    }
}
