package com.example.six;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SelectOrDeleteActivity extends AppCompatActivity {

    public ListView lv;
    private List<userInfo> list;
    private SQLiteDatabase db;
    private String[] user_mes;
    public TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_or_delete);

        lv = findViewById(R.id.listview);
        user_database users = new user_database(SelectOrDeleteActivity.this);
        db = users.getReadableDatabase();

        list = users.query(db);
        user_mes = new String[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            user_mes[i] = list.get(i).getId() + "   " + list.get(i).getUsername() + "   "
                    + list.get(i).getSex() + "   " + list.get(i).getAge();
        }

        lv.setAdapter(new MyAdapter(this));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                final int id = list.get(position).getId();
                new AlertDialog.Builder(SelectOrDeleteActivity.this).setTitle("Tips:")
                        .setMessage("Are you sure that you want to delete this message？")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @SuppressLint("ShowToast")
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                user_database user_database = new user_database(SelectOrDeleteActivity.this);
                                SQLiteDatabase db0 = user_database.getWritableDatabase();
                                user_database.delete(db0, id);
                                finish();
                                startActivity(new Intent(SelectOrDeleteActivity.this, SelectOrDeleteActivity.class));
                                Toast.makeText(SelectOrDeleteActivity.this, "Delete successfully!", Toast.LENGTH_SHORT).show();
                            }
                        })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                }).show();
            }
        });
    }

    public class MyAdapter extends BaseAdapter{

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
            return user_mes[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                convertView = mInflater.inflate(R.layout.list_item, null);
                tv = convertView.findViewById(R.id.items);
                tv.setText(user_mes[position]);
            return convertView;
        }
    }
}
