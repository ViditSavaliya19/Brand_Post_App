//package com.example.brand_post.Activity;
//
//
//import static com.example.brand_post.Activity.SpleshActivity.sub_modelList;
//
//import androidx.annotation.RequiresApi;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.annotation.SuppressLint;
//import android.os.Build;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.Toast;
//
//import com.example.brand_post.Adapter.Rv_Adapter;
//import com.example.brand_post.R;
//import com.example.brand_post.Util.Model.Sub_Model;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.Locale;
//
//public class MainActivity extends AppCompatActivity {
//
//    private RecyclerView recycler_trending;
//    public static List<Sub_Model> filter_date_cate = new ArrayList<Sub_Model>();
//    private String formattedDate;
//    private SimpleDateFormat dateFormat;
//    List<String> date15 = new ArrayList<String>();
//
//    @SuppressLint("NewApi")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        setDate();
//
//
//        recycler_trending = findViewById(R.id.recycler_trending);
//        data_filter();
//        Recycler_view();
//    }
//
//
//    void data_filter() {
//
//        for (int i = 0; i < sub_modelList.size(); i++) {
//            for (int j = 0; j < date15.size(); j++) {
//                if (sub_modelList.get(i).getDate().equals(date15.get(j))) {
//
//                    String id = sub_modelList.get(i).getId();
//                    String title = sub_modelList.get(i).getC_id();
//                    String body = sub_modelList.get(i).getDate();
//                    String body2 = sub_modelList.get(i).getName();
//
//                    Sub_Model model = new Sub_Model();
//                    model.setId(id);
//                    model.setC_id(title);
//                    model.setDate(body);
//                    model.setName(body2);
//
//                    filter_date_cate.add(model);
//                }
//            }
//        }
//    }
//
//
//    void Recycler_view() {
//        Rv_Adapter adapter = new Rv_Adapter(MainActivity.this, filter_date_cate);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false);
//        recycler_trending.setLayoutManager(layoutManager);
//        recycler_trending.setAdapter(adapter);
//    }
//
//
//    @RequiresApi(api = Build.VERSION_CODES.O)
//    void setDate() {
//        Date c = Calendar.getInstance().getTime();
//        System.out.println("Current time => " + c);
//
//        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
//        String formattedDate = df.format(c);
//
//        addOneDay(c);
//
//    }
//
//
//    public void addOneDay(Date date) {
//
//        for (int i = 0; i <= 15; i++) {
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(date);
//            cal.add(Calendar.DATE, i); //minus number would decrement the days
//            Date d = cal.getTime();
//
//            SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
//            String formattedDate = df.format(d);
//
//            Toast.makeText(MainActivity.this, "" + formattedDate, Toast.LENGTH_SHORT).show();
//            Log.e("TAG", "addOneDay: " + formattedDate);
//            date15.add(formattedDate);
//
//        }
//
//    }
//
//
//}