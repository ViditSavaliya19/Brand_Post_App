package com.example.brand_post.Util;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_Inter {

    @GET("post.php/")
    Call<List<PostModel>> getUser();

    @GET("capi.php/")
    Call<List<PostModel>> getCategory();

    @GET("sub_cate.php/")
    Call<List<PostModel>> getSub_Category();
}
