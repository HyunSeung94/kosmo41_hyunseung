package com.study.android.myproject;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class SingerAdapter extends BaseAdapter {
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    Context context;
    ArrayList<SingerItem> items = new ArrayList<>();

    public SingerAdapter(Context context){
        this.context= context;
    }

    public void addItem(SingerItem item){
        items.add(item);
    }

    @Override
    public int getCount(){
        return  items.size();
    }

    @Override
    public Object getItem(int position){
        return items.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }



    public void clear(){
        items.clear();
    }

    public View getView(int position, View convertView, ViewGroup parent){

        SingerItemView view = null;
        if(convertView == null)
        {
            view = new SingerItemView(context);
        } else {
            view = (SingerItemView) convertView;
        }

        final SingerItem item = items.get(position);
        view.setContents(item.getContents());



        return view;
    }
}
