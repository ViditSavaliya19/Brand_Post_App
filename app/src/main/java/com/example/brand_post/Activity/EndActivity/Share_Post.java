package com.example.brand_post.Activity.EndActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.brand_post.R;

import java.io.File;

public class Share_Post extends AppCompatActivity {

    private LinearLayout shr_more_l, shr_fb_l, shr_insta_l, shr_whatsapp_l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_post);

        String uri = getIntent().getStringExtra("img");
        File file = (File) getIntent().getParcelableExtra("file");

        ImageView shr_img = findViewById(R.id.shr_img);
        shr_fb_l = findViewById(R.id.shr_fb_l);
        shr_insta_l = findViewById(R.id.shr_insta_l);
        shr_whatsapp_l = findViewById(R.id.shr_whatsapp_l);
        shr_more_l = findViewById(R.id.shr_more_l);

        shr_img.setImageURI(Uri.parse(uri));

        shr_fb_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/*");
                intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(getApplicationContext(), "com.example.brand_post", new File(uri)));
                intent.setPackage("com.facebook.katana");
                startActivity(intent);
            }
        });

        shr_insta_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/*");
                intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(getApplicationContext(), "com.example.brand_post", new File(uri)));
                intent.setPackage("com.instagram.android");
                startActivity(intent);

            }
        });

        shr_whatsapp_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/*");
                intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(getApplicationContext(), "com.example.brand_post", new File(uri)));
                intent.setPackage("com.whatsapp");
                startActivity(intent);

            }
        });
        shr_more_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/*");
                intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(getApplicationContext(), "com.example.brand_post", new File(uri)));
                startActivity(Intent.createChooser(intent, "Share"));
            }
        });

    }

}