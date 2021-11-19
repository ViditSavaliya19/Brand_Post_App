package com.example.brand_post.Util.Stickers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.widget.TextViewCompat;


public class StickerTextView extends StickerViewtxt {

    private String owner_id;
    private AutoResizeTextView iv_main;

    public StickerTextView(Context context) {
        super(context);
    }

    public StickerTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StickerTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setOwnerId(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getOwnerId() {
        return this.owner_id;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View getMainView() {
        if (this.iv_main == null) {
            this.iv_main = new AutoResizeTextView(getContext());
            this.iv_main.setGravity(Gravity.CENTER);

//            this.iv_main.setAutoSizeTextTypeUniformWithConfiguration(1, 17, 1, TypedValue.COMPLEX_UNIT_DIP);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            );
            params.gravity = Gravity.CENTER;
            this.iv_main.setLayoutParams(params);
            if (getImageViewFlip() != null)
                getImageViewFlip().setVisibility(View.GONE);
        }
        return iv_main;
    }


    public void setText(String res_id) {
        this.iv_main.setText(res_id);
    }


    public void setTextColor(int res_id) {
        this.iv_main.setTextColor(res_id);
    }

    public void setAlignment(int res_id) {
        this.iv_main.setGravity(res_id);
    }


    public void setStyle(String res_id) {
        this.iv_main.setText(res_id);
    }

    public static float pixelsToSp(Context context, float px) {
        float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        return px/scaledDensity;
    }


    public String getImageBitmap() {
        return this.iv_main.getText().toString();
    }

    @Override
    protected void onScaling(boolean scaleUp) {

        super.onScaling(scaleUp);
    }


}