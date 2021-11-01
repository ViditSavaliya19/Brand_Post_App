package com.example.brand_post.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.brand_post.R;

public class Custome_edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custome_edit);

        ImageView c_pick_image=findViewById(R.id.c_pick_image);

        c_pick_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pick_Image();
            }
        });
    }

    private void pick_Image() {

    }
}