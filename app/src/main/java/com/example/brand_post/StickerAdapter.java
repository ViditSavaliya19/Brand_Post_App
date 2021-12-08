package com.example.brand_post;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class StickerAdapter extends BaseAdapter {
    Context context;
    ArrayList<Integer> stickers;
    private ViewHolder viewholder;
    private LayoutInflater inflater;
    ImageView img_editing;

    public StickerAdapter(Context context, ArrayList<Integer> stickers) {
        this.context = context;
        this.stickers = stickers;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return stickers.size();
    }

    @Override
    public Object getItem(int i) {
        return stickers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.sticker_item, null);
        }
        img_editing = (ImageView) convertView.findViewById(R.id.img_editing);
        int resource = stickers.get(position);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            img_editing.setClipToOutline(true);
        }
        Glide.with(context)
                .load(resource)
                .into(img_editing);
        System.gc();
        return convertView;
    }


    public class ViewHolder {
        ImageView img_gallery;
    }
}
