package com.example.brand_post.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.brand_post.R;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.Model.Slider_data;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapterExample extends SliderViewAdapter<SliderAdapterExample.SliderAdapterVH> {

    private Context context;

//    String image[]={"https://chennaidesignshoppe.com/wp-content/uploads/2020/11/festival-post-design-banner-top.jpg","https://pbs.twimg.com/media/Esju0TMXcAEOvu9.jpg","https://yi-files.s3.eu-west-1.amazonaws.com/products/1000000/1000128/1679036-full.jpg"};
    private List<Slider_data> mSliderItems = new ArrayList<Slider_data>();

    public SliderAdapterExample(Context context, List<Slider_data> slider_list_s1) {
        this.context = context;
        this.mSliderItems=slider_list_s1;
    }


    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {

        Glide.with(viewHolder.itemView)
                .load(Constant.imageLink+mSliderItems.get(position).getName())
                .fitCenter()
                .into(viewHolder.imageViewBackground);


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mSliderItems.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            this.itemView = itemView;
        }
    }

}
