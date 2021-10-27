package com.example.brand_post.Util;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    public static String URL = "https://satkaivalsaheb.xyz/app/html/";
    public static Retrofit retrofit = null;

    public static Retrofit getData() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
                .build();
        return retrofit;
    }
}
