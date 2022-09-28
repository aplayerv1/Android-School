package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity{
    public static final String EXTRA_MESSAGE =  "com.example.myapplication.MESSAGE";
    public int i = 0;
    public String msg;
    public SharedPreferences perf;

    @Override
    protected void onPause() {
        SharedPreferences.Editor editor = getSharedPreferences("welcome", MODE_PRIVATE).edit();
        editor.putString("welcome", msg);
        editor.putInt("welcome",i);
        editor.commit();
        super.onPause();
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab03);
        EditText text = (EditText)findViewById(R.id.editTextTextPersonName);
        Button b = (Button)findViewById(R.id.button);
        Intent intent = new Intent(this, NameActivity.class);
        perf = getSharedPreferences("welcome", MODE_PRIVATE);
        String str = null;
        str = perf.getString("welcome", str);
        if(str == null) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    msg = String.valueOf(text.getText());
                    intent.putExtra(EXTRA_MESSAGE, msg);
                    startActivity(intent);
                }
            });
        }
        else {
            int k = 0;
            k = perf.getInt("welcome", k);
            if (k == 1){
            EditText texts = (EditText)findViewById(R.id.editTextTextPersonName);
            String gt = null;
            gt = perf.getString("welcome",gt );
            texts.setText(gt);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        msg = String.valueOf(text.getText());
                        intent.putExtra(EXTRA_MESSAGE, msg);
                        startActivity(intent);
                    }
                });
            }

        }

    }


}