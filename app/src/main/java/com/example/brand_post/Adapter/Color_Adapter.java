package com.example.brand_post.Adapter;

import static com.example.brand_post.Activity.Editing_post.bottom_design;
import static com.example.brand_post.Activity.Editing_post.title_text;

import static com.example.brand_post.Util.Constant.imageLink;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.brand_post.Activity.Editing_post;
import com.example.brand_post.R;
import com.example.brand_post.Util.Model.PostModel;

import java.util.List;

public class Color_Adapter extends RecyclerView.Adapter<Color_Adapter.viewData> {

    Activity activity;
    int[] list;
    private String TAG;
    String n;

    public Color_Adapter(Editing_post mainActivity, int[] list) {
        activity = mainActivity;
        this.list = list;
    }

    @NonNull
    @Override
    public viewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.color_item, parent, false);
        return new viewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewData holder, @SuppressLint("RecyclerView") int position) {
        holder.liner_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottom_design.setColorFilter(list[position]);
                title_text.setTextColor(list[position]);

            }
        });
        holder.liner_color.setBackgroundColor(list[position]);
    }

    private int convertDpToPx(int dp){
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
    @Override
    public int getItemCount() {
        return list.length;
    }

    class viewData extends RecyclerView.ViewHolder {
        private final LinearLayout liner_color;

        public viewData(@NonNull View itemView) {
            super(itemView);
            liner_color = itemView.findViewById(R.id.liner_color);
        }
    }
}
