package com.ttth.demofragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.ttth.adapter.MyAdapter;
import com.ttth.data.DataContact;
import com.ttth.model.Contact;

import java.util.ArrayList;

/**
 * Created by Thanh Hang on 29/12/16.
 */

public class MainFragment extends Fragment {
    private static final String TAG = "MainFragment";
    private ListView lvList;
    private ArrayList<Contact> arrContacts;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container, false);
        DataContact dataContact = new DataContact(getActivity());
        arrContacts = new ArrayList<>();
        arrContacts.addAll(dataContact.getDataContact());
        Log.e(TAG, "-----------"+arrContacts);
        lvList = (ListView) view.findViewById(R.id.lvList);
        initData();
        return view;
    }

    private void initData() {
        final MyAdapter myAdapter = new MyAdapter(getActivity(), android.R.layout.simple_list_item_1,arrContacts);
        lvList.setAdapter(myAdapter);
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                arrContacts.get(position).setCheck(true);
                myAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(),"click",Toast.LENGTH_LONG).show();
            }
        });
    }

}
