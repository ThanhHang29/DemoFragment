package com.ttth.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
    private ArrayList<Contact>arrContacts;
    private Context mContext;
    public RVAdapter(ArrayList<Contact> arrContacts, Context mContext) {
        this.arrContacts = arrContacts;
        this.mContext = mContext;
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
        holder.tvName.setText(arrContacts.get(position).getName());
        holder.tvPhone.setText(arrContacts.get(position).getPhone());
        if (holder instanceof MyViewHolder){
        }
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
}
