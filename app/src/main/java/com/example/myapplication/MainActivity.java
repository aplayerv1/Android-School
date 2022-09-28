package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_MESSAGE =  "com.example.myapplication.MESSAGE";
    public int i = 0;
    public String msg;
    public SharedPreferences perf;


    @Override
    protected void onPause() {
        SharedPreferences.Editor editor = getSharedPreferences(msg, MODE_PRIVATE).edit();
        editor.putString("welcome", msg);
        editor.commit();
        super.onPause();
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab03);

        Button b = (Button)findViewById(R.id.button);
        b.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int i = 1;
        Intent intent = new Intent(this,NameActivity.class);
        if (i==1){
            EditText text = (EditText)findViewById(R.id.editTextTextPersonName);
            msg = text.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, msg);
            startActivity(intent);
        }

    }



}