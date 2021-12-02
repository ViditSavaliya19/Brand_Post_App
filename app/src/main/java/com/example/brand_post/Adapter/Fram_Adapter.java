package com.example.brand_post.Adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brand_post.Activity.Create_post.Edit_post;
import com.example.brand_post.Activity.Create_post.Editing_post;
import com.example.brand_post.R;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.Model.BusinessDatum;

public class Fram_Adapter extends RecyclerView.Adapter<Fram_Adapter.ViewData> {
    Activity activity;
    int[] layout_fram;
    Constant constant;

    public Fram_Adapter(Edit_post edit_post, int[] layout_fram) {
        this.activity = edit_post;
        this.layout_fram = layout_fram;
    }

    public Fram_Adapter(Editing_post edit_post, int[] layout_fram) {
        this.activity = edit_post;
        this.layout_fram = layout_fram;
    }

    @NonNull
    @Override
    public ViewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.frame_view, parent, false);
        return new ViewData(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewData holder, int position) {
        View view = LayoutInflater.from(activity).inflate(layout_fram[position], null, false);
//        TextView mobile_f3 = view.findViewById(R.id.mobile_f3);
        constant=new Constant();
        TextView mobile_f2 = view.findViewById(R.id.f2_mobile);
        TextView web_f = view.findViewById(R.id.f_web);
        TextView email_f = view.findViewById(R.id.f_email);

        Constant constant = new Constant();
        BusinessDatum model1 = constant.getSelected_business(activity);

        mobile_f2.setText(model1.getMobile());
        web_f.setText(model1.getName());
        email_f.setText(model1.getEmail());

        Log.e("TAG", "Read Pref: ========"+model1.getName() );

        holder.liner_frame_view.addView(view);





    }



    @Override
    public int getItemCount() {
        return layout_fram.length;
    }

    class ViewData extends RecyclerView.ViewHolder {
        LinearLayout liner_frame_view;

        public ViewData(@NonNull View itemView) {
            super(itemView);

            liner_frame_view = itemView.findViewById(R.id.liner_frame_view);


        }
    }

    public void RefreshTools() {



    }

}
