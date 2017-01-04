package com.ttth.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ttth.demofragment.Fragment3;
import com.ttth.demofragment.MainActivity;
import com.ttth.demofragment.R;
import com.ttth.model.Contact;

import java.util.ArrayList;

/**
 * Created by Thanh Hang on 03/01/17.
 */

public class Fragent2Adapter extends RecyclerView.Adapter<Fragent2Adapter.MyViewHolder> {
    private ArrayList<Contact> arrNewContact;
    private Context mContext;
    public Fragent2Adapter(ArrayList<Contact> arrNewContact, Context mContext) {

        this.arrNewContact = arrNewContact;
        this.mContext = mContext;
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
        final Contact contact = arrNewContact.get(position);
        holder.tvName.setText(contact.getName());
        holder.tvPhone.setText(contact.getPhone());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = ((MainActivity)mContext).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.flFragment, Fragment3.newInstance(contact));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
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
