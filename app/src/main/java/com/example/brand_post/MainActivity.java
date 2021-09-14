package com.example.brand_post;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.brand_post.Activity.Editing_post;

public class MainActivity extends AppCompatActivity {

    private CardView festival_post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intiView();


    }

    private void intiView() {

        festival_post=findViewById(R.id.festival_post);
        festival_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Editing_post.class));
            }
        });
    }
}