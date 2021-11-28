package com.example.brand_post.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.brand_post.Activity.Business.AB_Activity;
import com.example.brand_post.Activity.Payment.Package;
import com.example.brand_post.R;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.Model.BusinessDatum;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class Settings_Fragment extends Fragment {

    private LinearLayout s_logout;
    private LinearLayout s_my_business;
    private TextView email_header_setting;
    private TextView business_name_header_settings;
    private CircleImageView circle_profile1_settigs;
    private LinearLayout GetPremium;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_custom_, container, false);

        Constant constant = new Constant();

        email_header_setting = view.findViewById(R.id.email_header_setting);
        business_name_header_settings = view.findViewById(R.id.business_name_header_settings);
        circle_profile1_settigs = view.findViewById(R.id.circle_profile1_settigs);


        BusinessDatum businessDatum = constant.getSelected_business(getActivity());

        Glide.with(getActivity()).load(Constant.imageLink + businessDatum.getLogo());
        email_header_setting.setText(businessDatum.getEmail());
        business_name_header_settings.setText(businessDatum.getName());

        GetPremium = view.findViewById(R.id.GetPremium);
        GetPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Package.class));
            }
        });

        s_logout = view.findViewById(R.id.s_logout);
        s_my_business = view.findViewById(R.id.s_my_business);
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