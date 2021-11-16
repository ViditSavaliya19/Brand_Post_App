package com.example.brand_post.Util.Stickers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

public class StickerTextView extends StickerViewtxt {

private String owner_id;
private TextView iv_main;
public StickerTextView(Context context) {
    super(context);
}

public StickerTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
}

public StickerTextView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
}

public void setOwnerId(String owner_id){
    this.owner_id = owner_id;
}

public String getOwnerId(){
    return this.owner_id;
}

@RequiresApi(api = Build.VERSION_CODES.O)
@Override
public View getMainView() {
    if(this.iv_main == null) {
        this.iv_main = new TextView(getContext());
//        this.iv_main.getAutoSizeTextType()
        this.iv_main.setAutoSizeTextTypeUniformWithConfiguration(1,17,1, TypedValue.COMPLEX_UNIT_DIP);
    }
    return iv_main;
}


public void setText(String res_id){
    this.iv_main.setText(res_id);
}

public String getImageBitmap(){ return this.iv_main.getText().toString(); }}