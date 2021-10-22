package com.example.brand_post.Fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brand_post.Activity.Business_edit;
import com.example.brand_post.R;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.Model.Model_Ragister;

import java.util.ArrayList;
import java.util.List;

public class Business_Fragment extends Fragment {


    private ImageView edit_deatils;
    List<String> list = new ArrayList<>();
    private TextView b_edt_name, b_edt_degi, fb_mobile_txt, fb_plan_txt, fb_Mail_txt, fb_Name_txt;
    private ImageView image_view;
    Model_Ragister model_ragister = new Model_Ragister();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_business_, container, false);
        Constant constant = new Constant();

        b_edt_name = view.findViewById(R.id.b_edt_name);
        b_edt_degi = view.findViewById(R.id.b_edt_degi);
        image_view = view.findViewById(R.id.image_view);

        fb_mobile_txt = view.findViewById(R.id.fb_mobile_txt);
        fb_plan_txt = view.findViewById(R.id.fb_plan_txt);
        fb_Mail_txt = view.findViewById(R.id.fb_Mail_txt);
        fb_Name_txt = view.findViewById(R.id.fb_Name_txt);


        model_ragister = constant.Read_Pref(getActivity());

        fb_Name_txt.setText(model_ragister.getName());
        fb_Mail_txt.setText(model_ragister.getEmail());
        fb_mobile_txt.setText(model_ragister.getMobile());
        fb_plan_txt.setText(model_ragister.getPlan());
        b_edt_name.setText(model_ragister.getName());
        b_edt_degi.setText(model_ragister.getBusiness_name());



//        if (!(list = constant.Read_Pref(getActivity())).isEmpty()) {
//
//            if (list.get(3) != null) {
//                String[] split = list.get(3).substring(1, list.get(3).length() - 1).split(", ");
//                byte[] array = new byte[split.length];
//                for (int i = 0; i < split.length; i++) {
//                    array[i] = Byte.parseByte(split[i]);
//                }
//
//                Bitmap bmp = BitmapFactory.decodeByteArray(array, 0, array.length);
//
//                image_view.setImageBitmap(bmp);
//                b_edt_name.setText(list.get(0));
//                b_edt_degi.setText(list.get(1));
//            }
//        }


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