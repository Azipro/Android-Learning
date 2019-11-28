package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText etName = findViewById(R.id.etName);
        final EditText etPwd = findViewById(R.id.etPwd);
        final TextView tvshowText = findViewById(R.id.tvshowText);
        Button bt1 = findViewById( R.id.btnSubmit);
        Button bt2 = findViewById( R.id.btnCancel);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str="The login name is :"+etName.getText().toString()+"\n"+"The password is :"+etPwd.getText().toString();
                tvshowText.setText( ""+str );
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText( "" );
                etPwd.setText( "" );
            }
        });
    }
}
