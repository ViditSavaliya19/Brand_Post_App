package com.example.brand_post.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.brand_post.Fragments.Dashbord_Fragment;
import com.example.brand_post.Fragments.Settings_Fragment;
import com.example.brand_post.Fragments.f_Save;
import com.example.brand_post.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;


public class Home extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Fragment firstFragment;

    private ChipNavigationBar menu_bottomo;
    private FrameLayout flFragment;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        menu_bottomo=findViewById(R.id.menu_bottomo);
        menu_bottomo.setDrawingCacheBackgroundColor(R.color.primary2);
        flFragment = findViewById(R.id.flFragment);
        firstFragment = new Dashbord_Fragment();
        loadFragment(firstFragment);


        menu_bottomo.setItemSelected(R.id.home_dash);

        menu_bottomo.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                switch (i)
                {
                    case R.id.home_dash:
                        loadFragment(firstFragment);
                        break;
                    case R.id.edit_post:
                        startActivity(new Intent(Home.this,Editing_post.class));
                        break;
                    case R.id.save_post:
                        loadFragment(new f_Save());
                        break;
                        
                    case R.id.settings:
                        loadFragment(new Settings_Fragment());
                        break;

                }
            }
        });


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