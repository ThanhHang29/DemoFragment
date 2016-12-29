package com.ttth.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ttth.demofragment.R;
import com.ttth.model.Contact;

import java.util.ArrayList;

/**
 * Created by Thanh Hang on 29/12/16.
 */

public class MyAdapter extends ArrayAdapter<Contact> {
    private LayoutInflater inflater;
    private ArrayList<Contact>arrContacts;
    public MyAdapter(Context context, int resource, ArrayList<Contact> data) {
        super(context, resource, data);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        arrContacts = data;
    }

    @NonNull
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        if (view == null){
            view = inflater.inflate(R.layout.item_list, parent, false);
            TextView tvName = (TextView) view.findViewById(R.id.tvName);
            TextView tvPhone = (TextView) view.findViewById(R.id.tvPhone);
            viewHolder = new ViewHolder();
            viewHolder.tvName = tvName;
            viewHolder.tvPhone = tvPhone;
            view.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) view.getTag();
        viewHolder.tvName.setText(arrContacts.get(position).getName());
        viewHolder.tvPhone.setText(arrContacts.get(position).getPhone());
        return view;
    }

    class ViewHolder {
        private TextView tvName, tvPhone;
    }
}
