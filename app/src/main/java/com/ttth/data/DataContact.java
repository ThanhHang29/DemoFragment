package com.ttth.data;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.ttth.model.Contact;

import java.util.ArrayList;

/**
 * Created by Thanh Hang on 29/12/16.
 */

public class DataContact {
//    private static final String PHONETIC_NAME = "PHONETIC_NAME";
//    private static final String HAS_PHONE_NUMBER = "HAS_PHONE_NUMBER";
    private static final String TAG = "DATA";
    private static final String PHONE_NUMBER = "number";
    private static final String NAME = "name";
    private Context mContext;
    private ContentResolver mResolver;
    public DataContact(Context mContext) {
        this.mContext = mContext;
        mResolver = mContext.getContentResolver();
    }
    public ArrayList<Contact> getDataContact(){
        ArrayList<Contact> arrContact = new ArrayList<Contact>();
        Uri simUri = Uri.parse("content://icc/adn");
        Cursor cursor = mResolver.query(simUri, null, null, null, null);
        cursor.moveToFirst();
        int indextName = cursor.getColumnIndexOrThrow(NAME);
        int indextPhone = cursor.getColumnIndexOrThrow(PHONE_NUMBER);
        while (!cursor.isAfterLast()){
            String name = cursor.getString(indextName);
            String phone = cursor.getString(indextPhone);
            Contact contact = new Contact(name,phone);
            arrContact.add(contact);
            cursor.moveToNext();
        }
//        Log.e(TAG,"========="+arrContact);
        return arrContact;
    }
}
