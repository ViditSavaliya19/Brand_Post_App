package com.example.brand_post.Activity.PostList;

import static com.example.brand_post.Activity.Main.SpleshActivity.postModelList;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.brand_post.Activity.Create_post.Edit_post;
import com.example.brand_post.Activity.Create_post.Editing_post;
import com.example.brand_post.Activity.Payment.Package;
import com.example.brand_post.Adapter.Fram_Adapter;
import com.example.brand_post.Adapter.List_Post_Adapter;
import com.example.brand_post.R;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.Model.PostModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

public class Select_Fram extends AppCompatActivity {

    private RecyclerView s_rv_post;
    public List<PostModel> s_filter_post_List1 = new ArrayList<PostModel>();
    private LinearLayout gujarat;
    private LinearLayout english, hindi;
    private TextView gujarat_txt, hindi_txt, english_txt;
    public static ImageView s_img;
    private ImageView s_back_btn;
    private CardView s_image_card;
    public static Bitmap bitmap_image;
    int[] layout_fram = {R.layout.frame2, R.layout.frame3};
    private RecyclerView rv_view_frame;
    private ScrollingPagerIndicator indicator;
    ImageView s_save_btn, edit_setting_image;
    private BottomSheetDialog bottomSheetDialog;
    private Constant constant;
    private FrameLayout fram_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_fram);
        constant = new Constant();
        rv_view_frame = findViewById(R.id.s_rv_view_frame);
        indicator = findViewById(R.id.s_indicator);
        s_save_btn = findViewById(R.id.s_fram_save_btn);
        fram_view = findViewById(R.id.fram_view);

        Fram_Adapter fram_adapter = new Fram_Adapter(Select_Fram.this, layout_fram);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rv_view_frame.setLayoutManager(layoutManager);
        rv_view_frame.setAdapter(fram_adapter);
        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        linearSnapHelper.attachToRecyclerView(rv_view_frame);
        indicator.attachToRecyclerView(rv_view_frame);


        s_save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_downlod_Dialoge();
                bottomSheetDialog.show();
            }
        });

        s_back_btn = findViewById(R.id.s_back_btn);
        s_image_card = findViewById(R.id.s_image_card);


        s_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        String n = getIntent().getStringExtra("value_position");
        String link = getIntent().getStringExtra("post");
        //ID ====
        s_img = findViewById(R.id.s_img);
        Glide.with(Select_Fram.this)
                .load(link)
                .centerCrop()
                .into(s_img);

        s_rv_post = findViewById(R.id.s_rv_post);
        gujarat = findViewById(R.id.s_gujarat);
        gujarat_txt = findViewById(R.id.s_gujarat_txt);
        hindi_txt = findViewById(R.id.s_hindi_txt);
        english_txt = findViewById(R.id.s_english_txt);
        english = findViewById(R.id.s_english);
        hindi = findViewById(R.id.s_hindi);

        gujarat.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                gujarat.setBackground(getDrawable(R.drawable.shape_bg));
                gujarat_txt.setTextColor(getColor(R.color.white));
                hindi.setBackground(getDrawable(R.drawable.tab_bg));
                english.setBackground(getDrawable(R.drawable.tab_bg));
                hindi_txt.setTextColor(getColor(R.color.primary4));
                english_txt.setTextColor(getColor(R.color.primary4));
                s_filter_post_List1 = Guj_Filter_Cate(n, "0");
                Recycler_post(s_filter_post_List1);
            }
        });


        hindi.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                hindi.setBackground(getDrawable(R.drawable.shape_bg));
                hindi_txt.setTextColor(getColor(R.color.white));
                gujarat.setBackground(getDrawable(R.drawable.tab_bg));
                english.setBackground(getDrawable(R.drawable.tab_bg));
                gujarat_txt.setTextColor(getColor(R.color.primary4));
                english_txt.setTextColor(getColor(R.color.primary4));
                s_filter_post_List1 = Guj_Filter_Cate(n, "1");
                Recycler_post(s_filter_post_List1);
            }
        });
        english.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                english.setBackground(getDrawable(R.drawable.shape_bg));
                english_txt.setTextColor(getColor(R.color.white));
                gujarat.setBackground(getDrawable(R.drawable.tab_bg));
                hindi.setBackground(getDrawable(R.drawable.tab_bg));
                gujarat_txt.setTextColor(getColor(R.color.primary4));
                hindi_txt.setTextColor(getColor(R.color.primary4));
                s_filter_post_List1 = Guj_Filter_Cate(n, "2");
                Recycler_post(s_filter_post_List1);
            }
        });

        s_filter_post_List1 = Guj_Filter_Cate(n, "0");
        Recycler_post(s_filter_post_List1);
    }


    void Recycler_post(List<PostModel> filter_post_List1) {
        List_Post_Adapter list_post_adapter = new List_Post_Adapter(Select_Fram.this, filter_post_List1, 1);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
        s_rv_post.setLayoutManager(layoutManager);
        s_rv_post.setAdapter(list_post_adapter);
    }

    void image_downlod_Dialoge() {
        bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.downlode_dialoge_item);
        LinearLayout subcribe = bottomSheetDialog.findViewById(R.id.subcribe);
        LinearLayout watch_video = bottomSheetDialog.findViewById(R.id.watch_video);
        LinearLayout close_bottom_sheet = bottomSheetDialog.findViewById(R.id.close_bottom_sheet);


        close_bottom_sheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.dismiss();
            }
        });

        // Show Ad
        watch_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ad Code

                Bitmap finalEditedImage = constant.getMainFrameBitmap(fram_view);
                constant.save_Post(Select_Fram.this, finalEditedImage);
            }
        });

        // Show a Package
        subcribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Payment code hear
                startActivity(new Intent(Select_Fram.this, Package.class));
            }
        });

    }

    public List<PostModel> Guj_Filter_Cate(String n, String s) {
        List<PostModel> filter_post_List = new ArrayList<PostModel>();
        for (int i = 0; i < postModelList.size(); i++) {
            Toast.makeText(Select_Fram.this, "" + postModelList.get(i).gets_cate(), Toast.LENGTH_SHORT).show();
            if (postModelList.get(i).gets_cate().equals(n)) {
                if (postModelList.get(i).getlangauge().equals(s)) {


                    String id = postModelList.get(i).getId();
                    String title = postModelList.get(i).getm_cate();
                    String body = postModelList.get(i).gets_cate();
                    String body2 = postModelList.get(i).getimage_name();
                    String body3 = postModelList.get(i).getstatus();
                    String body4 = postModelList.get(i).getf_date();
                    String body5 = postModelList.get(i).getlangauge();

                    PostModel model = new PostModel();
                    model.setf_date(body4);
                    model.setId(id);
                    model.setlangauge(body5);
                    model.setimage_name(body2);
                    model.sets_cate(body);
                    model.setm_cate(title);
                    model.setstatus(body3);

                    filter_post_List.add(model);
                    Log.e("Filter Gujarat", "id      : " + id);
                    Log.e("Filter Gujarat", "title   : " + title);
                    Log.e("Filter Gujarat", "body    : " + body);
                    Log.e("Filter Gujarat", "-------------------------------------------------");
                }
            }
        }
        return filter_post_List;
    }
}