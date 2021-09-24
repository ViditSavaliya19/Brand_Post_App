package com.example.brand_post.Util;

import com.example.brand_post.Util.Model.Cate_model;
import com.example.brand_post.Util.Model.PostModel;
import com.example.brand_post.Util.Model.Sub_Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_Inter {

    @GET("post.php/")
    Call<List<PostModel>> getUser();

    @GET("capi.php/")
    Call<List<Cate_model>> getCategory();

    @GET("sub_cate_api.php/")
    Call<List<Sub_Model>> getSub_Category();
}
