package com.example.myapplication;


import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    ArrayList<data> arr = new ArrayList<>();
    private Context mContext;
    boolean isTablet = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView lv = (ListView) findViewById(R.id.ListView);

         jsonRead jr = new jsonRead(getApplicationContext(),lv);
         jr.execute();

        Base adapter = new Base(this,arr);

        Log.d("Respond:", "<Main>"+arr+adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                arr=jr.getData();

                Bundle bdl = new Bundle();

                bdl.putString("name", arr.get(i).getName());
                bdl.putString("height", arr.get(i).getHeight());
                bdl.putString("mass", arr.get(i).getMass());
                DetailsFragment fragment = new DetailsFragment();
                fragment.setArguments(bdl);
                Boolean str = checkIsTablet();
                Log.d("Respond:", "<Main2>"+ isTablet + " "+str);

                if (isTablet == false){

                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                    intent.putExtras(bdl);
                    startActivity(intent);

                }else{

                    androidx.fragment.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.layout, fragment);
                    transaction.commit();

          }
            }
        });
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();




    }
    private boolean checkIsTablet() {
        Display display = ((Activity) this).getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        float widthInches = metrics.widthPixels / metrics.xdpi;
        float heightInches = metrics.heightPixels / metrics.ydpi;
        double diagonalInches = Math.sqrt(Math.pow(widthInches, 2) + Math.pow(heightInches, 2));
        Log.d("Results",">>>   " +display+" "+diagonalInches);
        if (diagonalInches >=6.0) {
            isTablet = true;
        }

        return isTablet;
    }

}
