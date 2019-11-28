package com.example.sec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fourthActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        ListView lv = findViewById(R.id.listview1);
        int[] icons = {R.drawable.user, R.drawable.psd, R.drawable.gender, R.drawable.location, R.drawable.hobby};
        String[] names = {"User", "Password", "Gender", "Location", "Hobby"};
        String[] datas = new String[5];
        final Intent intent = getIntent();
        datas[0] = (String) intent.getExtras().get("User");
        datas[1] = (String) intent.getExtras().get("Password");
        datas[2] = (String) intent.getExtras().get("Gender");
        datas[3] = (String) intent.getExtras().get("Location");
        datas[4] = (String) intent.getExtras().get("Hobby");
        for(int i = 0 ; i < 5 ; i++){
            Map<String, Object>listitem = new HashMap<String, Object>();
            listitem.put("icon", icons[i]);
            listitem.put("name", names[i]);
            listitem.put("data", datas[i]);
            list.add(listitem);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, list,
                R.layout.list_item, new String[] { "icon", "name", "data" },
                new int[] { R.id.icon, R.id.name, R.id.data });
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        HashMap<String, String> map = (HashMap<String, String>)parent.getItemAtPosition(position);
        String Text = map.get("name");
        Toast.makeText(fourthActivity.this, Text, Toast.LENGTH_SHORT).show();
    }
}
