package com.example.brand_post.Activity.Create_post;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static com.example.brand_post.Activity.PostList.Post_list.filter_post_List1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brand_post.Adapter.FontStyleAdapter;
import com.example.brand_post.Adapter.Fram_Adapter;
import com.example.brand_post.Adapter.Post_Adapter;

import com.example.brand_post.StickerAdapter;
import com.example.brand_post.StickerView;
import com.example.brand_post.Util.MTouch.MultiTouchListener;
import com.example.brand_post.R;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.Model.Model_Ragister;

import com.google.android.material.bottomsheet.BottomSheetDialog;


import java.util.ArrayList;
import java.util.List;

import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;
import yuku.ambilwarna.AmbilWarnaDialog;

public class Editing_post extends AppCompatActivity {
    private StickerView mCurrentView;
    private ArrayList<Integer> stickerlist;
    private LinearLayout bg;
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
    private LinearLayout text_edit;
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
    private LinearLayout setting_image, add_logo;
    private LinearLayout settings_linera, sticker_bg;
    private LinearLayout fram_color;
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
    String[] perms = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private TextView f_web;
    public static CheckBox mobile_txt_chk, email_txt_chk, business_txt_chk;
    CardView e_edit_text_sticker_card;
    private ImageView align_left;

    private StickerAdapter stickerAdapter;
    private Integer stickerId;
    private FrameLayout frame_sticker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editing_post);


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

        frame_sticker=findViewById(R.id.frame_sticker);

//        setting_image = findViewById(R.id.setting_image);
        email_txt = findViewById(R.id.f_email);
        fram_color = findViewById(R.id.fram_color);
        bottom_design = findViewById(R.id.bottom_design);
        e_save_btn = findViewById(R.id.e_save_btn);
        e_rv_view_frame = findViewById(R.id.e_rv_view_frame);
        indicator1 = findViewById(R.id.indicator1);

        //CONROLES ID;

        grid_fontstyle = findViewById(R.id.grid_fontstyle);
        f_size = findViewById(R.id.f_size);
        m_size = findViewById(R.id.m_size);
        f_color = findViewById(R.id.f_color);

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


        Fram_Adapter fram_adapter = new Fram_Adapter(Editing_post.this, layout_fram);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        e_rv_view_frame.setLayoutManager(layoutManager);
        e_rv_view_frame.setAdapter(fram_adapter);
        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        linearSnapHelper.attachToRecyclerView(e_rv_view_frame);
        indicator1.attachToRecyclerView(e_rv_view_frame);

        title_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addTextDailog(0);
                add_text_edt.setText(title_text.getText());
            }
        });


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
        fram_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFxDialog();
            }
        });
        text_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTextDailog(0);
            }
        });


        framlayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (mCurrentView != null) {
                    mCurrentView.setInEdit(false);
                }
                return false;
            }
        });

        Font();

        bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean val = checkPermission();
                if (val) {
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickPhoto, 1);
                } else {
                    requestPermission();
                }

            }
        });


        // ADD LOGO ===========
        add_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean val = checkPermission();
                if (val) {
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickPhoto, 2);
                } else {
                    requestPermission();
                }
            }
        });
    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);

        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {

        ActivityCompat.requestPermissions(Editing_post.this, perms, 200);

    }


    void addTextDailog(int opreation) {

        dialog = new Dialog(Editing_post.this);
        dialog.setContentView(R.layout.add_text_item);
        add_text_edt = dialog.findViewById(R.id.add_text_edt);
        Button add_text_btn = dialog.findViewById(R.id.add_text_btn);

        add_text_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title_text.setText(add_text_edt.getText().toString());
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


    }


    private void Rv_Post() {
        Post_Adapter adapter = new Post_Adapter(Editing_post.this, filter_post_List1, id);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(Editing_post.this, 3);
        rv_view.setLayoutManager(layoutManager);
        rv_view.setAdapter(adapter);
    }

    private void Rv_Color() {

        Dialog dialog = new Dialog(Editing_post.this);
        dialog.setContentView(R.layout.sticker_dialog);
        dialog.show();


//        Color_Adapter adapter = new Color_Adapter(Editing_post.this, getResources().getIntArray(R.array.rainbow));
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Editing_post.this, LinearLayoutManager.HORIZONTAL, false);
//        rv_view.setLayoutManager(layoutManager);
//        rv_view.setAdapter(adapter);
    }

    private void showFxDialog() {

        final Dialog dial = new Dialog(this, android.R.style.Theme_Translucent);
        dial.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dial.setContentView(R.layout.sticker_dialog);
        dial.setCancelable(true);
        dial.setCanceledOnTouchOutside(false);


        stickerlist = new ArrayList<>();
        final GridView grid_sticker = (GridView) dial.findViewById(R.id.gridStickerList);
//        setStickerList1();
//        stickerAdapter = new StickerAdapter(getApplicationContext(), stickerlist);
//        grid_sticker.setAdapter(stickerAdapter);

        stickerlist.clear();
        setStickerList1();
        stickerAdapter = new StickerAdapter(getApplicationContext(), stickerlist);
        grid_sticker.setAdapter(stickerAdapter);

        grid_sticker.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final StickerView stickerView = new StickerView(Editing_post.this);
                stickerId = stickerlist.get(i);
                stickerView.setImageResource(stickerId);
                stickerView.setOperationListener(new StickerView.OperationListener() {
                    @Override
                    public void onDeleteClick() {
                        framlayout.removeView(stickerView);
                    }

                    @Override
                    public void onEdit(StickerView stickerView) {
                        mCurrentView.setInEdit(false);
                        mCurrentView = stickerView;
                        mCurrentView.setInEdit(true);
                    }

                    @Override
                    public void onTop(StickerView stickerView) {
                    }
                });
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT, Gravity.CENTER);
                stickerView.setLayoutParams(new FrameLayout.LayoutParams(200, 200, Gravity.CENTER));
                frame_sticker.addView(stickerView, lp);
                setCurrentEdit(stickerView);
                dial.dismiss();
            }
        });
        dial.show();
    }

    private void setCurrentEdit(StickerView stickerView) {
        if (mCurrentView != null) {
            mCurrentView.setInEdit(false);
        }
        mCurrentView = stickerView;
        stickerView.setInEdit(true);
    }

    private void setStickerList1() {
        stickerlist.add(R.drawable.close);
        stickerlist.add(R.drawable.close);
        stickerlist.add(R.drawable.close);
        stickerlist.add(R.drawable.close);
        stickerlist.add(R.drawable.close);
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