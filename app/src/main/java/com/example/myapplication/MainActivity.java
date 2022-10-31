package com.example.myapplication;


import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
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
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                arr=jr.getData();

                Bundle bdl = new Bundle();

                bdl.putString("name", arr.get(i).getName());
                bdl.putString("height", arr.get(i).getHeight());
                bdl.putString("mass", arr.get(i).getMass());


                Log.d("Respond:", "<Main2>"+ bdl);


                if (findViewById(R.id.Frame)==null){

                    Fragment frag = new DetailsFragment();
                    getSupportFragmentManager().beginTransaction().add(R.id.Frame,frag).commit();

                }else{
                    setContentView(R.layout.fragment_details);

                }
            }
        });
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();




    }

}
