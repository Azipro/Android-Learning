package com.example.six;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

public class user_database extends SQLiteOpenHelper {
    public user_database(Context context) {
        super(context, "user_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table user(id integer primary key autoincrement," +
                                            "username varchar(20) DEFAULT 'Azi'," +
                                            "password varchar(20) DEFAULT '000000'," +
                                            "sex varchar(20) DEFAULT 'male'," +
                                            "age integer DEFAULT 20)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void add(SQLiteDatabase db, String name, String psd, String sex, int age){
        ContentValues values = new ContentValues();
        values.put("username", name);
        values.put("password", psd);
        values.put("sex", sex);
        values.put("age", age);
        db.insert("user", null, values);
        db.close();
    }

    public void delete(SQLiteDatabase db, int id){
        db.delete("user", "id = ?", new String[]{id + ""});
        db.close();
    }

    public void updata(SQLiteDatabase db, int id, String name, String psd, String sex, int age){
        ContentValues values = new ContentValues();
        values.put("username", name);
        values.put("password", psd);
        values.put("sex", sex);
        values.put("age", age);
        db.update("user", values, "id = ?", new String[]{id + ""});
        db.close();
    }

    public List<userInfo> query(SQLiteDatabase db){
        Cursor cursor = db.query("user", null, null, null, null, null, "id ASC");
        List<userInfo> list = new ArrayList<userInfo>();
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(1);
            String psd  = cursor.getString(2);
            String sex  = cursor.getString(3);
            int age = cursor.getInt(cursor.getColumnIndex("age"));
            list.add(new userInfo(id, name, psd, sex, age));
        }
        cursor.close();
        db.close();
        return list;
    }

    public List<userInfo> get(SQLiteDatabase db, int i){
        Cursor cursor = db.query("user", null, null, null, null, null, "id ASC");
        List<userInfo> list = new ArrayList<userInfo>();
        boolean is = false;
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            if(id == i) {
                String name = cursor.getString(1);
                String psd = cursor.getString(2);
                String sex = cursor.getString(3);
                int age = cursor.getInt(cursor.getColumnIndex("age"));
                list.add(new userInfo(id, name, psd, sex, age));
                is = true;
            }
        }
        if(!is){
            list.add(new userInfo(-1, "", "", "", 0));
        }
        cursor.close();
        db.close();
        return list;
    }
}

