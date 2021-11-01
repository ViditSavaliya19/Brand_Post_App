package com.example.brand_post.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.brand_post.Activity.Payment.Package;
import com.example.brand_post.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Edit_post extends AppCompatActivity {

    private ImageView e_img, s_save_btn;
    private BottomSheetDialog bottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_post);
        //ID=========

        e_img = findViewById(R.id.e_img);
        e_img.setImageBitmap(Select_Fram.bitmap_image);
        s_save_btn = findViewById(R.id.s_save_btn);

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
        LinearLayout close_bottom_sheet=bottomSheetDialog.findViewById(R.id.close_bottom_sheet);


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
}