package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

class jsonRead extends AsyncTask<String, Integer, String> {
    String BaseURL = "https://swapi.dev/api/people/?format=json";
    String line;
    ListView lv;
    Context context;
    ArrayList<data> data = new ArrayList<>();

    jsonRead(Context context, ListView lv){
        this.context = context;
        this.lv = lv;
    }


    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection connection = null;
        BufferedReader reader;
        try {
            URL url = new URL(BaseURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            while ((line = reader.readLine()) != null){
                buffer.append(line+'\n');
            }
            JSONObject json = null;
            try {
                json = new JSONObject(String.valueOf(buffer));
            } catch (JSONException e) {
                e.printStackTrace();
            }

            try {
                JSONArray jars = json.getJSONArray("results");
                for(int i = 0;i< jars.length();i++){
                    data.add(new data(jars.getJSONObject(i).getString("name"),
                            jars.getJSONObject(i).getString("height"),
                            jars.getJSONObject(i).getString("mass")));
                    Log.d("Results: "," Other " + data.get(i).getMass()  );
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        publishProgress();
        return null;
    }
    @Override
    public void onProgressUpdate(Integer...values){
        Log.d("Respond",">>>>"+data.toString());
        Base base = new Base(context, data);
        lv.setAdapter(base);
        base.notifyDataSetChanged();
    }
    public ArrayList getData(){
        return this.data;
    }

}