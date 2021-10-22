package com.example.brand_post.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.brand_post.Fragments.Business_Fragment;
import com.example.brand_post.Fragments.Custom_Fragment;
import com.example.brand_post.Fragments.Dashbord_Fragment;
import com.example.brand_post.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private Fragment firstFragment;
    private Fragment secondFragment;
    private Fragment thirdFragment;
    private FrameLayout flFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        flFragment=findViewById(R.id.flFragment);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        firstFragment = new Dashbord_Fragment();
         loadFragment(firstFragment);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.person:
                loadFragment(firstFragment);
                return true;

            case R.id.home:
                secondFragment = new Custom_Fragment();
                loadFragment(secondFragment);
                return true;

            case R.id.settings:
                thirdFragment = new Business_Fragment();
                loadFragment(thirdFragment);
                return true;
        }
        return false;
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flFragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }



}