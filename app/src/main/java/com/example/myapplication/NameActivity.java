package com.example.myapplication;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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
                editor.commit();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
        Button bb = (Button)findViewById(R.id.button2);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = 1;
                SharedPreferences.Editor editor = getSharedPreferences("welcome", MODE_PRIVATE).edit();
                editor.putInt("y",i);
                editor.commit();
                System.exit(0);
            }
        });


    }
}