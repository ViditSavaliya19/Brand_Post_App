package com.example.brand_post.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.brand_post.Activity.Payment.Package;
import com.example.brand_post.Activity.Post_list;
import com.example.brand_post.R;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.Model.Sub_Model;

import java.util.List;

public class Packages_Adapter extends RecyclerView.Adapter<Packages_Adapter.viewData> {

    Activity activity;
    private String TAG;
    private Animation scale_anim;


    public Packages_Adapter(Package mainActivity) {
        activity = mainActivity;
    }

    @NonNull
    @Override
    public viewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.packages_item, parent, false);
        return new viewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewData holder, @SuppressLint("RecyclerView") int position) {
        scale_anim = AnimationUtils.loadAnimation(activity, R.anim.scale_anim);
        holder.liner_package.startAnimation(scale_anim);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class viewData extends RecyclerView.ViewHolder {

        LinearLayout liner_package;

        public viewData(@NonNull View itemView) {
            super(itemView);
            liner_package = itemView.findViewById(R.id.liner_package);

        }
    }
}
