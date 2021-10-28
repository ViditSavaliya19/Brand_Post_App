package com.example.brand_post.Activity;

import static com.example.brand_post.Activity.Post_list.filter_post_List1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.brand_post.Adapter.Color_Adapter;
import com.example.brand_post.Adapter.FontStyleAdapter;
import com.example.brand_post.Adapter.Post_Adapter;
import com.example.brand_post.Util.MTouch.MultiTouchListener;
import com.example.brand_post.R;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.Model.Model_Ragister;
import com.example.brand_post.Util.Stickers.StickerImageView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

import yuku.ambilwarna.AmbilWarnaDialog;

public class Editing_post extends AppCompatActivity {

    private ImageView bg;
    private GridView grid_fontstyle;
    private Typeface typeface;
    public static TextView title_text;
    private String text123;
    private BottomSheetDialog bottomSheetDialog;
    static int a = 20;
    private int DefaultColor;
    private FrameLayout f_size;
    private FrameLayout m_size;
    private FrameLayout f_color;
    private ImageView text_edit;
    private String TAG = "Hello";
    private String id;
    private RecyclerView rv_view;
    private Constant c1;
    private LinearLayout f_setting;
    public static ImageView image;
    private FrameLayout framlayout;
    private ImageView adda_Image, img_logo;
    private String post_image;
    private List<String> list = new ArrayList<String>();

    private Constant constant;
    private Bitmap bmp;
    private List<String> preflist = new ArrayList<String>();
    private TextView mobile;
    private TextView email_txt;
    private ImageView setting_image;
    private LinearLayout settings_linera;
    private ImageView fram_color;
    public static ImageView bottom_design, top_design;
    private StickerImageView stickerImageView;
    private Model_Ragister model=new Model_Ragister();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editing_post);

        post_image = getIntent().getStringExtra("post");
        c1 = new Constant();
        showBottomSheetDialog();

        id = getIntent().getStringExtra("value_position");

        initView();




    }

    @SuppressLint("ClickableViewAccessibility")
    private void initView() {

        bg = findViewById(R.id.bg);
        image = findViewById(R.id.image);
        img_logo = findViewById(R.id.img_logo);
        img_logo.setOnTouchListener(new MultiTouchListener());
        Glide.with(Editing_post.this)
                .load(post_image)
                .centerCrop()
                .into(image);
        title_text = findViewById(R.id.title_text);
        text123 = title_text.getText().toString();
        framlayout = findViewById(R.id.framlayout);
        title_text.setOnTouchListener(new MultiTouchListener());
        text_edit = findViewById(R.id.text_edit);
        adda_Image = findViewById(R.id.adda_Image);
        mobile = findViewById(R.id.mobile);
        top_design = findViewById(R.id.top_design);
        setting_image = findViewById(R.id.setting_image);
        email_txt = findViewById(R.id.email_txt);
        fram_color = findViewById(R.id.fram_color);
        bottom_design = findViewById(R.id.bottom_design);
        stickerImageView = new StickerImageView(Editing_post.this);
        stickerImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                stickerImageView.setControlItemsHidden(false);
                return false;
            }
        });


        model = constant.Read_Pref(this);
        title_text.setText(model.getName());
        email_txt.setText(model.getEmail());
        mobile.setText(model.getMobile());
        fram_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rv_Color();
                settings_linera.setVisibility(View.GONE);
                rv_view.setVisibility(View.VISIBLE);
                f_setting.setVisibility(View.GONE);
                bottomSheetDialog.show();
            }
        });

        setting_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.show();
                settings_linera.setVisibility(View.VISIBLE);
                rv_view.setVisibility(View.GONE);
                f_setting.setVisibility(View.GONE);
            }
        });




        adda_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stickerImageView.setImageResource(R.drawable.ad_congratulations);

                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
                framlayout.addView(stickerImageView, layoutParams);

//                img_logo.setImageBitmap(bmp);
//                addStrickerView(R.draw(intent, 0);
            }
        });
        text_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rv_view.setVisibility(View.GONE);
                f_setting.setVisibility(View.VISIBLE);
                bottomSheetDialog.show();
            }
        });

        framlayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                stickerImageView.setControlItemsHidden(true);
                return false;
            }
        });


        Font();


        bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rv_Post();
                settings_linera.setVisibility(View.GONE);
                rv_view.setVisibility(View.VISIBLE);
                f_setting.setVisibility(View.GONE);
                bottomSheetDialog.show();
            }
        });
    }

    private void showBottomSheetDialog() {

        bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottomsheet);
        rv_view = bottomSheetDialog.findViewById(R.id.rv_view);

        f_setting = bottomSheetDialog.findViewById(R.id.f_setting);
        settings_linera = bottomSheetDialog.findViewById(R.id.settings_linera);
        grid_fontstyle = bottomSheetDialog.findViewById(R.id.grid_fontstyle);
        f_size = bottomSheetDialog.findViewById(R.id.f_size);
        m_size = bottomSheetDialog.findViewById(R.id.m_size);
        f_color = bottomSheetDialog.findViewById(R.id.f_color);
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

//    public  List<PostModel> Filter_Cate(String n)
//    {
//        List<PostModel> filter_post_List = new ArrayList<PostModel>();
//        for (int i = 0; i < postModelList.size(); i++) {
//            Toast.makeText(Editing_post.this, ""+postModelList.get(i).gets_cate(), Toast.LENGTH_SHORT).show();
//
//            if (postModelList.get(i).gets_cate().equals(n)) {
//
//                Toast.makeText(Editing_post.this, "True "+postModelList.get(i).gets_cate(), Toast.LENGTH_SHORT).show();
//
//                String id = postModelList.get(i).getId();
//                String title = postModelList.get(i).getm_cate();
//                String body = postModelList.get(i).gets_cate();
//                String body2 = postModelList.get(i).getimage_name();
//                String body3 = postModelList.get(i).getstatus();
//                String body4 = postModelList.get(i).getf_date();
//                String body5 = postModelList.get(i).getlangauge();
//
//                PostModel model = new PostModel();
//                model.setf_date(body4);
//                model.setId(id);
//                model.setlangauge(body5);
//                model.setimage_name(body2);
//                model.sets_cate(body);
//                model.setm_cate(title);
//                model.setstatus(body3);
//
//                filter_post_List.add(model);
////                Log.e("Filter ", "id      : " + id);
////                Log.e("Filter ", "title   : " + title);
//                Log.e("Filter" , "body    : " + body);
//                Log.e("Filter ", "-------------------------------------------------");
//            }
//        }
//        return filter_post_List;
//    }

    private void Rv_Post() {
        Post_Adapter adapter = new Post_Adapter(Editing_post.this, filter_post_List1, id);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(Editing_post.this, 3);
        rv_view.setLayoutManager(layoutManager);
        rv_view.setAdapter(adapter);
    }

    private void Rv_Color() {
        Color_Adapter adapter = new Color_Adapter(Editing_post.this, getResources().getIntArray(R.array.rainbow));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Editing_post.this, LinearLayoutManager.HORIZONTAL, false);
        rv_view.setLayoutManager(layoutManager);
        rv_view.setAdapter(adapter);
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

//    public void addStrickerView(int sticker) {
//        final StickerView stickerView = new StickerView(this);
//        stickerView.setImageResource(sticker);
//        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
//        framlayout.addView(stickerView, layoutParams);
//        setCurrentEdit(stickerView);
//        stickerView.setOperationListener(new StickerView.OperationListener() {
//            @Override
//            public void onDeleteClick() {
//                framlayout.removeView(stickerView);
//            }
//
//            @Override
//            public void onEdit(StickerView stickerView) {
//                mCurrentView.setInEdit(false);
//                mCurrentView = stickerView;
//                mCurrentView.setInEdit(true);
//            }
//
//            @Override
//            public void onTop(StickerView stickerView) {
//            }
//        });
//    }

//    private void setCurrentEdit(StickerView stickerView) {
//        if (mCurrentView != null) {
//            mCurrentView.setInEdit(false);
//        }
//        mCurrentView = stickerView;
//        stickerView.setInEdit(true);
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Uri targetUri = data.getData();


//            Bitmap bitmap;
//            try {
//                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
//
//            } catch (FileNotFoundException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
        }
    }

}