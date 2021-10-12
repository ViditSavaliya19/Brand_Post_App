package com.example.brand_post.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.collection.CircularArray;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.brand_post.R;
import com.example.brand_post.Util.Constant;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Business_edit extends AppCompatActivity {

    private EditText number_edt, name_edt, business_edt;
    private CardView btn_save;
    private CircleImageView card_image;
    Bitmap bitmap;
    private List<String> list=new ArrayList<>();
    Constant constant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_edit);

        number_edt = findViewById(R.id.number_edt);
        name_edt = findViewById(R.id.name_btn);
        business_edt = findViewById(R.id.business_btn);
        card_image = findViewById(R.id.card_image);
        btn_save = findViewById(R.id.btn_save);
        constant = new Constant();

        if (!(list = constant.Read_Pref(Business_edit.this)).isEmpty()) {

            if (list.get(3) != null) {
                String[] split = list.get(3).substring(1, list.get(3).length() - 1).split(", ");
                byte[] array = new byte[split.length];
                for (int i = 0; i < split.length; i++) {
                    array[i] = Byte.parseByte(split[i]);
                }
                String imgString = Base64.encodeToString(array, Base64.NO_WRAP);
                Bitmap bmp = BitmapFactory.decodeByteArray(array, 0, array.length);

                card_image.setImageBitmap(bmp);
                name_edt.setText(list.get(0));
                business_edt.setText(list.get(1));
                number_edt.setText(list.get(2));
            }
        }

        card_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }
        });

        constant = new Constant();

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte[] image = getBytesFromBitmap(bitmap);
                constant.Pref(Business_edit.this, name_edt.getText().toString(), business_edt.getText().toString(), number_edt.getText().toString(), image);
                Toast.makeText(Business_edit.this, "Success Update", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Uri targetUri = data.getData();
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public byte[] getBytesFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        return stream.toByteArray();
    }

    // get the base 64 string

}