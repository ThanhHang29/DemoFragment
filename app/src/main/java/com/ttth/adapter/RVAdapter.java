package com.ttth.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.ttth.demofragment.R;
import com.ttth.model.Contact;

import java.util.ArrayList;

/**
 * Created by Thanh Hang on 30/12/16.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {
    private static final String TAG = "RVAdapter";
    private ArrayList<Contact>arrContacts;
    private ArrayList<Contact>arrNewContact;
    public RVAdapter(ArrayList<Contact> arrContacts,ArrayList<Contact> arrNewContact) {
        this.arrContacts = arrContacts;
        this.arrNewContact = arrNewContact;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_list, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Contact contact = arrContacts.get(position);
        holder.tvName.setText(contact.getName());
        holder.tvPhone.setText(contact.getPhone());
        holder.checkBox.setChecked(contact.isSelected());
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBox = (CheckBox)v;
                if (checkBox.isChecked()){
                    contact.setSelected(true);
                    arrNewContact.add(contact);
                }else {
                    contact.setSelected(false);
                    arrNewContact.remove(contact);
                }
                Log.e(TAG,""+arrNewContact);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName, tvPhone;
        private CheckBox checkBox;

        public MyViewHolder(View itemView) {
            super(itemView);
            initView();
        }

        private void initView() {
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvPhone = (TextView) itemView.findViewById(R.id.tvPhone);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);

        }
    }

//    public ArrayList<Contact> getArrNewContact() {
//        return arrNewContact;
//    }
}
