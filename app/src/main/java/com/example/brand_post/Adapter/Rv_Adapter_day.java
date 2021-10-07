package com.example.brand_post.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brand_post.Activity.Post_list;
import com.example.brand_post.R;
import com.example.brand_post.Util.Model.Sub_Model;

import java.util.List;

public class Rv_Adapter_day extends RecyclerView.Adapter<Rv_Adapter_day.viewData> {

    Activity activity;
    List<Sub_Model> list;
    private String TAG;

    public Rv_Adapter_day(FragmentActivity mainActivity, List<Sub_Model> list) {
        activity = mainActivity;
        this.list = list;
    }

    @NonNull
    @Override
    public viewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_list, parent, false);
        return new viewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewData holder, @SuppressLint("RecyclerView") int position) {
        holder.txt.setText(list.get(position).getName());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity, Post_list.class);
                intent.putExtra("value_position",list.get(position).getId().toString());
                activity.startActivity(intent);

            }
        });
//        for (int i = 0; i < postModelList.size(); i++) {
//
//            if (list.get(position).getId().equals(postModelList.get(i).gets_cate())) {
//
//                Log.e(TAG, "=============>> " + postModelList.get(i).gets_cate());
//                Glide.with(activity)
//                        .load(imageLink + "" + postModelList.get(position).getimage_name().toString())
//                        .centerCrop()
//                        .into(holder.image_view);
//            }
//        }



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewData extends RecyclerView.ViewHolder {
        private final TextView txt;
        private final ImageView image_view;
        private final CardView card;

        public viewData(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.txt);
            card=itemView.findViewById(R.id.card);
            image_view = itemView.findViewById(R.id.image_view);
        }
    }
}
