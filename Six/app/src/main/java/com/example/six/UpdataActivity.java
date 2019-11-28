package com.example.six;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class UpdataActivity extends AppCompatActivity {

    EditText ed1;
    EditText ed2;
    EditText ed3;
    EditText ed4;
    Spinner sp;
    Button bt;
    Button bt1;
    String sex = "male";
    List<userInfo> list;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata);

        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        ed4 = findViewById(R.id.ed4);
        bt1 = findViewById(R.id.bt1);
        bt = findViewById(R.id.bt);
        sp = findViewById(R.id.spinner);

        final SQLiteDatabase db;
        final user_database users = new user_database(UpdataActivity.this);
        db = users.getReadableDatabase();

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = Integer.parseInt(ed4.getText().toString());
                list = users.get(db, id);
                if (list.get(0).getId() == -1) {
                    startActivity(new Intent(UpdataActivity.this, AddActivity.class));
                } else {
                    ed1.setText(list.get(0).getUsername());
                    ed2.setText(list.get(0).getPassword());
                    if (list.get(0).getSex() == UpdataActivity.this.getResources().getStringArray(R.array.sex)[0]) {
                        sp.setSelection(1, true);
                    } else {
                        sp.setSelection(0, true);
                    }
                    ed3.setText(new String(String.valueOf(list.get(0).getAge())));
                }
            }
        });

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sex = UpdataActivity.this.getResources().getStringArray(R.array.sex)[position];
                sp.setSelection(position, true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ed1.getText().toString();
                String psd = ed2.getText().toString();
                int age = Integer.parseInt(ed3.getText().toString());
                user_database user = new user_database(UpdataActivity.this);
                SQLiteDatabase db = user.getWritableDatabase();
                user.updata(db, id, name, psd, sex, age);
                startActivity(new Intent(UpdataActivity.this, MainActivity.class));
            }
        });
    }
}
