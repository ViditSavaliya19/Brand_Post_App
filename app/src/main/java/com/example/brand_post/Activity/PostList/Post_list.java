package com.example.brand_post.Activity.PostList;

import static com.example.brand_post.Activity.Main.SpleshActivity.postModelList;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brand_post.Adapter.List_Post_Adapter;
import com.example.brand_post.R;
import com.example.brand_post.Util.Model.PostModel;

import java.util.ArrayList;
import java.util.List;

public class Post_list extends AppCompatActivity {

    private RecyclerView rv_post;
    public static List<PostModel> filter_post_List1 = new ArrayList<PostModel>();
    private LinearLayout gujarat;
    private LinearLayout english, hindi;
    private TextView gujarat_txt, hindi_txt, english_txt;
    private String n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);
        n = getIntent().getStringExtra("value_position");
        gujarat = findViewById(R.id.gujarat);
        gujarat_txt = findViewById(R.id.gujarat_txt);
        hindi_txt = findViewById(R.id.hindi_txt);
        english_txt = findViewById(R.id.english_txt);
        english = findViewById(R.id.english);
        hindi = findViewById(R.id.hindi);


        rv_post = findViewById(R.id.rv_post);

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
                filter_post_List1 = Guj_Filter_Cate(n, "0");
                Recycler_post(filter_post_List1);
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
                filter_post_List1 = Guj_Filter_Cate(n, "1");
                Recycler_post(filter_post_List1);
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
                filter_post_List1 = Guj_Filter_Cate(n, "2");
                Recycler_post(filter_post_List1);
            }
        });
        filter_post_List1 = Guj_Filter_Cate(n, "0");
        Recycler_post(filter_post_List1);

    }


    void Recycler_post(List<PostModel> filter_post_List1) {
        List_Post_Adapter list_post_adapter = new List_Post_Adapter(Post_list.this, filter_post_List1,n);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
        rv_post.setLayoutManager(layoutManager);
        rv_post.setAdapter(list_post_adapter);
    }


    public List<PostModel> Guj_Filter_Cate(String n, String s) {
        List<PostModel> filter_post_List = new ArrayList<PostModel>();
        for (int i = 0; i < postModelList.size(); i++) {
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