package Parseur;

import android.os.Bundle;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Model.Item;

/**
 * Created by Brezeler on 06/05/2016.
 */
public class Parseur {


    public static ArrayList<Item> parseur(String s){

            ArrayList<Item> entries = null;
            XmlPullParser parser = null;
            StringReader inputStream = null;
            String source = null;
            try {
                inputStream = new StringReader(s);
                XmlPullParserFactory pullParserFactory = XmlPullParserFactory.newInstance();
                parser = pullParserFactory.newPullParser();
                parser.setInput(inputStream);
                int eventType = parser.getEventType();
                Item entry = new Item();

                Item currentEntry = null;
                while(eventType != XmlPullParser.END_DOCUMENT){
                    String name;
                    switch (eventType){
                        case XmlPullParser.START_DOCUMENT:
                            entries = new ArrayList();
                            break;
                        case XmlPullParser.START_TAG:
                            name = parser.getName();
                            if(currentEntry == null && name.equals("title")){
                                if(source == null){
                                    source = parser.nextText();
                                }
                        }else if(name.equals("item")){
                                currentEntry = new Item();
                            }else if (currentEntry !=null){
                                if(name.equals("link")){
                                    currentEntry.setLink(parser.nextText());
                                }else if (name.equals("title")){
                                    currentEntry.setTitle(parser.nextText());
                                }else if (name.equals("description")) {
                                    currentEntry.setDescription(parser.nextText());
                                }else if(name.equals("enclosure")){
                                    currentEntry.setImage(parser.getAttributeValue(null, "url"));
                                }else if (name.equals("pubDate")){
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    Date dueDate = null;
                                    try {
                                        dueDate = dateFormat.parse(parser.nextText());
                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }
                                    currentEntry.setPubDate(dueDate);
                                }else if (name.equals("guid")) {
                                    currentEntry.setId(parser.nextText());
                                }

                            }
                            break;
                        case XmlPullParser.END_TAG:
                            name = parser.getName();
                            if (name.equalsIgnoreCase("item") && currentEntry !=null){
                                currentEntry.setSource(source);
                                entries.add(currentEntry);
                            }
                    }
                    eventType = parser.next();

                }
                Log.d("toto", entries.get(0).getTitle());
            } catch (IOException e) {
                e.printStackTrace();
            }
            catch (XmlPullParserException e1) {
                e1.printStackTrace();
            }
        return entries;

        }
}
