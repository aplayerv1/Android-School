package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_containt);
    }
    TextView t = (TextView) findViewById(R.id.textView);
    Button send = (Button) findViewById(R.id.button);
    View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            t.setVisibility(View.VISIBLE);
            send.setOnClickListener(listener);
        }
    };

}