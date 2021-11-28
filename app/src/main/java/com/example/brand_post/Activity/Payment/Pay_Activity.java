package com.example.brand_post.Activity.Payment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.brand_post.R;
import com.example.brand_post.Util.Model.LoginRes;
import com.google.gson.Gson;
import com.paykun.sdk.PaykunApiCall;
import com.paykun.sdk.eventbus.Events;
import com.paykun.sdk.eventbus.GlobalBus;
import com.paykun.sdk.helper.PaykunHelper;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Pay_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);


        String name =getIntent().getStringExtra("Name");
        String Mobile = getIntent().getStringExtra("Mobile");
        String email = getIntent().getStringExtra("Email");
        String price = getIntent().getStringExtra("Price");

        CallPaykun(name,Mobile,email,price);
    }


    private void sendAndRequestResponse(){
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://192.168.0.100/api/Users/UserLogin";
/*
// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,  new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        //textView.setText("Response is: "+ response.substring(0,500));
                        //String json = response.toString();
                        //JsonResponse convertedObject = new Gson().fromJson(json, JsonResponse.class);

                        Toast.makeText(getApplicationContext(),"Response :" + response.toString(), Toast.LENGTH_LONG).show();

                        String data=new String(response.toString());
                        LoginRes wb=new Gson().fromJson(data,LoginRes.class);
                        Toast.makeText(getApplicationContext(),"Response :" + wb.data.RazorpayKey, Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                textView.setText("That didn't work!");
                Toast.makeText(getApplicationContext(),"Error :" + error.toString(), Toast.LENGTH_LONG).show();
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
*/

        JSONArray array = new JSONArray();

        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("MobileNo1","9876543212");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        array.put(jsonObject);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(getApplicationContext(),"Response :" + response.toString(), Toast.LENGTH_LONG).show();

                        String data=new String(response.toString());
                        LoginRes wb=new Gson().fromJson(data,LoginRes.class);
                        if(wb.status==true)
                        {Toast.makeText(getApplicationContext(),"Response :" + wb.data.RazorpayKeySecret, Toast.LENGTH_LONG).show();}
                        else {
                            Toast.makeText(getApplicationContext(),"Error :" + wb.message, Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Toast.makeText(getApplicationContext(),"Error :" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                });

        queue.add(jsonObjectRequest);
    }

    private void Successcall(Events.PaymentMessage message){
        Toast.makeText(getApplicationContext(),"Successcall "+message.getTransactionId()+" => "+message.getTransactionDetail() , Toast.LENGTH_LONG).show();
    }

    private void CallPaykun(String name, String mobile, String email, String price){
        JSONObject object = new JSONObject();
        try {
            object.put("merchant_id","013878045770091");
            object.put("access_token","D081167F0D52809DB7EF4DE2F9A9F789");//""1CEAA01C7A2153B78D5317D87D1FF2F2");
            object.put("customer_name","Bhavik Makvana");
            object.put("customer_email","bhavik.makvana@paykun.com");
            object.put("customer_phone","9876543210");
            object.put("product_name","PayKunProduct");
            object.put("order_no",System.currentTimeMillis()); // order no. should have 10 to 30 character in numeric format
            object.put("amount","10");  // minimum amount should be 10
            object.put("isLive",false);  // need to send false if you are in sandbox mode
        } catch (JSONException e) {
            e.printStackTrace();
        }
        new PaykunApiCall.Builder(Pay_Activity.this).sendJsonObject(object);
        // Paykun api to initialize your payment and send info.
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void getResults(Events.PaymentMessage message) {
        if(message.getResults().equalsIgnoreCase(PaykunHelper.MESSAGE_SUCCESS)){
            // do your stuff here
            // message.getTransactionId() will return your failed or succeed transaction id
            /* if you want to get your transaction detail call message.getTransactionDetail()
             *  getTransactionDetail return all the field from server and you can use it here as per your need
             *  For Example you want to get Order id from detail use message.getTransactionDetail().order.orderId */
            if(!TextUtils.isEmpty(message.getTransactionId())) {
                Toast.makeText(Pay_Activity.this, "Your Transaction is succeed with transaction id : "+message.getTransactionId() , Toast.LENGTH_SHORT).show();
                Log.v(" order id "," getting order id value : "+message.getTransactionDetail().order.orderId);
                Successcall(message);
            }
        }
        else if(message.getResults().equalsIgnoreCase(PaykunHelper.MESSAGE_FAILED)){
            // do your stuff here
            Toast.makeText(Pay_Activity.this,"Your Transaction is failed",Toast.LENGTH_SHORT).show();
            Successcall(message);
        }
        else if(message.getResults().equalsIgnoreCase(PaykunHelper.MESSAGE_SERVER_ISSUE)){
            // do your stuff here
            Toast.makeText(Pay_Activity.this,PaykunHelper.MESSAGE_SERVER_ISSUE,Toast.LENGTH_SHORT).show();
        }else if(message.getResults().equalsIgnoreCase(PaykunHelper.MESSAGE_ACCESS_TOKEN_MISSING)){
            // do your stuff here
            Toast.makeText(Pay_Activity.this,"Access Token missing",Toast.LENGTH_SHORT).show();
        }
        else if(message.getResults().equalsIgnoreCase(PaykunHelper.MESSAGE_MERCHANT_ID_MISSING)){
            // do your stuff here
            Toast.makeText(Pay_Activity.this,"Merchant Id is missing",Toast.LENGTH_SHORT).show();
        }
        else if(message.getResults().equalsIgnoreCase(PaykunHelper.MESSAGE_INVALID_REQUEST)){
            Toast.makeText(Pay_Activity.this,"Invalid Request",Toast.LENGTH_SHORT).show();
        }
        else if(message.getResults().equalsIgnoreCase(PaykunHelper.MESSAGE_NETWORK_NOT_AVAILABLE)){
            Toast.makeText(Pay_Activity.this,"Network is not available",Toast.LENGTH_SHORT).show();
        }
    }

//    private static final String TAG = Pay_Activity.class.getName();
//
//    private RequestQueue mRequestQueue;
//    private StringRequest mStringRequest;
//    private String url = "http://192.168.0.100/api/Users/UserLogin";
//    private void sendAndRequestResponse() {
//
//        //RequestQueue initialized
//        RequestQueue mRequestQueue = Volley.newRequestQueue(this);
//
//        //String Request initialized
//        mStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                //Gson g = new Gson();
//                //JsonResponse p = g.fromJson(response.toString(), JsonResponse.class);
//
//                //JSONParser parser = new JSONParser();
//                //JsonResponse json = (JsonResponse) parser.parse(response.toString());
//
//                //JsonResponse obj = new JSONObject(response.toString());
//                Toast.makeText(getApplicationContext(),"Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen
//                //Toast.makeText(getApplicationContext(),"UserId :" + p.DataObject.getUserId(), Toast.LENGTH_LONG).show();//display the response on screen
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//                Log.i(TAG,"Error1 :" + error.toString());
//                Toast.makeText(getApplicationContext(),"Error1 :" + error.toString(), Toast.LENGTH_LONG).show();
//            }
//        });
//
//        mRequestQueue.add(mStringRequest);
//    }

    @Override
    protected void onStart() {
        super.onStart();
        // Register this activity to listen to event.
        GlobalBus.getBus().register(this);
    }
    @Override
    protected void onStop() {
        super.onStop();
        // Unregister from activity
        GlobalBus.getBus().unregister(this);
    }
}