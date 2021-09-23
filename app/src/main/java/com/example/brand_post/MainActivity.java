package com.example.brand_post;


import static com.example.brand_post.Activity.SpleshActivity.postModelList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.brand_post.Activity.Editing_post;
import com.example.brand_post.Adapter.Rv_Adapter;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.PostModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler_trending;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_trending=findViewById(R.id.recycler_trending);
        Recycler_view();
    }

    void Recycler_view()
    {

        Rv_Adapter adapter=new Rv_Adapter(MainActivity.this,postModelList);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false);
        recycler_trending.setLayoutManager(layoutManager);
        recycler_trending.setAdapter(adapter);
    }

}