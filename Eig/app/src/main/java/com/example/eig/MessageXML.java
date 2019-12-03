package com.example.eig;

import android.content.Context;
import android.os.Environment;
import android.util.Xml;
import android.widget.Toast;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

class MessageXML {
    public static void SaveMessage(List<MessageInfo>list, Context context){
        try{
            XmlSerializer serializer = Xml.newSerializer();
            File file = new File(Environment.getExternalStorageDirectory(), "mes.xml");
            FileOutputStream fo = new FileOutputStream(file);
            serializer.setOutput(fo, "utf-8");
            serializer.startDocument("utf-8", true);
            serializer.startTag(null, "message");
            for(MessageInfo info : list){
                serializer.startTag(null, "msg");
                serializer.attribute(null,"id",info.getId() + "");

                serializer.startTag(null, "body");
                serializer.text(info.getBody());
                serializer.endTag(null, "body");

                serializer.startTag(null, "type");
                serializer.text(info.getType() + "");
                serializer.endTag(null, "type");

                serializer.startTag(null, "address");
                serializer.text(info.getAddress());
                serializer.endTag(null, "address");

                serializer.startTag(null, "date");
                serializer.text(info.getDate() + "");
                serializer.endTag(null, "date");

                serializer.endTag(null, "msg");
            }
            serializer.endTag(null, "message");
            serializer.endDocument();
            fo.close();
            Toast.makeText(context, "Save Message Successfully!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "Save Message Default!", Toast.LENGTH_SHORT).show();
        }
    }
}
