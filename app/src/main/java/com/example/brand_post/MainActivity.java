package com.example.brand_post;


import static com.example.brand_post.Activity.SpleshActivity.postModelList;
import static com.example.brand_post.Activity.SpleshActivity.sub_modelList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.brand_post.Adapter.Rv_Adapter;
import com.example.brand_post.Util.Model.PostModel;
import com.example.brand_post.Util.Model.Sub_Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler_trending;
    public static List<Sub_Model> filter_date_cate = new ArrayList<Sub_Model>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        String formattedDate = df.format(c);


        recycler_trending=findViewById(R.id.recycler_trending);
        data_filter();
        Recycler_view();
    }


    void data_filter()
    {



        for(int i=0;i<sub_modelList.size();i++)
        {
            if(sub_modelList.get(i).getDate().equals("11/04/2021"))
            {
                String id = sub_modelList.get(i).getId();
                String title = sub_modelList.get(i).getC_id();
                String body = sub_modelList.get(i).getDate();
                String body2 = sub_modelList.get(i).getName();

                Sub_Model model = new Sub_Model();
                model.setId(id);
                model.setC_id(title);
                model.setDate(body);
                model.setName(body2);

                filter_date_cate.add(model);
            }
        }
    }




    void Recycler_view()
    {
        Rv_Adapter adapter=new Rv_Adapter(MainActivity.this,filter_date_cate);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false);
        recycler_trending.setLayoutManager(layoutManager);
        recycler_trending.setAdapter(adapter);
    }

}