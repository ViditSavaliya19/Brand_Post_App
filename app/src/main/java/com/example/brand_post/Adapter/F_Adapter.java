package com.example.brand_post.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.example.brand_post.Activity.Share_Post;
import com.example.brand_post.BuildConfig;
import com.example.brand_post.R;
import com.example.brand_post.Util.Model.SAVEDATA;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


public class F_Adapter extends RecyclerView.Adapter<F_Adapter.dataholder> {

    Activity activity;
    List<SAVEDATA> uriArrayList = new ArrayList<>();
    private File fp;

    public F_Adapter(FragmentActivity activity, List<SAVEDATA> uriArrayList) {
        this.activity = activity;
        this.uriArrayList = uriArrayList;
    }

    @NonNull
    @Override
    public dataholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.poster_item, parent, false);
        return new dataholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull dataholder holder, @SuppressLint("RecyclerView") int position) {
        holder.txt1.setImageBitmap(uriArrayList.get(position).getImg());
        holder.txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                 fp=uriArrayList.get(position).getFp();
                 Intent intent=new Intent(activity, Share_Post.class);
                 intent.putExtra("img",uriArrayList.get(position).getUri());
                 intent.putExtra("file",fp);
                 activity.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return uriArrayList.size();
    }

    class dataholder extends RecyclerView.ViewHolder {
        private final ImageView txt1;

        public dataholder(@NonNull View itemView) {
            super(itemView);
            txt1 = itemView.findViewById(R.id.txt1);
        }
    }

    public Bitmap loadBitmap(String url) {
        Bitmap bm = null;
        InputStream is = null;
        BufferedInputStream bis = null;
        try {
            URLConnection conn = new URL(url).openConnection();
            conn.connect();
            is = conn.getInputStream();
            bis = new BufferedInputStream(is, 8192);
            bm = BitmapFactory.decodeStream(bis);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return bm;
    }

}
