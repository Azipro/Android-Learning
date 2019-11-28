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

public class AddActivity extends AppCompatActivity {

    EditText ed1;
    EditText ed2;
    EditText ed3;
    Spinner sp;
    Button bt;
    String sex = "male";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        bt = findViewById(R.id.bt);
        sp = findViewById(R.id.spinner);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sex = AddActivity.this.getResources().getStringArray(R.array.sex)[position];
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
                user_database user = new user_database(AddActivity.this);
                SQLiteDatabase db = user.getWritableDatabase();
                user.add(db, name, psd, sex, age);
                startActivity(new Intent(AddActivity.this, MainActivity.class));
            }
        });
    }
}
