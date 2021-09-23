package com.example.brand_post.Util;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Constant {


    public  static String imageLink="http://satkaivalsaheb.xyz/app/html/images/";
    public List<PostModel> postModelList = new ArrayList<PostModel>();


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
}
