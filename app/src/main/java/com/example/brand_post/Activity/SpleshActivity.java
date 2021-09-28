package com.example.brand_post.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.brand_post.MainActivity;
import com.example.brand_post.R;
import com.example.brand_post.Util.Model.Cate_model;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.Model.PostModel;
import com.example.brand_post.Util.Model.Sub_Model;

import java.util.ArrayList;
import java.util.List;

public class SpleshActivity extends AppCompatActivity {
    public static List<PostModel> postModelList = new ArrayList<PostModel>();
    public static List<Cate_model> cate_modelList = new ArrayList<Cate_model>();
    public static List<Sub_Model> sub_modelList = new ArrayList<Sub_Model>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splesh);

        Constant constant=new Constant();
        postModelList = constant.GetData();
        cate_modelList = constant.GetCategory();
        sub_modelList = constant.GetSub();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SpleshActivity.this,MainActivity.class);
                startActivity(intent);
            }
        },5000);
    }


}