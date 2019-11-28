package com.example.fou;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity {

    String[] title = {"标题1", "标题2", "标题3"};
    String[][] context = {{"标题1", "内容1"}, {"标题2", "内容2"}, {"标题3", "内容3"}};

    public String[] getTitles(){
        return title;
    }

    public String[][] getContents(){
        return context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleFragment TitleFragement = new titleFragment();
        contentFragment ContentFragment = new contentFragment();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.settitle, TitleFragement);
        transaction.replace(R.id.setcontent, ContentFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
