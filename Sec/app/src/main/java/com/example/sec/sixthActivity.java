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
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sixthActivity extends AppCompatActivity {

    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        final ListView lv = findViewById(R.id.listview3);

        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        int num = (int) bundle.get("num");
        for(int i = 0 ; i < num ; i++){
            Map<String, Object> listitem = new HashMap<String, Object>();
            listitem.put("icon", bundle.get("icon"+i));
            listitem.put("name", bundle.get("name"+i));
            listitem.put("data", bundle.get("data"+i));
            list.add(listitem);
        }

        final MyAdapter adapter = new MyAdapter(this);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String, String> map = (HashMap<String, String>)parent.getItemAtPosition(position);
                String Text = map.get("name");
                Toast.makeText(sixthActivity.this, Text, Toast.LENGTH_SHORT).show();
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(sixthActivity.this).setTitle("Tips")
                        .setItems(new String[]{"详情", "添加", "删除", "修改"}, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which){
                                    case 0:
                                        showDetalis();
                                        break;
                                    case 1:
                                        adapter.add();
                                        break;
                                    case 2:
                                        adapter.removeItem(position);
                                        break;
                                    case 3:
                                        adapter.modify(position);
                                        break;
                                }
                            }

                            private void showDetalis() {
                                new AlertDialog.Builder(sixthActivity.this).setTitle("详情")
                                        .setMessage(list.get(position).get("name").toString() + ":\n" + list.get(position).get("data"))
                                        .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                            }
                                        }).show();
                            }
                        }).show();
                return true;
            }
        });

        Button bt7 = findViewById(R.id.bt7);
        final EditText ed3 = findViewById(R.id.ed3);
        final EditText ed4 = findViewById(R.id.ed4);

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> listitem = new HashMap<String, Object>();
                listitem.put("icon", R.drawable.user);
                listitem.put("name", ed3.getText().toString());
                listitem.put("data", ed4.getText().toString());
                list.add(listitem);
                ed3.setText("");
                ed4.setText("");
                lv.setAdapter(adapter);
            }
        });

    }

    static class ViewHolder {
        ImageView icon;
        TextView name;
        TextView data;
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
                convertView = mInflater.inflate(R.layout.list_item, null);
                holder.icon = (ImageView)convertView.findViewById(R.id.icon);
                holder.name = (TextView)convertView.findViewById(R.id.name);
                holder.data = (TextView)convertView.findViewById(R.id.data);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }
            holder.icon.setImageResource((Integer)list.get(position).get("icon"));
            holder.name.setText(list.get(position).get("name").toString());
            holder.data.setText(list.get(position).get("data").toString());
            return convertView;
        }

        public void removeItem(int position) {
            list.remove(list.get(position));
            notifyDataSetChanged();
        }

        public void add() {
            Intent intent = new Intent(sixthActivity.this, sixth_addActivity.class);
            Bundle bundle0 = new Bundle();
            for(int i = 0 ; i < list.size() ; i++){
                bundle0.putInt("icon"+i, (Integer) list.get(i).get("icon"));
                bundle0.putString("name"+i, (String) list.get(i).get("name"));
                bundle0.putString("data"+i, (String) list.get(i).get("data"));
            }
            bundle0.putInt("num", list.size());
            intent.putExtras(bundle0);
            startActivity(intent);
        }

        public void modify(int position) {
            Intent intent = new Intent(sixthActivity.this, sixth_modifyActivity.class);
            Bundle bundle0 = new Bundle();
            for(int i = 0 ; i < list.size() ; i++){
                bundle0.putInt("icon"+i, (Integer) list.get(i).get("icon"));
                bundle0.putString("name"+i, (String) list.get(i).get("name"));
                bundle0.putString("data"+i, (String) list.get(i).get("data"));
            }
            bundle0.putInt("num", list.size());
            bundle0.putInt("position", position);
            intent.putExtras(bundle0);
            startActivity(intent);
        }
    }
}
