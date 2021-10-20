package com.example.brand_post.Adapter;

import static com.example.brand_post.Activity.Editing_post.image;
import static com.example.brand_post.Util.Constant.imageLink;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.brand_post.Activity.Editing_post;
import com.example.brand_post.R;
import com.example.brand_post.Util.Model.PostModel;

import java.util.List;

public class Post_Adapter extends RecyclerView.Adapter<Post_Adapter.viewData> {

    Activity activity;
    List<PostModel> list;
    private String TAG;
    String n;

    public Post_Adapter(Editing_post mainActivity, List<PostModel> list, String n) {
        activity = mainActivity;
        this.list = list;
        this.n = n;
    }

    @NonNull
    @Override
    public viewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.edit_bg_item, parent, false);
        return new viewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewData holder, @SuppressLint("RecyclerView") int position) {
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(activity)
                        .load(imageLink + "" + list.get(position).getimage_name())
                        .centerCrop()
                        .into(image);
            }
        });
        Glide.with(activity)
                .load(imageLink + "" + list.get(position).getimage_name())
                .centerCrop()
                .into(holder.image_view);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewData extends RecyclerView.ViewHolder {
        private final ImageView image_view;
        private final CardView card;

        public viewData(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card_edt);
            image_view = itemView.findViewById(R.id.image_view_edt);
        }
    }
}
