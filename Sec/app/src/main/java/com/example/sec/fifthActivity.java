package com.example.sec;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fifthActivity extends AppCompatActivity {

    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        ListView lv = findViewById(R.id.listview2);

        int[] icons = {R.drawable.user, R.drawable.psd, R.drawable.gender, R.drawable.location, R.drawable.hobby};
        String[] names = {"User", "Password", "Gender", "Location", "Hobby"};
        String[] datas = new String[5];
        Intent intent = getIntent();
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
            listitem.put("button", names[i]);
            list.add(listitem);
        }
        MyAdapter adapter = new MyAdapter(this);
        lv.setAdapter(adapter);
    }


    static class ViewHolder {
        ImageView icon;
        TextView name;
        TextView data;
        Button bt;
    }



    public class MyAdapter extends BaseAdapter {
        private LayoutInflater mInflater = null;
        private MyAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if(convertView == null){
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.list_fifth, null);
                holder.icon = (ImageView)convertView.findViewById(R.id.icon);
                holder.name = (TextView)convertView.findViewById(R.id.name);
                holder.data = (TextView)convertView.findViewById(R.id.data);
                holder.bt = convertView.findViewById(R.id.bt);
                holder.bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new AlertDialog.Builder(fifthActivity.this).setTitle("Tips")
                                .setMessage(list.get(position).get("name").toString() + "&" +list.get(position).get("data").toString())
                                .setPositiveButton("Certain", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
                    }
                });
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }
            holder.icon.setImageResource((Integer)list.get(position).get("icon"));
            holder.name.setText(list.get(position).get("name").toString());
            holder.data.setText(list.get(position).get("data").toString());
            holder.bt.setText(list.get(position).get("button").toString());
            return convertView;
        }

    }
}
