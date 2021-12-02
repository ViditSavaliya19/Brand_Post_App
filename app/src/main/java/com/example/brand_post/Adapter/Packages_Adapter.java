package com.example.brand_post.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brand_post.Activity.Payment.Package;
import com.example.brand_post.Activity.Payment.Pay_Activity;
import com.example.brand_post.R;

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

        holder.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity, Pay_Activity.class);
                intent.putExtra("Name","Bhavik Makvana");
                intent.putExtra("Email","bhavik.makvana@paykun.com");
                intent.putExtra("Mobile","9876543210");
                intent.putExtra("Price","2000");
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class viewData extends RecyclerView.ViewHolder {

        LinearLayout liner_package;
        ImageView image2;

        public viewData(@NonNull View itemView) {
            super(itemView);
            liner_package = itemView.findViewById(R.id.liner_package);
            image2 = itemView.findViewById(R.id.image2);

        }
    }
}
