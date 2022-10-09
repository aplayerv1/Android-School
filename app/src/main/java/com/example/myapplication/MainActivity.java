package com.example.myapplication;


import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    boolean bo;
    ArrayList<data> arrayList = new ArrayList<>();
    Base adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab4);
        TextInputEditText tx = (TextInputEditText)findViewById(R.id.textInputEditText);
        ListView lv =(ListView)findViewById(R.id.listView);
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch sw = (Switch)findViewById(R.id.switch1);
        Button b = (Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                arrayList.add(new data(tx.getText().toString(),sw.isChecked()));
                if (arrayList!=null){
                    adapter = new Base(getApplicationContext(), arrayList);
                    lv.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }

            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                arrayList.remove(position);
                adapterView.notifyDatasetChange
                return false;
            }
        });


    }

}
