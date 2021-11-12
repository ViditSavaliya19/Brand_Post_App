package com.example.brand_post.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.brand_post.Activity.Payment.Package;
import com.example.brand_post.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Edit_post extends AppCompatActivity {

    private ImageView e_img, s_save_btn;
    private BottomSheetDialog bottomSheetDialog;
    private ImageView edit_setting_image;
    private BottomSheetDialog bottomSheetDialog1;
    private TextView mobile, email_txt, title_text_ep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_post);
        //ID=========

        e_img = findViewById(R.id.e_img);
        e_img.setImageBitmap(Select_Fram.bitmap_image);
        s_save_btn = findViewById(R.id.s_save_btn);
        edit_setting_image = findViewById(R.id.edit_setting_image);
        title_text_ep = findViewById(R.id.title_text_ep);
        mobile = findViewById(R.id.mobile);
        email_txt = findViewById(R.id.email_txt);
        mobile = findViewById(R.id.mobile);

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