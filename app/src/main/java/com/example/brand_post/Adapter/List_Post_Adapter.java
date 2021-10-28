package com.example.brand_post.Adapter;

import static com.example.brand_post.Activity.Editing_post.image;
import static com.example.brand_post.Activity.Select_Fram.s_img;
import static com.example.brand_post.Util.Constant.imageLink;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.brand_post.Activity.Editing_post;
import com.example.brand_post.Activity.Post_list;
import com.example.brand_post.Activity.Select_Fram;
import com.example.brand_post.R;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.Model.PostModel;

import java.util.List;

public class List_Post_Adapter extends RecyclerView.Adapter<List_Post_Adapter.viewData> {

    Activity activity;
    List<PostModel> list;
    private String TAG;
    String n;
    int i;

    public List_Post_Adapter(Post_list mainActivity, List<PostModel> list, String n) {
        activity = mainActivity;
        this.list = list;
        this.n = n;

    }

    public List_Post_Adapter(Select_Fram select_fram, List<PostModel> filter_post_list1, int i) {
        activity = select_fram;
        this.list = filter_post_list1;
        this.i = i;

    }

    @NonNull
    @Override
    public viewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.image_list, parent, false);
        return new viewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewData holder, @SuppressLint("RecyclerView") int position) {
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (i == 1) {

                    Glide.with(activity)
                            .load(imageLink + "" + list.get(position).getimage_name())
                            .centerCrop()
                            .into(s_img);

                } else {
                    Intent intent = new Intent(activity, Select_Fram.class);
                    intent.putExtra("post", imageLink + "" + list.get(position).getimage_name());
                    intent.putExtra("value_position", n);
//                Toast.makeText(activity, ""+ imageLink +""+list.get(position).getimage_name(), Toast.LENGTH_SHORT).show();
                    activity.startActivity(intent);
                }
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
            card = itemView.findViewById(R.id.card1);
            image_view = itemView.findViewById(R.id.image_view1);
        }
    }
}
