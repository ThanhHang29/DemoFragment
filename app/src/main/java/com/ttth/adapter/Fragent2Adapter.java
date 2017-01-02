package com.ttth.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ttth.demofragment.R;
import com.ttth.model.Contact;

import java.util.ArrayList;

/**
 * Created by Thanh Hang on 03/01/17.
 */

public class Fragent2Adapter extends RecyclerView.Adapter<Fragent2Adapter.MyViewHolder> {
    private ArrayList<Contact> arrNewContact;

    public Fragent2Adapter(ArrayList<Contact> arrNewContact) {
        this.arrNewContact = arrNewContact;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_list2, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Contact contact = arrNewContact.get(position);
        holder.tvName.setText(contact.getName());
        holder.tvPhone.setText(contact.getPhone());
    }

    @Override
    public int getItemCount() {
        return arrNewContact.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName, tvPhone;

        public MyViewHolder(View itemView) {
            super(itemView);
            initView();
        }

        private void initView() {
            tvName = (TextView) itemView.findViewById(R.id.tvName2);
            tvPhone = (TextView) itemView.findViewById(R.id.tvPhone2);
        }
    }
}
