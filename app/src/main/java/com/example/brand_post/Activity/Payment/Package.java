package com.example.brand_post.Activity.Payment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.example.brand_post.Adapter.Packages_Adapter;
import com.example.brand_post.R;

public class Package extends AppCompatActivity {

    private RecyclerView rv_packages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package);

        rv_packages=findViewById(R.id.rv_packages);
        Packages_Adapter adapter=new Packages_Adapter(Package.this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rv_packages.setLayoutManager(layoutManager);
        rv_packages.setAdapter(adapter);
        SnapHelper helper = new PagerSnapHelper();
        helper.attachToRecyclerView(rv_packages);




    }
}