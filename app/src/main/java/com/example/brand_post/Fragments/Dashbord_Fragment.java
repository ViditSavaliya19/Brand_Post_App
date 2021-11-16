package com.example.brand_post.Fragments;

import static com.example.brand_post.Activity.SpleshActivity.slider_list_s;
import static com.example.brand_post.Activity.SpleshActivity.sub_modelList;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.brand_post.Adapter.Rv_Adapter;
import com.example.brand_post.Adapter.Rv_day_Adapter;
import com.example.brand_post.Adapter.Rv_trending_Adapter;
import com.example.brand_post.Adapter.SliderAdapterExample;
import com.example.brand_post.R;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.Model.Sub_Model;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;


public class Dashbord_Fragment extends Fragment {

    private RecyclerView recycler_trending;
    public static List<Sub_Model> filter_date_cate = new ArrayList<Sub_Model>();
    public static List<Sub_Model> filter_date_cate_days = new ArrayList<Sub_Model>();
    public static List<Sub_Model> filter_date_cate_daily_post = new ArrayList<Sub_Model>();
    public static List<Sub_Model> filter_date_cate_all_days = new ArrayList<Sub_Model>();
    private String formattedDate;
    private SimpleDateFormat dateFormat;
    List<String> date15 = new ArrayList<String>();
    private SliderView imageSlider;
    private RecyclerView recycler_upcoming, recycler_daily, recycler_all;
    private NavigationView nav_drawer;
    private DrawerLayout drawer;
    private CircleImageView circle_profile;
    private Date[] date;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashbord_, container, false);

        date15.clear();
        setDate();


        filter_date_cate.clear();
        filter_date_cate_days.clear();
        filter_date_cate_daily_post.clear();
        filter_date_cate_all_days.clear();

        imageSlider = view.findViewById(R.id.imageSlider);
        recycler_trending = view.findViewById(R.id.recycler_trending);
        recycler_upcoming = view.findViewById(R.id.recycler_upcoming);
        recycler_daily = view.findViewById(R.id.recycler_daily);
        recycler_all = view.findViewById(R.id.recycler_all);
        drawer = view.findViewById(R.id.drawer);
        circle_profile = view.findViewById(R.id.circle_profile);


       Slider();

        data_filter();


        return view;
    }

    public void Slider() {
        SliderAdapterExample adapterExample = new SliderAdapterExample(getActivity(),slider_list_s);
        imageSlider.setSliderAdapter(adapterExample);
        imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM);
        imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        imageSlider.startAutoCycle();

    }

    void data_filter() {
        filter_date_cate.clear();
        filter_date_cate_days.clear();
        filter_date_cate_daily_post.clear();
        filter_date_cate_all_days.clear();
        for (int i = 0; i < sub_modelList.size(); i++) {
            for (int j = 0; j < date15.size(); j++) {
                if (sub_modelList.get(i).getDate().equals(date15.get(j))) {

                    if (sub_modelList.get(i).getType().equals("0")) {
                        String id = sub_modelList.get(i).getId();
                        String title = sub_modelList.get(i).getC_id();
                        String body = sub_modelList.get(i).getDate();
                        String body2 = sub_modelList.get(i).getName();
                        String body3 = sub_modelList.get(i).getImage();

                        Sub_Model model = new Sub_Model();
                        model.setId(id);
                        model.setC_id(title);
                        model.setDate(body);
                        model.setName(body2);
                        model.setImage(body3);

                        filter_date_cate.add(model);

                    } else if (sub_modelList.get(i).getType().equals("1")) {
                        String id = sub_modelList.get(i).getId();
                        String title = sub_modelList.get(i).getC_id();
                        String body = sub_modelList.get(i).getDate();
                        String body2 = sub_modelList.get(i).getName();
                        String body3 = sub_modelList.get(i).getImage();

                        Sub_Model model = new Sub_Model();
                        model.setId(id);
                        model.setC_id(title);
                        model.setDate(body);
                        model.setName(body2);
                        model.setImage(body3);

                        filter_date_cate_days.add(model);

                    } else if (sub_modelList.get(i).getType().equals("2")) {
                        String id = sub_modelList.get(i).getId();
                        String title = sub_modelList.get(i).getC_id();
                        String body = sub_modelList.get(i).getDate();
                        String body2 = sub_modelList.get(i).getName();
                        String body3 = sub_modelList.get(i).getImage();

                        Sub_Model model = new Sub_Model();
                        model.setId(id);
                        model.setC_id(title);
                        model.setDate(body);
                        model.setName(body2);
                        model.setImage(body3);

                        filter_date_cate_daily_post.add(model);

                    } else if (sub_modelList.get(i).getType().equals("3")) {
                        String id = sub_modelList.get(i).getId();
                        String title = sub_modelList.get(i).getC_id();
                        String body = sub_modelList.get(i).getDate();
                        String body2 = sub_modelList.get(i).getName();
                        String body3 = sub_modelList.get(i).getImage();

                        Sub_Model model = new Sub_Model();
                        model.setId(id);
                        model.setC_id(title);
                        model.setDate(body);
                        model.setName(body2);
                        model.setImage(body3);

                        filter_date_cate_all_days.add(model);

                    }
                }
            }
        }

        Collections.sort(filter_date_cate, new Comparator<Sub_Model>() {
            @Override
            public int compare(Sub_Model item1, Sub_Model item2) {
                return item1.getDate().compareToIgnoreCase(item2.getDate());

            }
        });


        Collections.sort(filter_date_cate_days, new Comparator<Sub_Model>() {
            @Override
            public int compare(Sub_Model item1, Sub_Model item2) {
                return item1.getDate().compareToIgnoreCase(item2.getDate());

            }
        });


        Collections.sort(filter_date_cate_daily_post, new Comparator<Sub_Model>() {
            @Override
            public int compare(Sub_Model item1, Sub_Model item2) {
                return item1.getDate().compareToIgnoreCase(item2.getDate());

            }
        });

        Collections.sort(filter_date_cate_all_days, new Comparator<Sub_Model>() {
            @Override
            public int compare(Sub_Model item1, Sub_Model item2) {
                return item1.getDate().compareToIgnoreCase(item2.getDate());

            }
        });

        Recycler_view();
        Recycler_view_day();
        Recycler_view_daily_post();
        Recycler_view_all_day();
    }


    void Recycler_view() {
        Rv_Adapter adapter = new Rv_Adapter(getActivity(), filter_date_cate);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        recycler_trending.setLayoutManager(layoutManager);
        recycler_trending.setAdapter(adapter);
    }

    void Recycler_view_day() {
        Rv_trending_Adapter adapter = new Rv_trending_Adapter(getActivity(), filter_date_cate_days);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        recycler_upcoming.setLayoutManager(layoutManager);
        recycler_upcoming.setAdapter(adapter);
    }

    void Recycler_view_daily_post() {
        Rv_trending_Adapter adapter = new Rv_trending_Adapter(getActivity(), filter_date_cate_daily_post);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        recycler_daily.setLayoutManager(layoutManager);
        recycler_daily.setAdapter(adapter);
    }

    void Recycler_view_all_day() {
        Rv_trending_Adapter adapter = new Rv_trending_Adapter(getActivity(), filter_date_cate_all_days);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        recycler_all.setLayoutManager(layoutManager);
        recycler_all.setAdapter(adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    void setDate() {
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);

        addOneDay(c);

    }


    public void addOneDay(Date date) {

        for (int i = 0; i <= 15; i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, i); //minus number would decrement the days
            Date d = cal.getTime();

            SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
            String formattedDate = df.format(d);

            Toast.makeText(getActivity(), "" + formattedDate, Toast.LENGTH_SHORT).show();
            Log.e("TAG", "addOneDay: " + formattedDate);
            date15.add(formattedDate);

        }

    }


}