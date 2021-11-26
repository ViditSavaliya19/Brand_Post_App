package com.example.brand_post.Fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.brand_post.Adapter.F_Adapter;
import com.example.brand_post.R;
import com.example.brand_post.Util.Model.SAVEDATA;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class f_Save extends Fragment {
    private RecyclerView rvImage;
    ArrayList<Bitmap> uriArrayList = new ArrayList<>();
    private String[] fileNames;
    private File filepath;
    private File[] files;
    private File imgfile;
    private Bitmap myBitmap;
    List<SAVEDATA> list = new ArrayList<>();
    private File folder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        rvImage = view.findViewById(R.id.rvImage);

        filepath = Environment.getExternalStorageDirectory();
        File directory = new File(filepath.getAbsolutePath() + "/" + "Daily Post Maker");

        folder = new File(filepath.getAbsolutePath() + "/" + "Daily Post Maker");
        if (folder.exists()) {
            files = directory.listFiles();
            if (files.length <= 0) {

                setData();
            }

        } else {
            Toast.makeText(getActivity(), "No Any Post Create", Toast.LENGTH_SHORT).show();
        }
        setRv();
        return view;
    }


    public void setRv() {
        F_Adapter adapter = new F_Adapter(getActivity(), list);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        rvImage.setLayoutManager(layoutManager);
        rvImage.setAdapter(adapter);
    }

    private void setData() {
        for (int i = 0; i < files.length; i++) {
            imgfile = new File(filepath.getAbsolutePath() + "/" + "Daily Post Maker" + "/" + files[i].getName());
            if (imgfile.exists()) {
                myBitmap = BitmapFactory.decodeFile(imgfile.getAbsolutePath());
                SAVEDATA data = new SAVEDATA();
                data.setImg(myBitmap);
                data.setFp(imgfile);
                data.setUri(imgfile.getAbsolutePath());
                list.add(data);
            }


        }
    }
}