package com.example.brand_post;


import static com.example.brand_post.Activity.SpleshActivity.postModelList;
import static com.example.brand_post.Activity.SpleshActivity.sub_modelList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.brand_post.Adapter.Rv_Adapter;

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
        Rv_Adapter adapter=new Rv_Adapter(MainActivity.this,sub_modelList);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false);
        recycler_trending.setLayoutManager(layoutManager);
        recycler_trending.setAdapter(adapter);
    }

}