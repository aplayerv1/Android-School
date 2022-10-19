package com.example.myapplication;


import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity  {
    String BASE_URL = "https://cataas.com";
    String com, line;



    private class ImageDownloadTask extends AsyncTask<String, Integer, String> {
        ImageView iv;
        ProgressBar pg;
        Bitmap bitmap;
        ImageDownloadTask(ImageView iv, ProgressBar pb){
            this.iv=iv;
            this.pg=pb;
        }
        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            while (true) {
                try{
                    URL url = new URL(params[0]);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.connect();
                    InputStream stream = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(stream));
                    StringBuffer buffer = new StringBuffer();

                    while((line = reader.readLine()) != null){
                        buffer.append(line+"\n");
                        Log.d("Response: ","> "+ line);

                    }

                    //FETCH IMAGE?
                    JSONObject json = null;
                    try {
                        json = new JSONObject(String.valueOf(buffer));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String team = null;
                    try {
                        team = json.getString("url");
                        com = BASE_URL+team;
                        Log.d("Response: ", "> " + com);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    try {
                        bitmap = BitmapFactory.decodeStream(new URL(com).openConnection().getInputStream());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }  finally {

                    if(connection != null){
                        connection.disconnect();
                    }
                    try {
                        if (reader != null){
                            reader.close();
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < 100; i++) {
                    try {
                        publishProgress(i);
                        Thread.sleep(30);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        @Override
        protected void onProgressUpdate(Integer... values){
            iv.setImageBitmap(bitmap);
            pg.setProgress(values[0]);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab4);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        ProgressBar pb = (ProgressBar)findViewById(R.id.progressBar2);
        new ImageDownloadTask(imageView,pb).execute("https://cataas.com/cat?json=true");

    }

}
