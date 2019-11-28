package com.example.sec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt1 = findViewById(R.id.button);
        Button bt2 = findViewById(R.id.button2);
        final EditText et1 = findViewById(R.id.editText3);
        final EditText et2 = findViewById(R.id.editText);
        final EditText et3 = findViewById(R.id.editText2);
        final RadioGroup rd = findViewById(R.id.radioGroup);
        final Spinner sp1 = findViewById(R.id.spinner);
        final CheckBox cb1 = findViewById(R.id.checkBox1);
        final CheckBox cb2 = findViewById(R.id.checkBox2);
        final CheckBox cb3 = findViewById(R.id.checkBox3);
        final TextView tv = findViewById(R.id.textView7);

        Drawable drawable1 = getResources().getDrawable(R.drawable.register);
        drawable1.setBounds(0,0,130,130);
        bt1.setCompoundDrawables(drawable1,null,null,null);
        Drawable drawable2 = getResources().getDrawable(R.drawable.exit);
        drawable2.setBounds(0,0,130,130);
        bt2.setCompoundDrawables(drawable2,null,null,null);

        try {
            final Intent intent0 = getIntent();
            tv.setText((CharSequence) intent0.getExtras().get("str"));
        }catch (Exception ignored){}

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, secondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("User", et1.getText().toString());
                bundle.putString("Password", et2.getText().toString());
                bundle.putString("Confirm", et3.getText().toString());
                final RadioButton rb = findViewById(rd.getCheckedRadioButtonId());
                bundle.putString("Gender", rb.getText().toString());
                bundle.putString("Location", sp1.getSelectedItem().toString());
                String s = "";
                if (cb1.isChecked()){
                    s += " " + cb1.getText().toString();
                }
                if(cb2.isChecked()){
                    s += " " + cb2.getText().toString();
                }
                if (cb3.isChecked()){
                    s += " " + cb3.getText().toString();
                }
                bundle.putString("Hobby", s);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction("android.intent.action.MAIN");
                intent.addCategory("android.intent.categary.HOME");
                intent.addCategory("android.intent.caregary.DEFAULT");
                intent.addCategory("android.intent.categary.MONKEY");
                startActivity(intent);
            }
        });
    }
}