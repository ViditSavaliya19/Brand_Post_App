package com.example.brand_post.Adapter;

import static com.example.brand_post.Util.Constant.postModelList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brand_post.MainActivity;
import com.example.brand_post.R;

public class Rv_Adapter extends RecyclerView.Adapter<Rv_Adapter.viewData> {

    Activity activity;

    public Rv_Adapter(MainActivity mainActivity) {
        activity=mainActivity;
    }

    @NonNull
    @Override
    public viewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(activity).inflate(R.layout.item_list,parent,false);
        return new viewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewData holder, int position) {
        holder.txt.setText(postModelList.get(position).getimage_name());
    }

    @Override
    public int getItemCount() {
        return postModelList.size();
    }

    class viewData extends RecyclerView.ViewHolder {
        private final TextView txt;

        public viewData(@NonNull View itemView) {
            super(itemView);
            txt=itemView.findViewById(R.id.txt);
        }
    }
}
