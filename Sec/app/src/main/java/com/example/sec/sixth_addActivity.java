package com.example.sec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class sixth_addActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth_add);

        final RadioGroup rg = findViewById(R.id.rg1);
        final EditText ed1 = findViewById(R.id.ed1);
        final EditText ed2 = findViewById(R.id.ed2);
        Button bt = findViewById(R.id.bt6);

        final Intent intent0 = getIntent();

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sixth_addActivity.this, sixthActivity.class);
                Bundle bundle = new Bundle();
                bundle = intent0.getExtras();
                int i = (int) bundle.get("num");
                RadioButton rb = findViewById(rg.getCheckedRadioButtonId());
                int x = Integer.parseInt(rb.getText().toString());
                int[] icons = {R.drawable.user, R.drawable.exit, R.drawable.location, R.drawable.gender,
                        R.drawable.hobby, R.drawable.register};
                bundle.putInt("icon"+i, icons[x]);
                bundle.putString("name"+i, ed1.getText().toString());
                bundle.putString("data"+i, ed2.getText().toString());
                i = i + 1;
                bundle.putInt("num", i);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
