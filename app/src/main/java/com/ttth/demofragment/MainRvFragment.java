package com.ttth.demofragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ttth.adapter.RVAdapter;
import com.ttth.data.DataContact;
import com.ttth.model.Contact;

import java.util.ArrayList;

/**
 * Created by Thanh Hang on 30/12/16.
 */

public class MainRvFragment extends android.support.v4.app.Fragment {
    private RecyclerView rvList;
    private RVAdapter rvAdapter;
    private ArrayList<Contact> arrContacts;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rvList = (RecyclerView) inflater.inflate(R.layout.my_fragment, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvList.setLayoutManager(layoutManager);
        return rvList;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DataContact dataContact = new DataContact(getActivity());
        arrContacts = new ArrayList<>();
        arrContacts.addAll(dataContact.getDataContact());
        rvAdapter = new RVAdapter(arrContacts, getActivity());
        rvList.setAdapter(rvAdapter);
    }
}
