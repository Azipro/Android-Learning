package com.example.fif;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText ed1;
    EditText ed2;
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    Button bt6;
    Button bt7;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        bt1 = findViewById(R.id.save_bt);
        bt2 = findViewById(R.id.read_bt);
        bt3 = findViewById(R.id.out_save);
        bt4 = findViewById(R.id.out_read);
        bt5 = findViewById(R.id.Xml_bt);
        bt6 = findViewById(R.id.Analysis_xml);
        bt7 = findViewById(R.id.Shared_bt);
        tv1 = findViewById(R.id.tv1);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String info = "user.txt";
        String info_out = "user_out.txt";
        String str = ed1.getText().toString() + "," + ed2.getText().toString();
        switch (v.getId()){
            case R.id.save_bt:
                try{
                    FileOutputStream fo = openFileOutput(info, MODE_PRIVATE);
                    fo.write(str.getBytes());
                    fo.close();
                    SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences("user_mes", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", ed1.getText().toString());
                    editor.putString("password", ed2.getText().toString());
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Save && SharedPerference Successfully!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.read_bt:
                try {
                    FileInputStream fi = openFileInput(info);
                    byte[] buffer = new byte[fi.available()];
                    fi.read(buffer);
                    tv1.setText(new String(buffer));
                    fi.close();
                    Toast.makeText(MainActivity.this, "Read Successfully!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.out_save:
                try{
                    String ev = Environment.getExternalStorageState();
                    if(Environment.MEDIA_MOUNTED.equals(ev)){
                        File sd = Environment.getExternalStorageDirectory();
                        File file = new File(sd, info_out);
                        FileOutputStream fo = new FileOutputStream(file);
                        fo.write(str.getBytes());
                        fo.close();
                        Toast.makeText(MainActivity.this, "OUT_Save Successfully!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "OUT_Save Default!", Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.out_read:
                try{
                    String ev = Environment.getExternalStorageState();
                    if(Environment.MEDIA_MOUNTED.equals(ev)){
                        File sd = Environment.getExternalStorageDirectory();
                        File file = new File(sd, info_out);
                        FileInputStream fi = new FileInputStream(file);
                        BufferedReader buffer = new BufferedReader(new InputStreamReader(fi));
                        tv1.setText(buffer.readLine());
                        fi.close();
                        Toast.makeText(MainActivity.this, "OUT_Read Successfully!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "OUT_Read Default!", Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            case R.id.Xml_bt:
                String name = ed1.getText().toString();
                String psd = ed2.getText().toString();
                Person person = new Person();
                person.setUsername(name);
                person.setPassword(psd);
                try{
                    XmlSerializer serializer = Xml.newSerializer();
                    FileOutputStream fo = openFileOutput("person.xml", MODE_PRIVATE);
                    serializer.setOutput(fo, "UTF-8");
                    serializer.startDocument("UTF-8", true);
                    serializer.startTag(null, "persons");
                    serializer.startTag(null, "person");
                    serializer.startTag(null, "name");
                    serializer.text(person.getUsername());
                    serializer.endTag(null, "name");
                    serializer.startTag(null, "password");
                    serializer.text(person.getPassword());
                    serializer.endTag(null, "password");
                    serializer.endTag(null, "person");
                    serializer.endTag(null, "persons");
                    serializer.endDocument();
                    serializer.flush();
                    fo.close();
                    Toast.makeText(MainActivity.this, "Xml Successfully!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Xml Default!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.Analysis_xml:
                InputStream xml = null;
                try {
                    xml = openFileInput("person.xml");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try{
                    List<Person>persons = PersonService.getPersons(xml);
                    for(Person person1:persons){
                        tv1.setText(person1.toString());
                    }
                } catch (XmlPullParserException | IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.Shared_bt:
                try {
                    SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences("user_mes", MODE_PRIVATE);
                    String name1 = sharedPreferences.getString("username", null);
                    String psd1 = sharedPreferences.getString("password", null);
                    Toast.makeText(MainActivity.this, name1 + "\n" + psd1, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            default:
                break;
        }
    }
}
