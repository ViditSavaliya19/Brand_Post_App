package com.example.brand_post.Adapter;

import static com.example.brand_post.Fragments.Dashbord_Fragment.circle_profile;
import static com.example.brand_post.Fragments.Dashbord_Fragment.email_profile_h;
import static com.example.brand_post.Fragments.Dashbord_Fragment.name_profile_h;
import static com.example.brand_post.Fragments.Dashbord_Fragment.sheetDialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.brand_post.Activity.Business.AB_Activity;
import com.example.brand_post.Activity.Post_list;
import com.example.brand_post.Activity.SpleshActivity;
import com.example.brand_post.R;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.Model.BusinessDatum;
import com.example.brand_post.Util.Model.Sub_Model;

import java.util.List;

public class Selecct_business_Adapter extends RecyclerView.Adapter<Selecct_business_Adapter.viewData> {

    Activity activity;
    List<BusinessDatum> list;
    private String TAG;
    Constant constant;

    public Selecct_business_Adapter(FragmentActivity mainActivity, List<BusinessDatum> list) {
        activity = mainActivity;
        this.list = list;
    }
    public Selecct_business_Adapter(AB_Activity mainActivity, List<BusinessDatum> list) {
        activity = mainActivity;
        this.list = list;
    }


    @NonNull
    @Override
    public viewData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_business_list, parent, false);

        return new viewData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewData holder, @SuppressLint("RecyclerView") int position) {
        holder.txt_business_name.setText(list.get(position).getName());
        Glide.with(activity).load(Constant.imageLink + "" + list.get(position).getLogo()).into(holder.img_business_logo);

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Glide.with(activity).load(Constant.imageLink + SpleshActivity.businessData_list_s.get(position).getLogo()).into(circle_profile);
                email_profile_h.setText(SpleshActivity.businessData_list_s.get(position).getEmail());
                name_profile_h.setText(SpleshActivity.businessData_list_s.get(position).getName());
                sheetDialog.dismiss();
                constant =new Constant();
                constant.Add_Selected_Business_pref(activity,SpleshActivity.businessData_list_s,position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewData extends RecyclerView.ViewHolder {
        private final TextView txt_business_name;
        private final ImageView img_business_logo;
        private final CardView card;

        public viewData(@NonNull View itemView) {
            super(itemView);
            txt_business_name = itemView.findViewById(R.id.txt_business_name);
            card = itemView.findViewById(R.id.card);
            img_business_logo = itemView.findViewById(R.id.img_business_logo);
        }
    }
}
