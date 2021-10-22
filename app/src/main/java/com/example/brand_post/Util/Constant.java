package com.example.brand_post.Util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.brand_post.Util.Model.Cate_model;
import com.example.brand_post.Util.Model.Data.Example;
import com.example.brand_post.Util.Model.Model_Ragister;
import com.example.brand_post.Util.Model.PostModel;
import com.example.brand_post.Util.Model.Sub_Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Constant {



    public  static String imageLink="https://satkaivalsaheb.xyz/app/html/images/";
    public  static String ThumbLink="https://satkaivalsaheb.xyz/app/html/thumb/";
    public List<PostModel> postModelList = new ArrayList<PostModel>();
    public List<Cate_model> cate_modelList1 = new ArrayList<Cate_model>();
    public List<Sub_Model> sub_modelList1 = new ArrayList<Sub_Model>();


    public List<PostModel> GetData() {

        Api_Inter apiInterface = Api.getData().create(Api_Inter.class);
        apiInterface.getUser().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {

                if (response.isSuccessful()) {

                    List<PostModel> user = response.body();

                    for (int i = 0; i < user.size(); i++) {
                        String id = user.get(i).getId();
                        String title = user.get(i).getm_cate();
                        String body = user.get(i).gets_cate();
                        String body2 = user.get(i).getimage_name();
                        String body3 = user.get(i).getstatus();
                        String body4 = user.get(i).getf_date();
                        String body5 = user.get(i).getlangauge();

                        PostModel model = new PostModel();
                        model.setf_date(body4);
                        model.setId(id);
                        model.setlangauge(body5);
                        model.setimage_name(body2);
                        model.sets_cate(body);
                        model.setm_cate(title);
                        model.setstatus(body3);

                        postModelList.add(model);
                        Log.e("demoo", "id      : " + id);
                        Log.e("demoo", "title   : " + title);
                        Log.e("demoo", "body    : " + body);
                        Log.e("demoo", "-------------------------------------------------");
                        Log.e("TAG", "=============>> "+imageLink+""+postModelList.get(0).getimage_name());
                    }
                }


            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Log.e("Error", "=============>>>>>" + t.getMessage());
            }
        });

        return postModelList;

    }

    public List<Cate_model> GetCategory() {

        Api_Inter apiInterface = Api.getData().create(Api_Inter.class);
        apiInterface.getCategory().enqueue(new Callback<List<Cate_model>>() {
            @Override
            public void onResponse(Call<List<Cate_model>> call, Response<List<Cate_model>> response) {
                if (response.isSuccessful()) {

                    List<Cate_model> user = response.body();

                    for (int i = 0; i < user.size(); i++) {
                        String id = user.get(i).getId();
                        String title = user.get(i).getC_name();

                        Cate_model model = new Cate_model();
                        model.setC_name(title);
                        model.setId(id);

                        cate_modelList1.add(model);
                        Log.e("cate1", "id      : " + id);
                        Log.e("cate1", "title   : " + title);
                    }
                }

            }
            @Override
            public void onFailure(Call<List<Cate_model>> call, Throwable t) {
                Log.e("TAG", "onFailure: "+t.getMessage() );
            }
        });
        return cate_modelList1;
    }


    public List<Sub_Model> GetSub() {

        Api_Inter apiInterface = Api.getData().create(Api_Inter.class);

        apiInterface.getSub_Category().enqueue(new Callback<List<Sub_Model>>() {
            @Override
            public void onResponse(Call<List<Sub_Model>> call, Response<List<Sub_Model>> response) {
                if (response.isSuccessful()) {

                    List<Sub_Model> user = response.body();

                    for (int i = 0; i < user.size(); i++) {
                        String id = user.get(i).getId();
                        String title = user.get(i).getC_id();
                        String name = user.get(i).getName();
                        String date = user.get(i).getDate();
                        String image = user.get(i).getImage();

                        Sub_Model model = new Sub_Model();
                        model.setId(id);
                        model.setDate(date);
                        model.setName(name);
                        model.setImage(image);
                        model.setC_id(title);

                        sub_modelList1.add(model);
                        Log.e("sub", "id      : " + id);
                        Log.e("sub", "title   : " + name);
                    }
                }

            }
            @Override
            public void onFailure(Call<List<Sub_Model>> call, Throwable t) {
                Log.e("TAG", "onFailure: "+t.getMessage() );
            }
        });
        return sub_modelList1;
    }

//Registration =================================

    public void Registration(Model_Ragister model_ragister)
    {


        Api_Inter api_inter=Api.getData().create(Api_Inter.class);
        api_inter.getRagi(model_ragister.getName(),model_ragister.getEmail(),model_ragister.getPassword(),model_ragister.getBusiness_name(),model_ragister.getProfile_image(),model_ragister.getMobile(),model_ragister.getPlan()).enqueue(new Callback<Model_Ragister>() {
            @Override
            public void onResponse(Call<Model_Ragister> call, Response<Model_Ragister> response) {

                Model_Ragister model_ragister1=response.body();


                Log.e("TAG", "onResponse: Registration "+response.errorBody());
            }

            @Override
            public void onFailure(Call<Model_Ragister> call, Throwable t) {
                Log.e("TAG", "onFailure: "+t.getMessage() );
            }
        });
    }


// Shard pref ================================


    public void Pref(Activity activity,Model_Ragister model_ragister)
    {
        SharedPreferences sharedPreferences=activity.getSharedPreferences("MyPref",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("Name",model_ragister.getName());
        editor.putString("Email",model_ragister.getEmail());
        editor.putString("Password",model_ragister.getPassword());
        editor.putString("Business",model_ragister.getBusiness_name());
        editor.putString("mobile",model_ragister.getMobile());
        editor.putString("image",model_ragister.getProfile_image());
        editor.putString("plan",model_ragister.getPlan());
        editor.commit();
    }


    public Model_Ragister Read_Pref(Activity activity)
    {
        Model_Ragister model_ragister=new Model_Ragister();
        SharedPreferences sharedPreferences=activity.getSharedPreferences("MyPref",Context.MODE_PRIVATE);
        model_ragister.setName(sharedPreferences.getString("Name",null));
        model_ragister.setEmail(sharedPreferences.getString("Email",null));
        model_ragister.setPassword(sharedPreferences.getString("Password",null));
        model_ragister.setBusiness_name(sharedPreferences.getString("Business",null));
        model_ragister.setMobile(sharedPreferences.getString("mobile",null));
        model_ragister.setProfile_image(sharedPreferences.getString("image",null));
        model_ragister.setPlan(sharedPreferences.getString("plan",null));

        return model_ragister;
    }



}
