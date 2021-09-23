package com.example.brand_post;

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

public class MainActivity extends AppCompatActivity {

    private CardView festival_post;
    private RecyclerView recycler_trending;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intiView();


    }

    private void intiView() {

        recycler_trending=findViewById(R.id.recycler_trending);

        Recycler_view();

    }


    void Recycler_view()
    {
        Rv_Adapter adapter=new Rv_Adapter(MainActivity.this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false);
        recycler_trending.setLayoutManager(layoutManager);
        recycler_trending.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Constant constant=new Constant();
        constant.GetData();
    }
}