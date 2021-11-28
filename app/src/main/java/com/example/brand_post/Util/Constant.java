package com.example.brand_post.Util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.loader.content.CursorLoader;

import com.example.brand_post.Activity.Editing_post;
import com.example.brand_post.Activity.Login_Activity;
import com.example.brand_post.Activity.SpleshActivity;
import com.example.brand_post.Util.Model.BusinessDatum;
import com.example.brand_post.Util.Model.Cate_model;
import com.example.brand_post.Util.Model.Model_Ragister;
import com.example.brand_post.Util.Model.PostModel;
import com.example.brand_post.Util.Model.Slider_data;
import com.example.brand_post.Util.Model.Sub_Model;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Constant {


    public static String imageLink = "https://satkaivalsaheb.xyz/app/html/images/";
    public static String ThumbLink = "https://satkaivalsaheb.xyz/app/html/thumb/";
    public List<PostModel> postModelList = new ArrayList<PostModel>();
    public List<Cate_model> cate_modelList1 = new ArrayList<Cate_model>();
    public List<Sub_Model> sub_modelList1 = new ArrayList<Sub_Model>();
    public List<Slider_data> slider_list = new ArrayList<Slider_data>();
    public List<BusinessDatum> business_data_list = new ArrayList<BusinessDatum>();

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
                        Log.e("TAG", "=============>> " + imageLink + "" + postModelList.get(0).getimage_name());
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
                Log.e("TAG", "onFailure: " + t.getMessage());
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
                        String type = user.get(i).getType();

                        Sub_Model model = new Sub_Model();
                        model.setId(id);
                        model.setDate(date);
                        model.setName(name);
                        model.setImage(image);
                        model.setC_id(title);
                        model.setType(type);

                        sub_modelList1.add(model);
                        Log.e("sub", "id      : " + id);
                        Log.e("sub", "title   : " + name);
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Sub_Model>> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
            }
        });
        return sub_modelList1;
    }

    //SLIDER ================================


    public List<Slider_data> Slider() {
        Api_Inter apiInterface = Api.getData().create(Api_Inter.class);
        apiInterface.getSlider().enqueue(new Callback<List<Slider_data>>() {
            @Override
            public void onResponse(Call<List<Slider_data>> call, Response<List<Slider_data>> response) {
                if (response.isSuccessful()) {

                    slider_list = response.body();
                    SpleshActivity.slider_list_s=slider_list;
                    Log.e("TAG", "onResponse: SLider**************** "+slider_list.size() );
                    Log.e("TAG", "onBindViewHolder: *************** ------- "+imageLink+slider_list.get(0).getName());

                }

            }

            @Override
            public void onFailure(Call<List<Slider_data>> call, Throwable t) {

            }


        });

        return slider_list;

    }

//Registration =================================

    public void Registration(Activity activity, Model_Ragister model_ragister, Uri file1, Bitmap bitmap) {

//        File file = new File(file1.toString());

        File file = new File(FileUtil.getPath(file1, activity));

        // Parsing any Media type file
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
        RequestBody filename = RequestBody.create(MediaType.parse("multipart/form-data"), file.getName());


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imageBytes = byteArrayOutputStream.toByteArray();
        String imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT);


        Log.e("TAG", "Registration: Byte Array ====          " + imageString);


        Api_Inter api_inter = Api.getData().create(Api_Inter.class);
        api_inter.getRagi(model_ragister.getName(), model_ragister.getEmail(), model_ragister.getPassword(), model_ragister.getBusiness_name(), imageString, model_ragister.getMobile(), model_ragister.getPlan()).enqueue(new Callback<Model_Ragister>() {
            @Override
            public void onResponse(Call<Model_Ragister> call, Response<Model_Ragister> response) {

                Model_Ragister model_ragister1 = response.body();

                Log.e("TAG", "onResponse: Registration " + response.errorBody());
            }

            @Override
            public void onFailure(Call<Model_Ragister> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
            }
        });

        api_inter.getImage(fileToUpload, filename).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

                if (response.isSuccessful()) {
                    Log.e("TAG", "onResponse: image " + response.body());
                }

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e("TAG", "onFailure: image " + t.getMessage());
            }
        });
    }


    String getRealPathFromURI(Activity activity, Uri contentUri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(activity, contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();
        return result;
    }


    // =========================

    public List<BusinessDatum> getBusiness() {
        Api_Inter apiInterface = Api.getData().create(Api_Inter.class);
        apiInterface.getBusiness().enqueue(new Callback<List<BusinessDatum>>() {
            @Override
            public void onResponse(Call<List<BusinessDatum>> call, Response<List<BusinessDatum>> response) {
                if (response.isSuccessful()) {

                    business_data_list = response.body();
                    SpleshActivity.businessData_list_s=business_data_list;
                    Log.e("TAG", "onResponse: Business**************** "+business_data_list.size() );
                    Log.e("TAG", "onBindViewHolder: *************** ------- "+imageLink+business_data_list.get(0).getLogo());


                }

            }

            @Override
            public void onFailure(Call<List<BusinessDatum>> call, Throwable t) {

            }


        });

        return business_data_list;

    }





// Shard pref ================================


    public void Pref(Activity activity, Model_Ragister model_ragister) {

        Log.e("TAG", "Pref: " + model_ragister.getBusiness_name() + " ******  " + model_ragister.getProfile_image());
        SharedPreferences sharedPreferences = activity.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name", model_ragister.getName());
        editor.putString("Email", model_ragister.getEmail());
        editor.putString("Password", model_ragister.getPassword());
        editor.putString("Business", model_ragister.getBusiness_name());
        editor.putString("mobile", model_ragister.getMobile());
        editor.putString("image", model_ragister.getProfile_image());
        editor.putString("plan", model_ragister.getPlan());
        editor.commit();
    }


    public Model_Ragister Read_Pref(Activity activity) {
        Model_Ragister model_ragister = new Model_Ragister();
        SharedPreferences sharedPreferences = activity.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        model_ragister.setName(sharedPreferences.getString("Name", null));
        model_ragister.setEmail(sharedPreferences.getString("Email", null));
        model_ragister.setPassword(sharedPreferences.getString("Password", null));
        model_ragister.setBusiness_name(sharedPreferences.getString("Business", null));
        model_ragister.setMobile(sharedPreferences.getString("mobile", null));
        model_ragister.setProfile_image(sharedPreferences.getString("image", null));
        model_ragister.setPlan(sharedPreferences.getString("plan", null));


        return model_ragister;
    }

    public void ClearPref(Activity activity)
    {
        SharedPreferences sharedPreferences = activity.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        activity.startActivity(new Intent(activity, Login_Activity.class));

    }




    public  void Add_Selected_Business_pref(Activity activity, List<BusinessDatum> model_ragister, int position)
    {
        SharedPreferences sharedPreferences = activity.getSharedPreferences("Business_pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name", model_ragister.get(position).getName());
        editor.putString("Email", model_ragister.get(position).getEmail());
        editor.putString("Website", model_ragister.get(position).getWebsite());
        editor.putString("mobile", model_ragister.get(position).getMobile());
        editor.putString("image", model_ragister.get(position).getLogo());
        editor.putString("user_number", model_ragister.get(position).getUserNumber());
        editor.commit();
    }

    public BusinessDatum getSelected_business(Activity activity)
    {

        BusinessDatum model_ragister = new BusinessDatum();
        SharedPreferences sharedPreferences = activity.getSharedPreferences("Business_pref", Context.MODE_PRIVATE);
        model_ragister.setName(sharedPreferences.getString("Name", null));
        model_ragister.setEmail(sharedPreferences.getString("Email", null));
        model_ragister.setWebsite(sharedPreferences.getString("Website", null));
        model_ragister.setMobile(sharedPreferences.getString("mobile", null));
        model_ragister.setLogo(sharedPreferences.getString("image", null));
        model_ragister.setUserNumber(sharedPreferences.getString("user_number",null));

        return model_ragister;
    }

// Save Post====================================================

    public Bitmap getMainFrameBitmap(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmap));
        return bitmap;
    }

    public void save_Post(Activity editing_post, Bitmap imageToSave) {
        String ts = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()).toString();
        File direct = new File(Environment.getExternalStorageDirectory() + "/Daily Post Maker");

        if (!direct.exists()) {
            File wallpaperDirectory = new File("/sdcard/Daily Post Maker/");
            wallpaperDirectory.mkdirs();
        }

        File file = new File("/sdcard/Daily Post Maker/", ts + ".png");
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            imageToSave.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
            Toast.makeText(editing_post, "Success save", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
