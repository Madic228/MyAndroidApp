package com.example.girich_project;

import org.xmlpull.v1.XmlPullParser;
import java.util.ArrayList;

public class t8_lab_2_UserResourceParser {

    private ArrayList<t8_lab_2_User> users;
    public t8_lab_2_UserResourceParser(){
        users = new ArrayList<>();
    }
    public ArrayList<t8_lab_2_User> getUsers(){
        return users;
    }
    public boolean parse(XmlPullParser xpp){
        boolean status = true;
        t8_lab_2_User currentUser = null;
        boolean inEntry = false;
        String textValue = "";
        try{
            int eventType = xpp.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT){
                String tagName = xpp.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        if("user".equalsIgnoreCase(tagName)){
                            inEntry = true;
                            currentUser = new t8_lab_2_User();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if(inEntry){
                            if("user".equalsIgnoreCase(tagName)){
                                users.add(currentUser);
                                inEntry = false;
                            } else if("name".equalsIgnoreCase
                                    (tagName)){ currentUser.setName(textValue);
                            } else if("age".equalsIgnoreCase
                                    (tagName)){ currentUser.setAge(textValue);
                            }
                        }
                        break;
                    default:
                }
                eventType = xpp.next();
            }
        }
        catch (Exception e){
            status = false;
            e.printStackTrace();
        }
        return status;
    }
}

