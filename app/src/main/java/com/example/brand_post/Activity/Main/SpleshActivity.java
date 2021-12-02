package com.example.brand_post.Activity.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.brand_post.Activity.Login_Ragistration.Login_Activity;
import com.example.brand_post.R;
import com.example.brand_post.Util.Model.BusinessDatum;
import com.example.brand_post.Util.Model.Cate_model;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.Model.Model_Ragister;
import com.example.brand_post.Util.Model.PostModel;
import com.example.brand_post.Util.Model.Slider_data;
import com.example.brand_post.Util.Model.Sub_Model;

import java.util.ArrayList;
import java.util.List;

public class SpleshActivity extends AppCompatActivity {
    public static List<PostModel> postModelList = new ArrayList<PostModel>();
    public static List<Cate_model> cate_modelList = new ArrayList<Cate_model>();
    public static List<Sub_Model> sub_modelList = new ArrayList<Sub_Model>();
    public static List<Slider_data> slider_list_s = new ArrayList<Slider_data>();
    public static List<BusinessDatum> businessData_list_s = new ArrayList<BusinessDatum>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splesh);

        Constant constant = new Constant();
        postModelList = constant.GetData();
        cate_modelList = constant.GetCategory();
        sub_modelList = constant.GetSub();
         constant.Slider();


        Model_Ragister model_ragister = new Model_Ragister("xyz", "xyz1@gmail.com", "12345", "xyz Com", "image.jpg", "7046632532", "1000");

//        constant.Registration(model_ragister);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SpleshActivity.this, Login_Activity.class);
                startActivity(intent);
            }
        }, 3000);
    }


}