package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Base extends BaseAdapter {
    private Context context;
    private TextView name;
    private ListView test;
    private ArrayList<data> arrayList;


    public Base(Context context, ArrayList<data> arrayList) {
        this.arrayList = arrayList;
        this.context = context;

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false);

        name = convertView.findViewById(R.id.textView);


        name.setText(arrayList.get(position).getName() + position);


        name.setText(arrayList.get(position).getName());
        if (arrayList.get(position).getUrgent()) {
            convertView.setBackgroundColor(Color.RED);
        }
        notifyDataSetChanged();
        return convertView;
    }
}
