package com.example.brand_post.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brand_post.Fragments.Dashbord_Fragment;
import com.example.brand_post.Util.Api;
import com.example.brand_post.Util.Api_Inter;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.Model.Data.Example;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;


import com.example.brand_post.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_Activity extends AppCompatActivity {


    private LinearLayout login_btn;
    private boolean isResult;
    private Example model_ragister1;
    boolean isCheck;
    private EditText lEmail_edt;
    private EditText lPassword_edt;
    private TextView l_ragister;
    private List<String> list_data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Constant constant = new Constant();
        l_ragister = findViewById(R.id.l_ragister);
        login_btn = findViewById(R.id.login_btn);
        lEmail_edt = findViewById(R.id.lEmail_edt);
        lPassword_edt = findViewById(R.id.lPassword_edt);

        l_ragister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Activity.this, Register_Activity.class));
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (list_data.size() == 0) {
                    Login(lEmail_edt.getText().toString().trim(), lPassword_edt.getText().toString().trim());
                }
            }
        });
    }

    public boolean Login(String email, String password) {

        Api_Inter api_inter = Api.getData().create(Api_Inter.class);
        api_inter.getLoginData(email, password).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                model_ragister1 = response.body();

                    startActivity(new Intent(Login_Activity.this, Home.class));


                Log.e("TAG", "onResponse: Registration " + model_ragister1.getMsg());

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
                isCheck = false;
            }
        });
        return isCheck;
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences=getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        if(sharedPreferences.getString("email",null).isEmpty() && sharedPreferences.getString("password",null).isEmpty())
        {
            startActivity(new Intent(Login_Activity.this,Home.class));
        }
    }
}
