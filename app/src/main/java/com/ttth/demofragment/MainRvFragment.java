package com.ttth.demofragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ttth.adapter.RVAdapter;
import com.ttth.data.DataContact;
import com.ttth.model.Contact;

import java.util.ArrayList;

/**
 * Created by Thanh Hang on 30/12/16.
 */

public class MainRvFragment extends Fragment {
    private static final String EXTRA_CONTACT_LIST = "extra_contact_list";
    private static final String EXTRA_CONTACT_NEW = "extra_contact_new ";
    private RecyclerView rvList;
    private RVAdapter rvAdapter;
    private ArrayList<Contact> arrContacts, arrNewContact;
    private Button btnNext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDataFromBundle(savedInstanceState);
    }

    private void getDataFromBundle(Bundle bundle) {
        if (bundle==null)return;

        arrContacts = bundle.getParcelableArrayList(EXTRA_CONTACT_LIST);
        arrNewContact = bundle.getParcelableArrayList(EXTRA_CONTACT_NEW);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(EXTRA_CONTACT_LIST,arrContacts);
        outState.putParcelableArrayList(EXTRA_CONTACT_NEW, arrNewContact);
    }

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
        btnNext = (Button) view.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.flFragment, Fragment2.newInstance(arrNewContact));
                    transaction.addToBackStack(null);
                    transaction.commit();
                Log.e("----","========="+arrNewContact);
                }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();


    }


    private void initView() {
        if (arrContacts == null || arrContacts.size() == 0) {
            DataContact dataContact = new DataContact(getActivity());
            arrContacts = new ArrayList<>();
            arrContacts.addAll(dataContact.getDataContact());
        }
        if (arrNewContact == null){
            arrNewContact = new ArrayList<>();
        }
        if (arrContacts != null) {
            rvAdapter = new RVAdapter(arrContacts,arrNewContact);
            rvList.setAdapter(rvAdapter);
            rvAdapter.notifyDataSetChanged();
        }
        Log.e("----","========="+arrNewContact);
    }
}
