package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Base extends BaseAdapter {
    private Context context;
    private ListView tv;
    private ArrayList<data> arr;


    public Base (Context context, ArrayList<data> arr){
        this.context = context;
        this.arr = arr;
    }
    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int i) {
        return arr.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("ResourceType")
    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.activity_main, parent, false);

        tv = convertView.findViewById(R.id.ListView);

//        tv.setText(arr.get(i).getName() + i);
//        tv.setText(arr.get(i).getName());
        List<String> str = new ArrayList<>();
        for(int ii=0;ii<arr.size();ii++){
            str.add(String.valueOf(arr.get(ii).getName()+ii));
        }

        ArrayAdapter<String> ard = new ArrayAdapter<String>(context.getApplicationContext(), R.id.ListView,str);
        tv.setAdapter(ard);
        return convertView;

    }
}
