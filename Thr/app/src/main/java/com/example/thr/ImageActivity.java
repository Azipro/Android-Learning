package com.example.thr;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ImageActivity extends AppCompatActivity {
    ImageView imageView;
    MyTast myTask;
    ProgressBar bar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imageView = findViewById(R.id.imageView);
        String url = "https://static.runoob.com/images/demo/demo2.jpg";
        bar = findViewById(R.id.bar);
        myTask = new MyTast();
        myTask.execute(url);
    }

    class MyTast extends AsyncTask<String, Integer, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... strings) {
            String url = strings[0];
            HttpURLConnection conn = null;
            byte[] buf = new byte[10];
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
                return BitmapFactory.decodeByteArray(bis.toByteArray(),0,bis.size());
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
        protected void onPostExecute(Bitmap bitmap) {
            bar.setVisibility(View.GONE);
            imageView.setImageBitmap(bitmap);
        }
    }
}
