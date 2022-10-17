package com.example.myapplication;


import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
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
        Sql sql = new Sql(MainActivity.this,2);
       // sql.onUpgrade( sql.getDB(),4,5);
        arrayList = sql.getTasks();
        adapter = new Base(getApplicationContext(), arrayList);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        Resources res = getResources();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // arrayList.add(new data(tx.getText().toString(),sw.isChecked()));
                sql.addTasks(tx.getText().toString(),sw.isChecked());
                arrayList = sql.getTasks();
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
                new AlertDialog.Builder(MainActivity.this).setTitle(R.string.mesg)
                        .setMessage(String.format(res.getString(R.string.row), position+1))
                                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        //arrayList.remove(position);
                                        sql.removeTask(arrayList.get(position).getId());
                                        arrayList = sql.getTasks();
                                        adapter = new Base(getApplicationContext(), arrayList);
                                        lv.setAdapter(adapter);
                                        adapter.notifyDataSetChanged();
                                    }
                                }).setNegativeButton(R.string.no,null).show();

                return false;
            }
        });


    }

}
