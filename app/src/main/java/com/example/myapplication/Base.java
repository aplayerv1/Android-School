package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Base extends BaseAdapter {
    private Context context;
    private ListView lv;
    private TextView tv;
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
        convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false);

        tv = convertView.findViewById(R.id.rowTextView11);
        Log.d("Respond:","<Base> "+arr.get(i).getName());
        tv.setText(arr.get(i).getName());

        notifyDataSetChanged();
        return convertView;

    }
}
