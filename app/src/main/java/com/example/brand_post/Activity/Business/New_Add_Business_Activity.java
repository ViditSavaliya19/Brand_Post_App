package com.example.brand_post.Activity.Business;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brand_post.R;

public class New_Add_Business_Activity extends AppCompatActivity {
    ImageView n_image;
    TextView n_Name_edt, n_Email_edt, n_Web_edt, n_Mobile_edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_add_business);

        n_image = findViewById(R.id.n_image);
        n_Name_edt = findViewById(R.id.n_Name_edt);
        n_Email_edt = findViewById(R.id.n_Email_edt);
        n_Web_edt = findViewById(R.id.n_Web_edt);
        n_Mobile_edt = findViewById(R.id.n_Mobile_edt);




    }
}