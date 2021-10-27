package com.example.brand_post.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.brand_post.R;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.Model.Model_Ragister;

import java.io.File;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.http.Url;

public class Register_Activity extends AppCompatActivity {

    private LinearLayout Register_btn;
    EditText r_Name_edt, r_Email_edt, r_Password_edt, r_Business_edt, r_Mobile_edt;
    private CircleImageView r_select_Image_circle;
    private File uri;
    private String part_image;
    private Uri link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Register_btn = findViewById(R.id.Register_btn);
        r_Name_edt = findViewById(R.id.r_Name_edt);
        r_Email_edt = findViewById(R.id.r_Email_edt);
        r_Password_edt = findViewById(R.id.r_Password_edt);
        r_Business_edt = findViewById(R.id.r_Business_edt);
        r_Mobile_edt = findViewById(R.id.r_Mobile_edt);
        r_select_Image_circle = findViewById(R.id.r_select_Image_circle);
        r_select_Image_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Open Gallery"), 0);

            }
        });

        Constant constant = new Constant();

        Register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bitmap bitmap = ((BitmapDrawable) r_select_Image_circle.getDrawable()).getBitmap();

                Model_Ragister model_ragister = new Model_Ragister(r_Name_edt.getText().toString().trim(), r_Email_edt.getText().toString().trim(), r_Password_edt.getText().toString(), r_Business_edt.getText().toString().trim(), "test.jpg", r_Mobile_edt.getText().toString().trim(), "0");
                constant.Registration(model_ragister,link.toString(),bitmap);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        constant.Pref(Register_Activity.this, model_ragister);
                        Toast.makeText(Register_Activity.this, "Register Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }, 1000);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {

            r_select_Image_circle.setImageURI(data.getData());

            link =data.getData();
            uri = new File(data.getData().getPath());
            Log.e("TAG", "onActivityResult: "+link + ""+uri);
                                             // Get the image file URI

        }

    }
}