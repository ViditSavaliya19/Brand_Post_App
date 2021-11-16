package com.example.brand_post.Activity.Business;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.brand_post.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AB_Activity extends AppCompatActivity {
    FloatingActionButton ad_new_business;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ab);

        //ID BINDING

        ad_new_business = findViewById(R.id.ad_new_business);
        ad_new_business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AB_Activity.this,New_Add_Business_Activity.class));
            }
        });
    }
}