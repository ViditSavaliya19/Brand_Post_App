package com.example.brand_post.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.brand_post.R;

public class Edit_post extends AppCompatActivity {

    private ImageView e_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_post);
        //ID=========

        e_img=findViewById(R.id.e_img);
        e_img.setImageBitmap(Select_Fram.bitmap_image);
    }
}