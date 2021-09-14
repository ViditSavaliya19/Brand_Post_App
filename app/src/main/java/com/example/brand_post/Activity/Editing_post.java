package com.example.brand_post.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.brand_post.Adapter.FontStyleAdapter;
import com.example.brand_post.MTouch.MultiTouchListener;
import com.example.brand_post.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import yuku.ambilwarna.AmbilWarnaDialog;

public class Editing_post extends AppCompatActivity {

    private ImageView bg;
    private GridView grid_fontstyle;
    private Typeface typeface;
    private TextView title_text;
    private String text123;
    private BottomSheetDialog bottomSheetDialog;
    static int a=20;
    private int DefaultColor;
    private FrameLayout f_size;
    private FrameLayout m_size;
    private FrameLayout f_color;
    private ImageView text_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editing_post);
        showBottomSheetDialog();
        initView();

    }

    private void initView() {
        bg=findViewById(R.id.bg);
        title_text=findViewById(R.id.title_text);
        text123 = title_text.getText().toString();
        title_text.setOnTouchListener(new MultiTouchListener());
        text_edit=findViewById(R.id.text_edit);
        text_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.show();
            }
        });


        Font();


        bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.show();
            }
        });
    }

    private void showBottomSheetDialog() {

        bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottomsheet);
        grid_fontstyle=bottomSheetDialog.findViewById(R.id.grid_fontstyle);
        f_size = bottomSheetDialog.findViewById(R.id.f_size);
        m_size = bottomSheetDialog.findViewById(R.id.m_size);
        f_color=bottomSheetDialog.findViewById(R.id.f_color);

        f_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color(false);
            }
        });


        f_size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a++;
                title_text.setTextSize(a);
            }
        });

        m_size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a--;
                title_text.setTextSize(a);
            }
        });


    }

    public void color(boolean AlphaSupport) {
        AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(Editing_post.this, DefaultColor, AlphaSupport, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onOk(AmbilWarnaDialog ambilWarnaDialog, int color) {

                DefaultColor = color;

                title_text.setTextColor(color);
            }

            @Override
            public void onCancel(AmbilWarnaDialog ambilWarnaDialog) {

            }
        });
        ambilWarnaDialog.show();
    }

    public void Font() {
        FontStyleAdapter adapter = new FontStyleAdapter(Editing_post.this);
        grid_fontstyle.setAdapter(adapter);
        grid_fontstyle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                title_text.setTypeface(typeface);
            }
        });
    }

    public void TextStyle(int postion) {
        if (text123 != null) {

            switch (postion) {

                case 0:
                    typeface = Typeface.createFromAsset(getAssets(), "font/font1.ttf");
                    title_text.setTypeface(typeface);
                    break;

                case 1:
                    typeface = Typeface.createFromAsset(getAssets(), "font/font2.ttf");
                    title_text.setTypeface(typeface);
                    break;

                case 2:
                    typeface = Typeface.createFromAsset(getAssets(), "font/font3.ttf");
                    title_text.setTypeface(typeface);
                    break;

                case 3:
                    typeface = Typeface.createFromAsset(getAssets(), "font/font4.TTF");
                    title_text.setTypeface(typeface);
                    break;

                case 4:
                    typeface = Typeface.createFromAsset(getAssets(), "font/font5.ttf");
                    title_text.setTypeface(typeface);
                    break;

                case 5:
                    typeface = Typeface.createFromAsset(getAssets(), "font/font6.TTF");
                    title_text.setTypeface(typeface);
                    break;

                case 6:
                    typeface = Typeface.createFromAsset(getAssets(), "font/font7.ttf");
                    title_text.setTypeface(typeface);
                    break;

                case 7:
                    typeface = Typeface.createFromAsset(getAssets(), "font/font8.ttf");
                    title_text.setTypeface(typeface);
                    break;

                case 8:
                    typeface = Typeface.createFromAsset(getAssets(), "font/font9.ttf");
                    title_text.setTypeface(typeface);
                    break;

                case 9:
                    typeface = Typeface.createFromAsset(getAssets(), "font/font10.TTF");
                    title_text.setTypeface(typeface);
                    break;

                case 10:
                    typeface = Typeface.createFromAsset(getAssets(), "font/font11.ttf");
                    title_text.setTypeface(typeface);
                    break;

                case 11:
                    typeface = Typeface.createFromAsset(getAssets(), "font/font12.ttf");
                    title_text.setTypeface(typeface);
                    break;

                case 12:
                    typeface = Typeface.createFromAsset(getAssets(), "font/font14.TTF");
                    title_text.setTypeface(typeface);
                    break;

                case 13:
                    typeface = Typeface.createFromAsset(getAssets(), "font/font16.TTF");
                    title_text.setTypeface(typeface);
                    break;

                case 14:
                    typeface = Typeface.createFromAsset(getAssets(), "font/font17.ttf");
                    title_text.setTypeface(typeface);
                    break;

                case 15:
                    typeface = Typeface.createFromAsset(getAssets(), "font/font18.ttf");
                    title_text.setTypeface(typeface);
                    break;

                case 16:
                    typeface = Typeface.createFromAsset(getAssets(), "font/font19.ttf");
                    title_text.setTypeface(typeface);
                    break;

                case 17:
                    typeface = Typeface.createFromAsset(getAssets(), "font/font20.ttf");
                    title_text.setTypeface(typeface);
                    break;

                case 18:
                    typeface = Typeface.createFromAsset(getAssets(), "font/font21.ttf");
                    title_text.setTypeface(typeface);
                    break;

            }
        }

    }


}