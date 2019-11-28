package com.example.thr;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.Toast;

public class TestButton extends Button {
    public TestButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean onTouchEvent(MotionEvent evrnt){
        Toast.makeText(getContext(), "111111", Toast.LENGTH_SHORT).show();
        return true;
    }
}
