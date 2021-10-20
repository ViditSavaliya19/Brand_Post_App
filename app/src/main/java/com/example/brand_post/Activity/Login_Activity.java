package com.example.brand_post.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.brand_post.Fragments.Dashbord_Fragment;
import com.example.brand_post.Util.Api;
import com.example.brand_post.Util.Api_Inter;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.Model.Data.Example;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;


import com.example.brand_post.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_Activity extends AppCompatActivity {


    private LinearLayout login_btn;
    private boolean isResult;
    private Example model_ragister1;
    boolean isCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Constant constant=new Constant();

        login_btn=findViewById(R.id.login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Login("xyz@gmail.com","112345");
            }
        });
    }

    public boolean Login(String email,String password)
    {

        Api_Inter api_inter= Api.getData().create(Api_Inter.class);
        api_inter.getLoginData(email,password).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                model_ragister1=response.body();

                if(model_ragister1!=null)
                {
                    startActivity(new Intent(Login_Activity.this, Home.class));
                }

                Log.e("TAG", "onResponse: Registration "+model_ragister1.getMsg() );

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("TAG", "onFailure: "+t.getMessage() );
                isCheck = false;
            }
        });
        return  isCheck;
    }

}