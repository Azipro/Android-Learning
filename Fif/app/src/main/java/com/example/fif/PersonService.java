package com.example.fif;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PersonService {
    public static List<Person>getPersons(InputStream xml) throws IOException, XmlPullParserException{
        List<Person> persons = null;
        Person person = null;
        XmlPullParser pullParser = Xml.newPullParser();

        try{
            pullParser.setInput(xml, "UTF-8");
            int event = pullParser.getEventType();
            while(event != XmlPullParser.END_DOCUMENT){
                switch (event){
                    case XmlPullParser.START_DOCUMENT:
                        persons = new ArrayList<Person>();
                        break;
                    case XmlPullParser.START_TAG:
                        if("person".equals(pullParser.getName())){
                            person = new Person();
                        }
                        if("name".equals(pullParser.getName())){
                            person.setUsername(pullParser.nextText());
                        }
                        if("password". equals(pullParser.getName())){
                            person.setPassword(pullParser.nextText());
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if("person".equals(pullParser.getName())){
                            persons.add(person);
                            person = null;
                        }
                        break;
                }
                event = pullParser.next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
        return persons;
    }
}
