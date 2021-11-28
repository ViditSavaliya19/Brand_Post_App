package com.example.brand_post.Util.Model;


import java.util.List;

public class LoginRes {
    public Data data;
    public String message;
    public Boolean status;

    public class Data {


        public Integer userId;
        public String Name;
        public String MobileNo;

        public String Email;

        public String AadharNo;

        public String PanNo;

        public String AadharImage1;
        public String AadharImage2;
        public String PanImage;

        public String Message;

        public String RazorpayKey;

        public String RazorpayKeySecret;

    }

}