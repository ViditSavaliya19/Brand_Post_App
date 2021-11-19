package com.example.brand_post.Activity;

import static com.example.brand_post.Activity.Post_list.filter_post_List1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brand_post.Adapter.Color_Adapter;
import com.example.brand_post.Adapter.FontStyleAdapter;
import com.example.brand_post.Adapter.Fram_Adapter;
import com.example.brand_post.Adapter.Post_Adapter;
import com.example.brand_post.Util.MTouch.MultiTouchListener;
import com.example.brand_post.R;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.Model.Model_Ragister;

import com.example.brand_post.Util.Stickers.StickerImageView;
import com.example.brand_post.Util.Stickers.StickerTextView;
import com.example.brand_post.Util.Stickers.StickerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;


import java.util.ArrayList;
import java.util.List;

import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;
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
    private FrameLayout framlayout, sticker_fram;
    private ImageView adda_Image, img_logo;
    private String post_image;
    private List<String> list = new ArrayList<String>();

    private Constant constant;
    private Bitmap bmp;
    private List<String> preflist = new ArrayList<String>();
    private TextView mobile;
    private TextView email_txt;
    private ImageView setting_image, add_logo;
    private LinearLayout settings_linera, sticker_bg;
    private ImageView fram_color;
    public static ImageView bottom_design;
    //    private StickerImageView stickerImageView;
    private Model_Ragister model1 = new Model_Ragister();
    private ImageView e_save_btn;
    private String ts;
    private RecyclerView e_rv_view_frame;
    int[] layout_fram = {R.layout.frame2, R.layout.frame3};
    private ScrollingPagerIndicator indicator1;
    private FrameLayout inner_sticker_frame;
    private Dialog dialog;
    private EditText add_text_edt;

    private TextView f_web;
    public static CheckBox mobile_txt_chk, email_txt_chk, business_txt_chk;
    CardView e_edit_text_sticker_card;
    private ImageView align_left;
    private StickerTextView iv_sticker1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editing_post);

//        post_image = getIntent().getStringExtra("post");
         iv_sticker1 = new StickerTextView(Editing_post.this);

        c1 = new Constant();
        showBottomSheetDialog();

        id = getIntent().getStringExtra("value_position");

        initView();


    }

    @SuppressLint("ClickableViewAccessibility")
    private void initView() {

        bg = findViewById(R.id.bg);
        image = findViewById(R.id.image1);
        img_logo = findViewById(R.id.img_logo);
        img_logo.setOnTouchListener(new MultiTouchListener());

        title_text = findViewById(R.id.title_text);
        text123 = title_text.getText().toString();
        framlayout = findViewById(R.id.framlayout);
        title_text.setOnTouchListener(new MultiTouchListener());
        text_edit = findViewById(R.id.text_edit);
//        adda_Image = findViewById(R.id.adda_Image);
        add_logo = findViewById(R.id.add_logo);
        mobile = findViewById(R.id.f2_mobile);
        f_web = findViewById(R.id.f_web);


        setting_image = findViewById(R.id.setting_image);
        email_txt = findViewById(R.id.f_email);
        fram_color = findViewById(R.id.fram_color);
        bottom_design = findViewById(R.id.bottom_design);
        e_save_btn = findViewById(R.id.e_save_btn);
        e_rv_view_frame = findViewById(R.id.e_rv_view_frame);
        indicator1 = findViewById(R.id.indicator1);

        //CONROLES ID;
        e_edit_text_sticker_card = findViewById(R.id.e_edit_text_sticker_card);
        align_left=findViewById(R.id.align_left);

        align_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_sticker1.setAlignment(Gravity.LEFT);

            }
        });
        iv_sticker1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                iv_sticker1.setControlItemsHidden(false);
                return false;
            }
        });


        Fram_Adapter fram_adapter = new Fram_Adapter(Editing_post.this, layout_fram);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        e_rv_view_frame.setLayoutManager(layoutManager);
        e_rv_view_frame.setAdapter(fram_adapter);
        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        linearSnapHelper.attachToRecyclerView(e_rv_view_frame);
        indicator1.attachToRecyclerView(e_rv_view_frame);




//        inner_sticker_frame=findViewById(R.id.inner_sticker_frame);
        title_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addTextDailog(0);
                add_text_edt.setText(title_text.getText());
            }
        });

//        StickerImageView iv_sticker = new StickerImageView(Editing_post.this);
//        iv_sticker.setImageResource(R.drawable.add_logo_icon);
//        framlayout.addView(iv_sticker);


        e_save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Editing_post.this, "Clicked", Toast.LENGTH_SHORT).show();
                Bitmap finalEditedImage = constant.getMainFrameBitmap(framlayout);
                constant.save_Post(Editing_post.this, finalEditedImage);
            }
        });




        constant = new Constant();
        model1 = constant.Read_Pref(Editing_post.this);
//        title_text.setText(model1.getName());
//        email_txt.setText(model1.getEmail());
//        mobile.setText(model1.getMobile());


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


// STICKER VIEW ADDED CODE =====================================================================


        framlayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (iv_sticker1 != null)
                    iv_sticker1.setControlItemsHidden(false);
                return false;
            }
        });

//        adda_Image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                stickerImageView.setImageResource(R.drawable.ad_congratulations);
//
//                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
//                framlayout.addView(stickerImageView, layoutParams);
//
////                img_logo.setImageBitmap(bmp);
////                addStrickerView(R.draw(intent, 0);
//            }
//        });
        text_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                rv_view.setVisibility(View.GONE);
//                f_setting.setVisibility(View.VISIBLE);
//                bottomSheetDialog.show();
                addTextDailog(0);
            }
        });

        e_edit_text_sticker_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTextDailog(1);
            }
        });

        framlayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                iv_sticker1.setControlItemsHidden(true);
                return false;
            }
        });


        Font();


        bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto, 1);
//                Rv_Post();
//                settings_linera.setVisibility(View.GONE);
//                rv_view.setVisibility(View.VISIBLE);
//                f_setting.setVisibility(View.GONE);
//                bottomSheetDialog.show();
            }
        });


        // ADD LOGO ===========
        add_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto, 2);
            }
        });
    }


    void addSticker(String s1) {
        iv_sticker1.setText(s1);

        iv_sticker1.setTextColor(Color.RED);
        iv_sticker1.setAlignment(Gravity.CENTER);
        framlayout.addView(iv_sticker1);

        setCurrentEdit(iv_sticker1);


//        iv_sticker1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    private void setCurrentEdit(StickerTextView stickerView) {
        if (iv_sticker1 != null) {
            iv_sticker1.setControlItemsHidden(false);
        }
//        iv_sticker1 = stickerView;
        stickerView.setControlItemsHidden(true);
    }


    void addTextDailog(int opreation) {

        dialog = new Dialog(Editing_post.this);
        dialog.setContentView(R.layout.add_text_item);
        add_text_edt = dialog.findViewById(R.id.add_text_edt);
        Button add_text_btn = dialog.findViewById(R.id.add_text_btn);

        add_text_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(opreation ==0 )
                {
                    addSticker(add_text_edt.getText().toString());
                }
                else if(opreation==1)
                {
                    iv_sticker1.setText(add_text_edt.getText().toString());
                }
//                title_text.setText(add_text_edt.getText().toString());
                dialog.dismiss();
            }
        });

        dialog.show();
    }


    private void showBottomSheetDialog() {

        bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottomsheet);
        rv_view = bottomSheetDialog.findViewById(R.id.rv_view);

        f_setting = bottomSheetDialog.findViewById(R.id.f_setting);


        //SETTINGS TOOLS =================================
        settings_linera = bottomSheetDialog.findViewById(R.id.settings_linera);
        mobile_txt_chk = bottomSheetDialog.findViewById(R.id.mobile_txt_chk);
        email_txt_chk = bottomSheetDialog.findViewById(R.id.email_txt_chk);
        business_txt_chk = bottomSheetDialog.findViewById(R.id.business_txt_chk);

        mobile_txt_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    mobile.setVisibility(View.VISIBLE);
                } else {
                    mobile.setVisibility(View.GONE);

                }
            }
        });

        email_txt_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    email_txt.setVisibility(View.VISIBLE);
                } else {
                    email_txt.setVisibility(View.GONE);

                }
            }
        });

        business_txt_chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    f_web.setVisibility(View.VISIBLE);
                } else {
                    f_web.setVisibility(View.GONE);

                }
            }
        });


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


        if (requestCode == 1) {

            if (data != null) {
                Uri selectedImage = data.getData();
                image.setImageURI(selectedImage);
            }

//            Bitmap bitmap;
//            try {
//                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage));
//                image.setImageBitmap(bitmap);
//
//            } catch (FileNotFoundException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
        } else if (requestCode == 2) {
            if (data != null) {
                Uri selectedImage = data.getData();
                img_logo.setImageURI(selectedImage);
            }
        }
    }


}