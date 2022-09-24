package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.annotation.SuppressLint;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;


import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Locale currentLocale;

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_containt);

        String str = getString(R.string.snackbar);
        String chk = getString(R.string.checked);

        setContentView(R.layout.activity_main_containt);

        Button b = (Button)findViewById(R.id.button);
        b.setOnClickListener(this);
        SwitchCompat sw = (SwitchCompat) findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(sw.isChecked()){


                }
                else {

                }
            }
        });


        CheckBox cb = (CheckBox)findViewById(R.id.checkBox);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton cb, boolean b) {
                        Snackbar sn = Snackbar.make(view, chk, 5000);
                        if (cb.isChecked()){
                            sn.show();
                        }
                        sn.setAction(str,click -> cb.setChecked(!b));
                    }
                });
            }
        });
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



}