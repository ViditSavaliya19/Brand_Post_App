package com.example.brand_post.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.brand_post.R;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.Model.Model_Ragister;

public class Register_Activity extends AppCompatActivity {

    private LinearLayout Register_btn;
    EditText r_Name_edt, r_Email_edt, r_Password_edt, r_Business_edt, r_Mobile_edt;

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


        Constant constant = new Constant();

        Register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Model_Ragister model_ragister = new Model_Ragister(r_Name_edt.getText().toString().trim(), r_Email_edt.getText().toString().trim(), r_Password_edt.getText().toString(), r_Business_edt.getText().toString().trim(), "test.jpg", r_Mobile_edt.getText().toString().trim(), "0");
                constant.Registration(model_ragister);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        constant.Pref(Register_Activity.this,model_ragister);
                        Toast.makeText(Register_Activity.this, "Register Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }, 1000);
            }
        });
    }


}