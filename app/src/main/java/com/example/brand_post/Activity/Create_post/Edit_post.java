package com.example.brand_post.Activity.Create_post;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.brand_post.Activity.Payment.Package;
import com.example.brand_post.Activity.PostList.Select_Fram;
import com.example.brand_post.Adapter.Fram_Adapter;
import com.example.brand_post.R;
import com.example.brand_post.Util.Constant;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;


public class Edit_post extends AppCompatActivity {

    private ImageView e_img, s_save_btn;
    private BottomSheetDialog bottomSheetDialog;
    private ImageView edit_setting_image;
    private BottomSheetDialog bottomSheetDialog1;
    private TextView mobile, email_txt, title_text_ep;
    private HorizontalScrollView scroll;
    private RecyclerView rv_view_frame;
    int[] layout_fram={R.layout.frame2,R.layout.frame3};
    Constant constant;
    private FrameLayout e_main_save_frame;
    private ScrollingPagerIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_post);
        constant=new Constant();
        //ID=========
        rv_view_frame=findViewById(R.id.rv_view_frame);
        e_img = findViewById(R.id.e_img);
        e_img.setImageBitmap(Select_Fram.bitmap_image);
        s_save_btn = findViewById(R.id.s_save_btn);
        edit_setting_image = findViewById(R.id.edit_setting_image);
        title_text_ep = findViewById(R.id.title_text_ep);
        mobile = findViewById(R.id.mobile);
        email_txt = findViewById(R.id.email_txt);
        mobile = findViewById(R.id.mobile);
        e_main_save_frame=findViewById(R.id.e_main_save_frame);
        indicator=findViewById(R.id.indicator);

//        Fram_Adapter fram_adapter=new Fram_Adapter(this,layout_fram);
//        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
//        rv_view_frame.setLayoutManager(layoutManager);
//        rv_view_frame.setAdapter(fram_adapter);
//        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
//        linearSnapHelper.attachToRecyclerView(rv_view_frame);
//        indicator.attachToRecyclerView(rv_view_frame);




        edit_setting_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Image_Settings();
                bottomSheetDialog1.show();
            }
        });

        s_save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_downlod_Dialoge();
                bottomSheetDialog.show();
            }
        });

    }


    void image_downlod_Dialoge() {
        bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.downlode_dialoge_item);
        LinearLayout subcribe = bottomSheetDialog.findViewById(R.id.subcribe);
        LinearLayout watch_video = bottomSheetDialog.findViewById(R.id.watch_video);
        LinearLayout close_bottom_sheet = bottomSheetDialog.findViewById(R.id.close_bottom_sheet);


        close_bottom_sheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.dismiss();
            }
        });

        // Show Ad
        watch_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ad Code

                Bitmap finalEditedImage = constant.getMainFrameBitmap(e_main_save_frame);
                constant.save_Post(Edit_post.this,finalEditedImage);
            }
        });

        // Show a Package
        subcribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Payment code hear
                startActivity(new Intent(Edit_post.this, Package.class));
            }
        });

    }

    void Image_Settings() {
        bottomSheetDialog1 = new BottomSheetDialog(Edit_post.this);
        bottomSheetDialog1.setContentView(R.layout.settings_bottom);
        CheckBox sb_mobile_txt_chk = bottomSheetDialog1.findViewById(R.id.sb_mobile_txt_chk);
        CheckBox sb_email_txt_chk = bottomSheetDialog1.findViewById(R.id.sb_email_txt_chk);
        CheckBox sb_business_txt_chk = bottomSheetDialog1.findViewById(R.id.sb_business_txt_chk);



        sb_mobile_txt_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    mobile.setVisibility(View.VISIBLE);
                } else {
                    mobile.setVisibility(View.GONE);

                }
            }
        });
        sb_email_txt_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    email_txt.setVisibility(View.VISIBLE);
                } else {
                    email_txt.setVisibility(View.GONE);

                }
            }
        });
        sb_business_txt_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    title_text_ep.setVisibility(View.VISIBLE);
                } else {
                    title_text_ep.setVisibility(View.GONE);

                }
            }
        });
    }
}