package com.example.brand_post.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.brand_post.Activity.Business_edit;
import com.example.brand_post.R;

public class Business_Fragment extends Fragment {


    private ImageView edit_deatils;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_business_, container, false);
        edit_deatils = view.findViewById(R.id.edit_deatils);
        edit_deatils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Business_edit.class));
            }
        });

        return view;
    }
}