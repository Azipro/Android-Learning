package com.example.layouttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt1, bt2, bt3;
    String str = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt1:
                str = "Click" + bt1.getText();
                Toast.makeText(this,str, Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt2:
                str = "Click" + bt2.getText();
                Toast.makeText(this,str, Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt3:
                str = "Click" + bt3.getText();
                Toast.makeText(this,str, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
