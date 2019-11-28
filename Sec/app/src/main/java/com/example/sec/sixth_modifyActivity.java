package com.example.sec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class sixth_modifyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth_modify);

        final EditText ed1 = findViewById(R.id.ed1);
        final EditText ed2 = findViewById(R.id.ed2);
        TextView tv1 = findViewById(R.id.tv13);
        Button bt = findViewById(R.id.bt);

        final int[] icons = {R.drawable.user, R.drawable.exit, R.drawable.location, R.drawable.gender,
                R.drawable.hobby, R.drawable.register};
        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        final int position = (int) bundle.get("position");
        String text = (String) bundle.get("name"+position);
        tv1.setText(tv1.getText() + text);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rg = findViewById(R.id.rg1);
                RadioButton rb = findViewById(rg.getCheckedRadioButtonId());
                Intent intent0 = new Intent(sixth_modifyActivity.this, sixthActivity.class);
                int i = Integer.parseInt(rb.getText().toString());
                bundle.putInt("icon"+position, icons[i]);
                bundle.putString("name"+position, ed1.getText().toString());
                bundle.putString("data"+position, ed2.getText().toString());
                intent0.putExtras(bundle);
                startActivity(intent0);
            }
        });
    }
}
