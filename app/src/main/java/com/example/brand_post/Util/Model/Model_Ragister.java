package com.example.brand_post.Util.Model;

public class Model_Ragister {

    String name,email,password,business_name,profile_image,mobile,plan;

    public Model_Ragister(String name, String email, String password, String business_name, String profile_image, String mobile, String plan) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.business_name = business_name;
        this.profile_image = profile_image;
        this.mobile = mobile;
        this.plan = plan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }
}
