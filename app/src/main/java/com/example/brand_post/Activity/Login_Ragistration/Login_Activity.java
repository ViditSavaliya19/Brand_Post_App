package com.example.brand_post.Activity.Login_Ragistration;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.brand_post.Activity.Main.Home;
import com.example.brand_post.Activity.Main.SpleshActivity;
import com.example.brand_post.Util.Api;
import com.example.brand_post.Util.Api_Inter;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.Model.BusinessDatum;
import com.example.brand_post.Util.Model.Data.Example;
import com.example.brand_post.Util.Model.Model_Ragister;

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
    private LinearLayout l_ragister;
    private List<String> list_data = new ArrayList<>();
    Constant constant;
    Model_Ragister model_ragister12 = new Model_Ragister();
//    private List<BusinessDatum> businessData_list_s;
    private Dialog dialog;
    private List<BusinessDatum> businessData_list_s=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        constant = new Constant();
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
                    lodingdialoge();
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
                model_ragister12.setEmail(model_ragister1.getData().get(0).getEmail());
                model_ragister12.setName(model_ragister1.getData().get(0).getName());
                model_ragister12.setPassword(model_ragister1.getData().get(0).getPassword());
                model_ragister12.setMobile(model_ragister1.getData().get(0).getMobile());
                model_ragister12.setPlan(model_ragister1.getData().get(0).getPlan());
                model_ragister12.setBusiness_name(model_ragister1.getData().get(0).getBusinessName());
                model_ragister12.setProfile_image(model_ragister1.getData().get(0).getProfileImage());
                model_ragister12.setUid(model_ragister1.getData().get(0).getUser_id());
                constant.Pref(Login_Activity.this,model_ragister12);

                constant.getBusiness(model_ragister12.getUid());
//                constant.Add_Selected_Business_pref(Login_Activity.this,  businessData_list_s,0);
                Intent i = new Intent(Login_Activity.this, Home.class);
                i.putExtra("uid",model_ragister12.getUid());
                startActivity(i);

                dialog.dismiss();
                Log.e("TAG", "onResponse: Registration " + model_ragister1.getMsg());
                isCheck=true;


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

        model_ragister12 = constant.Read_Pref(Login_Activity.this);
        if (model_ragister12.getEmail() == null) {
        } else {


            constant.getBusiness(model_ragister12.getUid());
            Intent i = new Intent(Login_Activity.this, Home.class);
            i.putExtra("uid",model_ragister12.getUid());
            startActivity(i);

        }
    }

    void lodingdialoge()
    {
        dialog=new Dialog(Login_Activity.this,android.R.style.Theme_Translucent);
        dialog.setContentView(R.layout.loding);
        dialog.show();
    }

    @Override
    public void onBackPressed() {
            finishAffinity();
    }
}
