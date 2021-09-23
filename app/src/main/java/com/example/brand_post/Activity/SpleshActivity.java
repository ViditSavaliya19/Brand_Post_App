package com.example.brand_post.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;

import com.example.brand_post.MainActivity;
import com.example.brand_post.R;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.PostModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SpleshActivity extends AppCompatActivity {
    public static List<PostModel> postModelList = new ArrayList<PostModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splesh);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SpleshActivity.this,MainActivity.class);
                startActivity(intent);
            }
        },5000);
    }

    @Override
    protected void onStart() {
        Constant constant=new Constant();
        postModelList = constant.GetData();
        super.onStart();
    }
}