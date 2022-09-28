package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NameActivity extends AppCompatActivity {
    public SharedPreferences perf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView t = (TextView)findViewById(R.id.textView2);
        t.setText(getString(R.string.welcome)+" "+message);
        Button bbb = (Button)findViewById(R.id.button3);
        bbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("welcome", MODE_PRIVATE).edit();
                editor.putString("welcome",null);
                editor.apply();
                Intent intent = new Intent();
                setResult(1, intent);
                finish();
            }
        });
        Button bb = (Button)findViewById(R.id.button2);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = 1;
                SharedPreferences.Editor editor = getSharedPreferences("welcome", MODE_PRIVATE).edit();
                editor.putInt("y",i);
                editor.apply();
                Intent intent = new Intent();
                setResult(0, intent);
                finish();
            }
        });


    }
}