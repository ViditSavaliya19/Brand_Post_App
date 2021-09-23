package com.example.brand_post.Adapter;

import static com.example.brand_post.Util.Constant.imageLink;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.brand_post.MainActivity;
import com.example.brand_post.R;
import com.example.brand_post.Util.PostModel;

import java.util.List;

public class Rv_Adapter extends RecyclerView.Adapter<Rv_Adapter.viewData> {

    Activity activity;
    List<PostModel> list;
    private String TAG;

    public Rv_Adapter(MainActivity mainActivity, List<PostModel> postModelList) {
        activity=mainActivity;
        list=postModelList;
    }

    @NonNull
    @Override
    public viewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(activity).inflate(R.layout.item_list,parent,false);
        return new viewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewData holder, int position) {
        Log.e(TAG, "=============>> "+imageLink+""+list.get(position).getimage_name());
        Glide.with(activity)
                .load(imageLink+""+list.get(position).getimage_name().toString())
                .centerCrop()
                .into(holder.image_view);
        holder.txt.setText(list.get(position).getimage_name());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewData extends RecyclerView.ViewHolder {
        private final TextView txt;
        private final ImageView image_view;

        public viewData(@NonNull View itemView) {
            super(itemView);
            txt=itemView.findViewById(R.id.txt);
            image_view=itemView.findViewById(R.id.image_view);
        }
    }
}
