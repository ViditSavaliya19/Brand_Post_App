package com.example.brand_post.Adapter;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.brand_post.Activity.Editing_post;
import com.example.brand_post.R;


public class FontStyleAdapter extends BaseAdapter {

    Activity activity;
    LayoutInflater inflater;

    public FontStyleAdapter(Editing_post textEditActivity) {
        activity = textEditActivity;
        inflater = LayoutInflater.from(activity);
    }

    @Override
    public int getCount() {
        return 19;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        view = inflater.inflate(R.layout.fontstyle, null, false);
        TextView textView = (TextView) view.findViewById(R.id.fonttext);

        switch (position) {
            case 0:
                Typeface typeface = Typeface.createFromAsset(activity.getAssets(), "font/font1.ttf");
                textView.setTypeface(typeface);
                break;

            case 1:
                Typeface typeface1 = Typeface.createFromAsset(activity.getAssets(), "font/font2.ttf");
                textView.setTypeface(typeface1);
                break;

            case 2:
                Typeface typeface2 = Typeface.createFromAsset(activity.getAssets(), "font/font3.ttf");
                textView.setTypeface(typeface2);
                break;

            case 3:
                Typeface typeface3 = Typeface.createFromAsset(activity.getAssets(), "font/font4.TTF");
                textView.setTypeface(typeface3);
                break;

            case 4:
                Typeface typeface4 = Typeface.createFromAsset(activity.getAssets(), "font/font5.ttf");
                textView.setTypeface(typeface4);
                break;

            case 5:
                Typeface typeface5 = Typeface.createFromAsset(activity.getAssets(), "font/font6.TTF");
                textView.setTypeface(typeface5);
                break;

            case 6:
                Typeface typeface6 = Typeface.createFromAsset(activity.getAssets(), "font/font7.ttf");
                textView.setTypeface(typeface6);
                break;

            case 7:
                Typeface typeface7 = Typeface.createFromAsset(activity.getAssets(), "font/font8.ttf");
                textView.setTypeface(typeface7);
                break;

            case 8:
                Typeface typeface8 = Typeface.createFromAsset(activity.getAssets(), "font/font9.ttf");
                textView.setTypeface(typeface8);
                break;

            case 9:
                Typeface typeface9 = Typeface.createFromAsset(activity.getAssets(), "font/font10.TTF");
                textView.setTypeface(typeface9);
                break;

            case 10:
                Typeface typeface10 = Typeface.createFromAsset(activity.getAssets(), "font/font11.ttf");
                textView.setTypeface(typeface10);
                break;

            case 11:
                Typeface typeface11 = Typeface.createFromAsset(activity.getAssets(), "font/font12.ttf");
                textView.setTypeface(typeface11);
                break;

            case 12:
                Typeface typeface12 = Typeface.createFromAsset(activity.getAssets(), "font/font14.TTF");
                textView.setTypeface(typeface12);
                break;

            case 13:
                Typeface typeface13 = Typeface.createFromAsset(activity.getAssets(), "font/font16.TTF");
                textView.setTypeface(typeface13);
                break;

            case 14:
                Typeface typeface14 = Typeface.createFromAsset(activity.getAssets(), "font/font17.ttf");
                textView.setTypeface(typeface14);
                break;

            case 15:
                Typeface typeface15 = Typeface.createFromAsset(activity.getAssets(), "font/font18.ttf");
                textView.setTypeface(typeface15);
                break;

            case 16:
                Typeface typeface16 = Typeface.createFromAsset(activity.getAssets(), "font/font19.ttf");
                textView.setTypeface(typeface16);
                break;

            case 17:
                Typeface typeface17 = Typeface.createFromAsset(activity.getAssets(), "font/font20.ttf");
                textView.setTypeface(typeface17);
                break;

            case 18:
                Typeface typeface18 = Typeface.createFromAsset(activity.getAssets(), "font/font21.ttf");
                textView.setTypeface(typeface18);
                break;


        }
        LinearLayout linearLayout=(LinearLayout)view.findViewById(R.id.liner_font);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        ((Editing_post)activity).TextStyle(0);
                        break;

                    case 1:
                        ((Editing_post)activity).TextStyle(1);
                        break;

                    case 2:
                        ((Editing_post)activity).TextStyle(2);
                        break;

                    case 3:
                        ((Editing_post)activity).TextStyle(3);
                        break;

                    case 4:
                        ((Editing_post)activity).TextStyle(4);
                        break;

                    case 5:
                        ((Editing_post)activity).TextStyle(5);
                        break;

                    case 6:
                        ((Editing_post)activity).TextStyle(6);
                        break;

                    case 7:
                        ((Editing_post)activity).TextStyle(7);
                        break;

                    case 8:
                        ((Editing_post)activity).TextStyle(8);
                        break;

                    case 9:
                        ((Editing_post)activity).TextStyle(9);
                        break;

                    case 10:
                        ((Editing_post)activity).TextStyle(10);
                        break;

                    case 11:
                        ((Editing_post)activity).TextStyle(11);
                        break;

                    case 12:
                        ((Editing_post)activity).TextStyle(12);
                        break;

                    case 13:
                        ((Editing_post)activity).TextStyle(13);
                        break;

                    case 14:
                        ((Editing_post)activity).TextStyle(14);
                        break;

                    case 15:
                        ((Editing_post)activity).TextStyle(15);
                        break;

                    case 16:
                        ((Editing_post)activity).TextStyle(16);
                        break;

                    case 17:
                        ((Editing_post)activity).TextStyle(17);
                        break;

                    case 18:
                        ((Editing_post)activity).TextStyle(18);
                        break;
                }
            }
        });
        return view;
    }
}
