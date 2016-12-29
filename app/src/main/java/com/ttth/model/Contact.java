package com.ttth.model;

/**
 * Created by Thanh Hang on 29/12/16.
 */

public class Contact {
    private String name;
    private String phone;
    private boolean isCheck = false;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return
                "name='" + name +
                ", phone='" + phone +"\n";
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

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
