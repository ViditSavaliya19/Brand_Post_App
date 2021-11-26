package com.example.brand_post.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.brand_post.Activity.Business.AB_Activity;
import com.example.brand_post.R;
import com.example.brand_post.Util.Constant;

import java.util.List;


public class Settings_Fragment extends Fragment {

    private LinearLayout s_logout;
    private LinearLayout s_my_business;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_custom_, container, false);

        Constant constant = new Constant();


        s_logout = view.findViewById(R.id.s_logout);
        s_my_business=view.findViewById(R.id.s_my_business);
        s_my_business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AB_Activity.class));
            }
        });


        s_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                constant.ClearPref(getActivity());
            }
        });

        return view;
    }
}