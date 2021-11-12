package com.example.brand_post.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.brand_post.Fragments.Business_Fragment;
import com.example.brand_post.Fragments.Custom_Fragment;
import com.example.brand_post.Fragments.Dashbord_Fragment;
import com.example.brand_post.Fragments.f_Save;
import com.example.brand_post.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Fragment firstFragment;
    private Fragment secondFragment;
    private Fragment thirdFragment;
    private FrameLayout flFragment;
    private ImageView bn_home_img, bn_create_img, bn_save_img, bn_premium_img, bn_settings_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        flFragment = findViewById(R.id.flFragment);
//        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bn_home_img = findViewById(R.id.bn_home_img);
        bn_create_img = findViewById(R.id.bn_create_img);
        bn_save_img = findViewById(R.id.bn_save_img);
        bn_premium_img = findViewById(R.id.bn_premium_img);
        bn_settings_img = findViewById(R.id.bn_settings_img);


        bn_home_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bn_home_img.setImageResource(R.drawable.tab_home_icon);
                bn_create_img.setImageResource(R.drawable.t_edit_icon);
                bn_save_img.setImageResource(R.drawable.t_downlode_icon);
                bn_premium_img.setImageResource(R.drawable.t_premium);
                bn_settings_img.setImageResource(R.drawable.t_setting_icon);

                loadFragment(firstFragment);
            }
        });

        bn_create_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bn_create_img.setImageResource(R.drawable.tab_create_icon);
                bn_home_img.setImageResource(R.drawable.t_home_icon);
                bn_save_img.setImageResource(R.drawable.t_downlode_icon);
                bn_premium_img.setImageResource(R.drawable.t_premium);
                bn_settings_img.setImageResource(R.drawable.t_setting_icon);
                startActivity(new Intent(Home.this, Editing_post.class));
            }
        });

        bn_save_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bn_save_img.setImageResource(R.drawable.tab_downlod_icon);
                bn_home_img.setImageResource(R.drawable.t_home_icon);
                bn_create_img.setImageResource(R.drawable.t_edit_icon);
                bn_premium_img.setImageResource(R.drawable.t_premium);
                bn_settings_img.setImageResource(R.drawable.t_setting_icon);

                f_Save f_save = new f_Save();
                loadFragment(f_save);

            }
        });

        bn_premium_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bn_premium_img.setImageResource(R.drawable.tab_premiun_icon);
                bn_home_img.setImageResource(R.drawable.t_home_icon);
                bn_create_img.setImageResource(R.drawable.t_edit_icon);
                bn_save_img.setImageResource(R.drawable.t_downlode_icon);
                bn_settings_img.setImageResource(R.drawable.t_setting_icon);
            }
        });


        bn_settings_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bn_settings_img.setImageResource(R.drawable.tab_setting_icon);
                bn_home_img.setImageResource(R.drawable.t_setting_icon);
                bn_create_img.setImageResource(R.drawable.t_edit_icon);
                bn_save_img.setImageResource(R.drawable.t_downlode_icon);
                bn_premium_img.setImageResource(R.drawable.t_premium);
                thirdFragment = new Business_Fragment();
                loadFragment(thirdFragment);
            }
        });
        bn_home_img.setImageResource(R.drawable.tab_home_icon);
        firstFragment = new Dashbord_Fragment();
        loadFragment(firstFragment);
    }


    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flFragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.bn_home_img:
//                bn_home_img.setImageResource(R.drawable.tab_home_icon);
//                bn_create_img.setImageResource(R.drawable.t_edit_icon);
//                bn_save_img.setImageResource(R.drawable.t_downlode_icon);
//                bn_premium_img.setImageResource(R.drawable.t_premium);
//                bn_settings_img.setImageResource(R.drawable.t_setting_icon);
//
//                loadFragment(firstFragment);
//
//            case R.id.bn_create_img:
//                bn_create_img.setImageResource(R.drawable.tab_create_icon);
//
//                bn_home_img.setImageResource(R.drawable.t_home_icon);
//                bn_save_img.setImageResource(R.drawable.t_downlode_icon);
//                bn_premium_img.setImageResource(R.drawable.t_premium);
//                bn_settings_img.setImageResource(R.drawable.t_setting_icon);
//
//                startActivity(new Intent(Home.this, Editing_post.class));
//
//            case R.id.bn_save_img:
//                bn_save_img.setImageResource(R.drawable.tab_downlod_icon);
//                bn_home_img.setImageResource(R.drawable.t_home_icon);
//                bn_create_img.setImageResource(R.drawable.t_edit_icon);
//                bn_premium_img.setImageResource(R.drawable.t_premium);
//                bn_settings_img.setImageResource(R.drawable.t_setting_icon);
//
//                f_Save f_save = new f_Save();
//                loadFragment(f_save);
//
//            case R.id.bn_premium_img:
//                bn_premium_img.setImageResource(R.drawable.tab_premiun_icon);
//                bn_home_img.setImageResource(R.drawable.t_home_icon);
//                bn_create_img.setImageResource(R.drawable.t_edit_icon);
//                bn_save_img.setImageResource(R.drawable.t_downlode_icon);
//                bn_settings_img.setImageResource(R.drawable.t_setting_icon);
//
//
//            case R.id.settings:
//                bn_settings_img.setImageResource(R.drawable.tab_setting_icon);
//                bn_home_img.setImageResource(R.drawable.t_setting_icon);
//                bn_create_img.setImageResource(R.drawable.t_edit_icon);
//                bn_save_img.setImageResource(R.drawable.t_downlode_icon);
//                bn_premium_img.setImageResource(R.drawable.t_premium);
//                thirdFragment = new Business_Fragment();
//                loadFragment(thirdFragment);
//        }
//    }
}