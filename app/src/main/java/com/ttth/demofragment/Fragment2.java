package com.ttth.demofragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ttth.adapter.Fragent2Adapter;
import com.ttth.adapter.RVAdapter;
import com.ttth.model.Contact;

import java.util.ArrayList;

/**
 * Created by Thanh Hang on 29/12/16.
 */

public class Fragment2 extends Fragment {
    private static final String TAG = "FRAGMENT2";
    private static final String KEY_CONTACT = "key_contact";
    private static final String EXTRA_KEY_NEW_CONTACT = "extra_key_new_contact";
    private ArrayList<Contact> arrNewContact;
    private RecyclerView rvList2;

    public static Fragment2 newInstance(ArrayList<Contact> arrNewContact) {
        Log.e(TAG, "---"+arrNewContact);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(KEY_CONTACT, arrNewContact);
        Fragment2 fragment = new Fragment2();
        fragment.setArguments(bundle);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle!=null){
            arrNewContact = bundle.getParcelableArrayList(KEY_CONTACT);
        }
        getDataContact(savedInstanceState);
    }

    private void getDataContact(Bundle bundle) {
        if (bundle == null)return;
        bundle.getParcelableArrayList(EXTRA_KEY_NEW_CONTACT);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(EXTRA_KEY_NEW_CONTACT,arrNewContact);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG,"+++++++++++++"+arrNewContact);
        rvList2 = (RecyclerView) view.findViewById(R.id.rvList2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false);
        rvList2.setLayoutManager(layoutManager);
        Fragent2Adapter adapter = new Fragent2Adapter(arrNewContact,getActivity());
        rvList2.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


}
