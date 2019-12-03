package com.example.sev;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    JsonObject jsonObject;
    JsonParser jsonParser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String json = "{\n" +
                "  \"name\": \"Azi\",\n" +
                "  \"Info\": [\n" +
                "    {\"age\": 20, \"sex\": \"male\"}\n" +
                "  ]\n" +
                "}";

//        String json = getString("test.json");

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);

        try {
            FileOutputStream fo = openFileOutput("test.json", MODE_PRIVATE);
            fo.write(json.getBytes());
            fo.close();
            jsonParser = new JsonParser();
            //String file = getString("");
            jsonObject = (JsonObject) jsonParser.parse(new FileReader("/data/data/com.example.sev/files/test.json"));
            tv1.setText(jsonObject.get("name").getAsString());
            JsonArray jsonArray = jsonObject.get("Info").getAsJsonArray();
            String s = "";
            for(int i = 0 ; i < jsonArray.size() ; i++){
                JsonObject jsonObject1 = jsonArray.get(i).getAsJsonObject();
                s = s + '\n' + "age:" + jsonObject1.get("age").getAsInt() + "\n" +
                        "sex:" + jsonObject1.get("sex").getAsString();
                tv2.setText(s);
            }
        } catch (JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }

    }

//    public String getString(String Filename) {
//        String file = "";
//        try {
//            FileInputStream f = openFileInput(Filename);
//            byte[] buffers = new byte[f.available()];
//            f.read(buffers);
//            file = new String(buffers);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return file;
//    }
}
