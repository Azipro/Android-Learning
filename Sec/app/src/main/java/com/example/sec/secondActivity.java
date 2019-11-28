package com.example.sec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button bt1=(Button)findViewById(R.id.bt1);
        Drawable drawable1 = getResources().getDrawable(R.drawable.returnn);
        drawable1.setBounds(0,0,130,130);
        bt1.setCompoundDrawables(drawable1,null,null,null);

        Button bt2=(Button)findViewById(R.id.bt2);
        Drawable drawable2 = getResources().getDrawable(R.drawable.next);
        drawable2.setBounds(0,0,130,130);
        bt2.setCompoundDrawables(null,null,drawable2,null);


        final TextView tv7 = findViewById(R.id.tv7);
        final TextView tv8 = findViewById(R.id.tv8);
        final TextView tv9 = findViewById(R.id.tv9);
        final TextView tv10 = findViewById(R.id.tv10);
        final TextView tv11 = findViewById(R.id.tv11);
        final TextView tv12 = findViewById(R.id.tv12);

        final Intent intent = getIntent();
        tv10.setText((CharSequence) intent.getExtras().get("User"));
        tv11.setText((CharSequence) intent.getExtras().get("Password"));
        tv12.setText((CharSequence) intent.getExtras().get("Confirm"));
        tv7.setText((CharSequence) intent.getExtras().get("Gender"));
        tv8.setText((CharSequence) intent.getExtras().get("Location"));
        tv9.setText((CharSequence) intent.getExtras().get("Hobby"));

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent0 = new Intent(secondActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                String str = "";
                str = "User:" + tv10.getText().toString() + " " + "Password:" + tv11.getText().toString() + " "
                        + "Gender:" + tv7.getText().toString() + " " + "Location:" + tv8.getText().toString() + " "
                        + "Hobby:" + tv9.getText().toString();
                bundle.putString("str", str);
                intent0.putExtras(bundle);
                startActivity(intent0);
            }
        });

        final Bundle bundle = new Bundle();
        bundle.putString("User", tv10.getText().toString());
        bundle.putString("Password", tv11.getText().toString());
        bundle.putString("Confirm", tv12.getText().toString());
        bundle.putString("Gender", tv7.getText().toString());
        bundle.putString("Location", tv8.getText().toString());
        bundle.putString("Hobby", tv9.getText().toString());

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(secondActivity.this, thirdActivity.class);
                intent2.putExtras(bundle);
                startActivity(intent2);
            }
        });


        Button bt3 = findViewById(R.id.bt3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(secondActivity.this, fourthActivity.class);
                intent3.putExtras(bundle);
                startActivity(intent3);
            }
        });

        Button bt4 = findViewById(R.id.bt4);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(secondActivity.this, fifthActivity.class);
                intent4.putExtras(bundle);
                startActivity(intent4);
            }
        });

        Button bt5 = findViewById(R.id.bt5);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(secondActivity.this, sixthActivity.class);
                Bundle bundle0 = new Bundle();
                int[] icons = {R.drawable.user, R.drawable.psd, R.drawable.gender, R.drawable.location, R.drawable.hobby};
                String[] names = {"User", "Password", "Gender", "Location", "Hobby"};
                String[] data = {tv10.getText().toString(), tv11.getText().toString(), tv7.getText().toString(),
                        tv8.getText().toString(), tv9.getText().toString()};
                for (int i = 0 ; i < 5 ; i++){
                    bundle0.putInt("icon"+i, icons[i]);
                    bundle0.putString("name"+i, names[i]);
                    bundle0.putString("data"+i, data[i]);
                }
                bundle0.putInt("num", 5);
                intent5.putExtras(bundle0);
                startActivity(intent5);
            }
        });
    }
}
