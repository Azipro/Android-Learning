package com.example.thr;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class InternetActivity extends AppCompatActivity {

    TextView tv;
    MyTast myTask;
    ProgressBar bar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);

        tv = findViewById(R.id.tv1);
        tv.setMovementMethod(ScrollingMovementMethod.getInstance());
        String url = "https://github.com/";
        bar = findViewById(R.id.bar);
        myTask = new MyTast();
        myTask.execute(url);
    }

    class MyTast extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... strings) {
            String url = strings[0];
            HttpURLConnection conn = null;
            byte[] buf = new byte[1024];
            InputStream is;
            try {
                conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setDoInput(true);
                is = conn.getInputStream();
                int total = conn.getContentLength();
                ByteArrayOutputStream bis = new ByteArrayOutputStream();
                int count = 0;
                int length = -1;
                while ((length = is.read(buf)) != -1) {
                    bis.write(buf, 0, length);
                    publishProgress((int)((float)count/total*100));
                    count = count + length;
                }
                is.close();
                bis.close();
                return new String(bis.toByteArray(), "gb2312");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            bar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            bar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String bitmap) {
            bar.setVisibility(View.GONE);
            tv.setText(bitmap);
        }
    }
}
