package com.example.brand_post.Adapter;

import static com.example.brand_post.Activity.Create_post.Editing_post.bottom_design;
import static com.example.brand_post.Activity.Create_post.Editing_post.title_text;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brand_post.Activity.Create_post.Editing_post;
import com.example.brand_post.R;

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
