package com.example.myapplication;

import static java.lang.Boolean.TRUE;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_containt);
        Button b = (Button)findViewById(R.id.button);
        b.setOnClickListener(this);
        CheckBox cb = (CheckBox)findViewById(R.id.checkBox);
       // cb.setOnCheckedChangeListener();
    }

    @Override
    public void onClick(View view) {
        TextView t = (TextView)findViewById(R.id.textView);
        EditText tt = (EditText)findViewById(R.id.TextInput);
        String s = String.valueOf(tt.getText());
        t.setText(s);
        String st = getResources().getString(R.string.toast_fr);
        Toast.makeText(getApplicationContext(), st, Toast.LENGTH_SHORT).show();

    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }
}