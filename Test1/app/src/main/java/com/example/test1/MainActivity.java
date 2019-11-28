package com.example.test1;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1,btn2,btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
//        btn4 = findViewById(R.id.btn4);
//        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
//        btn4.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
//            case R.id.btn1:
//                testSecondRightFragment secondRightFragment = new testSecondRightFragment();
//                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();//获取Fragment的管理
//                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();//开启一个事务
//                transaction.replace(R.id.right_layout, secondRightFragment);
//                transaction.commit();//提交事务
//                break;
            case R.id.btn2:
                startActivity(new Intent(MainActivity.this,SlideActivity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
                break;
//            case R.id.btn4:
//                break;
            default:
                break;
        }
        
    }
}
