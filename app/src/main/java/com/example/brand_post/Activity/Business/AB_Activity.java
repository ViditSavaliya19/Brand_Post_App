package com.example.brand_post.Activity.Business;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.brand_post.Activity.Main.SpleshActivity;
import com.example.brand_post.Adapter.Selecct_business_Adapter;
import com.example.brand_post.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AB_Activity extends AppCompatActivity {
    FloatingActionButton ad_new_business;
    private RecyclerView rv_view_business_ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ab);

        //ID BINDING
        rv_view_business_ab=findViewById(R.id.rv_view_business_ab);
        ad_new_business = findViewById(R.id.ad_new_business);


        Selecct_business_Adapter selecct_business_adapter = new Selecct_business_Adapter(AB_Activity.this, SpleshActivity.businessData_list_s);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(AB_Activity.this);
        rv_view_business_ab.setLayoutManager(layoutManager);
        rv_view_business_ab.setAdapter(selecct_business_adapter);



        ad_new_business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AB_Activity.this,New_Add_Business_Activity.class));
            }
        });
    }
}