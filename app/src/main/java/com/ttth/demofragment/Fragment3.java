package com.ttth.demofragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ttth.model.Contact;

/**
 * Created by Thanh Hang on 03/01/17.
 */

public class Fragment3 extends Fragment {
    private static final String KEY_DETAIL = "key_detail";
    private Contact contact;
    private TextView tvDetail;
    public static Fragment3 newInstance(Contact contact) {

        Bundle args = new Bundle();
        args.putParcelable(KEY_DETAIL,contact);
        Fragment3 fragment = new Fragment3();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment3, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvDetail = (TextView) view.findViewById(R.id.tvDetail);
        tvDetail.setText("- Name: "+contact.getName()+"\n- Phone number: "+contact.getPhone());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        contact = bundle.getParcelable(KEY_DETAIL);
    }
}
