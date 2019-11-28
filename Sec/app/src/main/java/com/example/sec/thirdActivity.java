package com.example.sec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class thirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ListView lt = findViewById(R.id.lt);
        ArrayAdapter<String> adapter;
        final Intent intent = getIntent();
        String[] date = new String[5];
        date[0] = (String) intent.getExtras().get("User");
        date[1] = (String) intent.getExtras().get("Password");
        date[2] = (String) intent.getExtras().get("Gender");
        date[3] = (String) intent.getExtras().get("Location");
        date[4] = (String) intent.getExtras().get("Hobby");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, date);
        lt.setAdapter(adapter);
    }
}
