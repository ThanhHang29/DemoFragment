package com.ttth.demofragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ttth.adapter.RVAdapter;
import com.ttth.data.DataContact;
import com.ttth.model.Contact;

import java.util.ArrayList;

/**
 * Created by Thanh Hang on 30/12/16.
 */

public class MainRvFragment extends Fragment{
    public static final String KEY_CONTACT = "key_contact";
    private RecyclerView rvList;
    private RVAdapter rvAdapter;
    private ArrayList<Contact> arrContacts, arrNewContact;
    private Button btnNext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvList = (RecyclerView) view.findViewById(R.id.rvList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvList.setLayoutManager(layoutManager);
        initView();
        btnNext = (Button) view.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrNewContact = rvAdapter.getArrNewContact();
                Fragment2 fragment2 = new Fragment2();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(KEY_CONTACT, arrNewContact);
                fragment2.setArguments(bundle);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.flFragment, fragment2);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    private void initView() {
        DataContact dataContact = new DataContact(getActivity());
        arrContacts = new ArrayList<>();
        arrContacts.addAll(dataContact.getDataContact());
        rvAdapter = new RVAdapter(arrContacts, getActivity());
        rvList.setAdapter(rvAdapter);
        rvAdapter.notifyDataSetChanged();

    }


}
