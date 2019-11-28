package com.example.first;

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

        Button bt1 = (Button)this.findViewById(R.id.bt1);
        Button bt2 = (Button)this.findViewById(R.id.bt2);
        final EditText ed1 = (EditText)this.findViewById(R.id.ed1);
        final EditText ed2 = (EditText)this.findViewById(R.id.ed2);
        final TextView tv1 = (TextView) this.findViewById(R.id.tv1);
        final TextView tv2 = (TextView) this.findViewById(R.id.tv2);
        
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = "User：" + ed1.getText().toString();
                String psd = "Psd：" + ed2.getText().toString();
                tv1.setText(user);
                tv2.setText(psd);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("User：");
                tv2.setText("Psd：");
                ed1.setText("");
                ed2.setText("");
            }
        });
    }
}
