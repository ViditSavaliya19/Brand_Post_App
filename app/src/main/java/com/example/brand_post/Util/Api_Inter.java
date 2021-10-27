package com.example.brand_post.Util;

import com.example.brand_post.Util.Model.Cate_model;
import com.example.brand_post.Util.Model.Data.Datum;
import com.example.brand_post.Util.Model.Data.Example;
import com.example.brand_post.Util.Model.Model_Ragister;
import com.example.brand_post.Util.Model.PostModel;
import com.example.brand_post.Util.Model.Sub_Model;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Api_Inter {

    @GET("post.php/")
    Call<List<PostModel>> getUser();

    @GET("capi.php/")
    Call<List<Cate_model>> getCategory();

    @GET("sub_cate_api.php/")
    Call<List<Sub_Model>> getSub_Category();

    @FormUrlEncoded
    @POST("postapi.php/")
    Call<Model_Ragister> getRagi(@Field("name") String  name,@Field("email")String  email,@Field("password")String  password,@Field("business_name")String  b_name,@Field("profile_image")String  profile,@Field("mobile")String  mobile,@Field("plan")String  plan);

    @FormUrlEncoded
    @POST("loginapi.php")
    Call<Example>getLoginData(@Field("email")String email, @Field("password")String password);
}
