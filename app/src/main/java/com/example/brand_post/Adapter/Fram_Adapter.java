package com.example.brand_post.Adapter;

import static com.example.brand_post.Activity.Editing_post.business_txt_chk;
import static com.example.brand_post.Activity.Editing_post.email_txt_chk;
import static com.example.brand_post.Activity.Editing_post.mobile_txt_chk;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brand_post.Activity.Edit_post;
import com.example.brand_post.Activity.Editing_post;
import com.example.brand_post.R;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.Model.Model_Ragister;

public class Fram_Adapter extends RecyclerView.Adapter<Fram_Adapter.ViewData> {
    Activity activity;
    int[] layout_fram;

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
        TextView mobile_f2 = view.findViewById(R.id.f2_mobile);
        TextView web_f = view.findViewById(R.id.f_web);
        TextView email_f = view.findViewById(R.id.f_email);

        Constant constant = new Constant();
        Model_Ragister model1 = constant.Read_Pref(activity);

        mobile_f2.setText(model1.getMobile());
        web_f.setText(model1.getName());
        email_f.setText(model1.getEmail());

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
