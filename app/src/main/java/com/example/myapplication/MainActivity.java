package com.example.myapplication;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
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
    public String msg = "";
    public SharedPreferences perf;
    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result != null || result.getResultCode()== RESULT_OK) {
                if(result.getResultCode()==1){
                    System.exit(0);
                }
            }
        }
    });

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

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg = String.valueOf(text.getText());
                intent.putExtra(EXTRA_MESSAGE, msg);
                startForResult.launch(intent);
            }
        });


    }


}