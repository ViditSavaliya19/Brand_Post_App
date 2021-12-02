package com.example.brand_post.Fragments;

import static com.example.brand_post.Activity.Main.SpleshActivity.slider_list_s;
import static com.example.brand_post.Activity.Main.SpleshActivity.sub_modelList;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.example.brand_post.Activity.Main.SpleshActivity;
import com.example.brand_post.Adapter.Rv_Adapter;
import com.example.brand_post.Adapter.Rv_trending_Adapter;
import com.example.brand_post.Adapter.Selecct_business_Adapter;
import com.example.brand_post.Adapter.SliderAdapterExample;
import com.example.brand_post.R;
import com.example.brand_post.Util.Constant;
import com.example.brand_post.Util.Model.BusinessDatum;
import com.example.brand_post.Util.Model.Sub_Model;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;


public class Dashbord_Fragment extends Fragment {

    String[] perms = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    int permsRequestCode = 200;

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
    public static CircleImageView circle_profile;
    private Date[] date;
    public static TextView email_profile_h;
    public static TextView name_profile_h;
    public static BottomSheetDialog sheetDialog;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashbord_, container, false);

        requestPermission();

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
        email_profile_h = view.findViewById(R.id.email_profile_h);
        name_profile_h = view.findViewById(R.id.name_profile_h);

        setBusiness_header();

        circle_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Select_Corrunt_Business();
            }
        });


        Slider();

        data_filter();


        return view;
    }

    public void Slider() {
        SliderAdapterExample adapterExample = new SliderAdapterExample(getActivity(), slider_list_s);
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


    public void Select_Corrunt_Business() {
        sheetDialog = new BottomSheetDialog(getActivity());
        sheetDialog.setContentView(R.layout.select_business_item);
        sheetDialog.show();
        RecyclerView rv_select_business = sheetDialog.findViewById(R.id.rv_select_business);
        Selecct_business_Adapter selecct_business_adapter = new Selecct_business_Adapter(getActivity(), SpleshActivity.businessData_list_s);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rv_select_business.setLayoutManager(layoutManager);
        rv_select_business.setAdapter(selecct_business_adapter);

    }


    void setBusiness_header() {
        Constant constant = new Constant();
        BusinessDatum businessDatum = constant.getSelected_business(getActivity());

        Glide.with(getActivity()).load(Constant.imageLink + businessDatum.getLogo()).into(circle_profile);
        email_profile_h.setText(businessDatum.getEmail());
        name_profile_h.setText(businessDatum.getName());


    }

    private void requestPermission() {

        ActivityCompat.requestPermissions(getActivity(), perms, permsRequestCode);

    }

    @Override
    public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults) {

        switch (permsRequestCode) {

            case 200:

                boolean locationAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean cameraAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                break;

        }

    }

}