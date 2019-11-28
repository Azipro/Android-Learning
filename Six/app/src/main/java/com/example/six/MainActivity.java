package com.example.six;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt1;
    Button bt2;
    Button bt3;
    user_database user;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);

        user = new user_database(MainActivity.this);
        db = user.getReadableDatabase();

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt1:
                startActivity(new Intent(MainActivity.this, SelectOrDeleteActivity.class));
                break;
            case R.id.bt2:
                startActivity(new Intent(MainActivity.this, UpdataActivity.class));
                break;
            case R.id.bt3:
                startActivity(new Intent(MainActivity.this, AddActivity.class));
                break;
            default:
                break;
        }
    }
}
