package com.ttth.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Thanh Hang on 29/12/16.
 */

public class Contact implements Parcelable{
    private String name;
    private String phone;
    private boolean isSelected = true;
    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    protected Contact(Parcel in) {
        name = in.readString();
        phone = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
