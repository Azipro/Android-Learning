package com.example.eig;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity {

    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        bt = findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://sms/");
                ContentResolver contentResolver = getContentResolver();
                Cursor cursor = contentResolver.query(uri, new String[]{"address", "date", "type", "body"},
                        null, null, null);
                List<MessageInfo> list = new ArrayList<MessageInfo>();
                while(cursor.moveToNext()){
                    String address = cursor.getString(0);
                    long date = cursor.getLong(1);
                    int type = cursor.getInt(2);
                    String body = cursor.getString(3);
                    MessageInfo smsInfo = new MessageInfo(address, date, type, body);
                    list.add(smsInfo);
                }
                cursor.close();
                MessageXML.SaveMessage(list, MessageActivity.this);
            }
        });
    }
}
